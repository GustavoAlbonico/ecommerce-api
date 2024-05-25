package com.store.pandora.api.controllers;
import com.store.pandora.api.useCases.estoque.EstoqueService;
import com.store.pandora.api.useCases.estoque.domains.EstoqueResponseDom;
import com.store.pandora.api.useCases.estoque.domains.EstoqueResquestDom;
import com.store.pandora.api.utils.CustomException;
import com.store.pandora.api.utils.ResponseUtil;
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
            EstoqueResponseDom response = estoqueService.carregarEstoqueById(id);

            if(response != null){
                return  ResponseEntity.ok().body(response);
            }
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum item em estoque cadastrado com esse id!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @GetMapping("/carregar")
    public ResponseEntity<?> carregarEstoque(){
        try{
            List<EstoqueResponseDom> responseList = estoqueService.carregarEstoque();
            if(responseList.isEmpty()){
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum item em estoque cadastrado com esse id!"));
            }
            return ResponseEntity.ok().body(responseList);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarEstoque(@RequestBody EstoqueResquestDom estoque) {
        try {
            EstoqueResponseDom response = estoqueService.criarEstoque(estoque);
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
    public ResponseEntity<?> atualizarEstoque(@PathVariable Long id, @RequestBody EstoqueResquestDom estoque) {
        try {
            EstoqueResponseDom response = estoqueService.atualizarEstoque(id, estoque);
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

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> excluirEstoque(@PathVariable Long id){
        try {
            estoqueService.excluirEstoque(id);
            return ResponseEntity.ok(null);
        } catch (Exception ex) {
            return  ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }
}
