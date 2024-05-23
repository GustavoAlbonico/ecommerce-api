package com.store.pandora.api.controllers;

import com.store.pandora.api.useCases.produto.ProdutoService;
import com.store.pandora.api.useCases.produto.domains.ProdutoRequestDom;
import com.store.pandora.api.useCases.produto.domains.ProdutoResponseDom;
import com.store.pandora.api.utils.CustomException;
import com.store.pandora.api.utils.ResponseUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/carregar/{id}")
    public ResponseEntity<?> carregarEstoqueById(@PathVariable Long id){
        try{
            ProdutoResponseDom response = estoqueService.carregarProdutoById(id);

            if(response != null){
                return  ResponseEntity.ok().body(response);
            }
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum produto cadastrado!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @GetMapping("/carregar")
    public ResponseEntity<?> carregarEstoque(){
        try{
            List<ProdutoResponseDom> responseList = estoqueService.carregarProduto();
            if(responseList.isEmpty()){
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum produto cadastrado!"));
            }
            return ResponseEntity.ok().body(responseList);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarEstoque(@RequestBody ProdutoRequestDom produto) {
        try {
            ProdutoResponseDom response = estoqueService.criarEstoque(produto);
            return ResponseEntity.status(201).body(response);
        } catch (CustomException ce) {
            ce.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        } catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarEstoque(@PathVariable Long id, @RequestBody ProdutoRequestDom produto) {
        try {
            ProdutoResponseDom response = estoqueService.atualizarEstoque(id, produto);
            if(response == null) {
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Erro inesperado!"));
            }
            return ResponseEntity.ok(response);
        } catch (CustomException ce) {
            ce.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        } catch (Exception ex) {
            return  ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }
}
