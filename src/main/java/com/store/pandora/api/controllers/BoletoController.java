package com.store.pandora.api.controllers;

import com.store.pandora.api.useCases.boleto.BoletoService;
import com.store.pandora.api.useCases.boleto.domains.BoletoRequestDom;
import com.store.pandora.api.useCases.boleto.domains.BoletoResponseDom;
import com.store.pandora.api.utils.CustomException;
import com.store.pandora.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("boleto")
public class BoletoController {
    @Autowired
    private BoletoService boletoService;

    @GetMapping("/carregar/{id}")
    public ResponseEntity<?> carregarBoletoById(@PathVariable Long id) {
        try{
            BoletoResponseDom response = boletoService.carregarBoletoById(id);
            if(response != null){
                return  ResponseEntity.ok().body(response);
            }
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum boleto cadastrado com esse id!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @GetMapping("/carregar")
    public ResponseEntity<?> carregarBoleto(){
        try{
            List<BoletoResponseDom> responseList = boletoService.carregarBoleto();
            if(responseList.isEmpty()){
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum boleto cadastrado"));
            }
            return ResponseEntity.ok().body(responseList);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarBoleto(@RequestBody BoletoRequestDom boleto){
        try{
            BoletoResponseDom response = boletoService.criarBoleto(boleto);
            return ResponseEntity.status(201).body(response);
        }catch (CustomException ce){
            ce.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarBoleto(@PathVariable Long id, @RequestBody BoletoRequestDom boleto) {
        try {
            BoletoResponseDom response = boletoService.atualizarBoleto(id,boleto);
            return ResponseEntity.ok().body(response);
        } catch (CustomException ce){
            ce.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        } catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> excluirBoleto(@PathVariable Long id){
        try {
            boletoService.excluirBoleto(id);
            return ResponseEntity.ok(null);
        } catch (Exception ex) {
            return  ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }
}
