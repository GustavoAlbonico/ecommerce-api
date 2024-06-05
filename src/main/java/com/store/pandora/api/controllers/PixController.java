package com.store.pandora.api.controllers;

import com.store.pandora.api.useCases.cartao.domains.CartaoResponseDom;
import com.store.pandora.api.useCases.pix.PixService;
import com.store.pandora.api.useCases.pix.domains.PixRequestDom;
import com.store.pandora.api.useCases.pix.domains.PixResponseDom;
import com.store.pandora.api.utils.CustomException;
import com.store.pandora.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/pix")
public class PixController {

    @Autowired
    private PixService pixService;

    @GetMapping("/carregar/{id}")
    public ResponseEntity<?> carregarPixById(@PathVariable Long id){
        try{
            PixResponseDom response = pixService.carregarPixById(id);
            if(response != null){
                return  ResponseEntity.ok().body(response);
            }
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum pix cadastrado com esse id!"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @GetMapping("/carregar")
    public ResponseEntity<?> carregarPix(){
        try{
            List<PixResponseDom> responseList = pixService.carregarPix();
            if(responseList.isEmpty()){
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum pix cadastrado"));
            }
            return ResponseEntity.ok().body(responseList);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarPix(@RequestBody PixRequestDom pix){
        try{
            PixResponseDom response = pixService.criarPix(pix);
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
    public ResponseEntity<?> atualizarPix(@PathVariable Long id, @RequestBody PixRequestDom pix) {
        try {
            PixResponseDom response = pixService.atualizarPix(id,pix);
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
    public ResponseEntity<?> excluirPix(@PathVariable Long id){
        try {
            pixService.excluirPix(id);
            return ResponseEntity.ok(null);
        } catch (Exception ex) {
            return  ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }
}
