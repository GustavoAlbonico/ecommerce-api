package com.store.pandora.api.controllers;

import com.store.pandora.api.useCases.cartao.CartaoService;
import com.store.pandora.api.useCases.cartao.domains.CartaoRequestDom;
import com.store.pandora.api.useCases.cartao.domains.CartaoResponseDom;
import com.store.pandora.api.utils.CustomException;
import com.store.pandora.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarCartao(@RequestBody CartaoRequestDom cartao){
        try {
            CartaoResponseDom response = cartaoService.criarCartao(cartao);
            return ResponseEntity.status(201).body(response);
        }catch (CustomException ce){
            ce.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        }catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @GetMapping("/carregar/{id}")
    public ResponseEntity<?> carregarCartaoById(@PathVariable Long id){
        try{
            CartaoResponseDom response = cartaoService.carregarCartaoById(id);
            if(response != null){
                return  ResponseEntity.ok().body(response);
            }
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum cartao cadastrado com esse id!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @GetMapping("/carregar")
    public ResponseEntity<?> carregarCartao(){
        try{
            List<CartaoResponseDom> responseList = cartaoService.carregarCartao();
            if(responseList.isEmpty()){
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum cartao cadastrado"));
            }
            return ResponseEntity.ok().body(responseList);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarCartao(@PathVariable Long id, @RequestBody CartaoRequestDom cartao) {
        try {
            CartaoResponseDom response = cartaoService.atualizarCartao(id, cartao);
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
    public ResponseEntity<?> excluirCartao(@PathVariable Long id){
        try {
            cartaoService.excluirCartao(id);
            return ResponseEntity.ok(null);
        } catch (Exception ex) {
            return  ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }


}
