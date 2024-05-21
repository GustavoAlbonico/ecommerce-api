package com.store.pandora.api.controllers;

import com.store.pandora.api.useCases.produto.ProdutoService;
import com.store.pandora.api.useCases.produto.domains.ProdutoRequestDom;
import com.store.pandora.api.useCases.produto.domains.ProdutoResponseDom;
import com.store.pandora.api.utils.CustomException;
import com.store.pandora.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/carregar/{id}")
    public ResponseEntity<?> carregarUsuarioById(@PathVariable Long id){
        try{
            ProdutoResponseDom response = produtoService.carregarProdutoById(id);

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
    public ResponseEntity<?> carregarUsuario(){
        try{
            List<ProdutoResponseDom> responseList = produtoService.carregarProduto();
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
    public ResponseEntity<?> criarProduto(@RequestBody ProdutoRequestDom produto) {
        try {
            ProdutoResponseDom response = produtoService.criarProduto(produto);
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
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequestDom produto) {
        try {
            ProdutoResponseDom response = produtoService.atualizarProduto(id, produto);
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
