package com.store.pandora.api.controllers;

import com.store.pandora.api.useCases.endereco.EnderecoService;
import com.store.pandora.api.useCases.endereco.domains.EnderecoRequestDom;
import com.store.pandora.api.useCases.endereco.domains.EnderecoResponseDom;
import com.store.pandora.api.useCases.endereco.implement.repositorys.EnderecoRepository;
import com.store.pandora.api.utils.CustomException;
import com.store.pandora.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/carregar/{id}")
    public ResponseEntity <?> carregarEnderecoById(@PathVariable Long id) {

        try {
            EnderecoResponseDom response = enderecoService.carregarEnderecoById(id);

            if(response != null) {
                return ResponseEntity.ok().body(response);
            }

            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum endereço cadastrado"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado"));
        }

    }

    @GetMapping("/carregar")
    public ResponseEntity <?> carregarEndereco() {

        try {
            List<EnderecoResponseDom> responseList = enderecoService.carregarEndereco();

            if(responseList.isEmpty()) {
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum endereço cadastrado"));
            }

            return ResponseEntity.ok().body(responseList);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado"));
        }

    }

    @PostMapping("/criar")
    public ResponseEntity <?> criarEndereço(@RequestBody EnderecoRequestDom endereco) {

        try{
            EnderecoResponseDom response = enderecoService.criarEndereco(endereco);
            return ResponseEntity.status(201).body(response);
        } catch (CustomException ce) {
            ce.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado"));
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity <?> atualizarEndereço(@PathVariable Long id, @RequestBody EnderecoRequestDom endereco) {

        try {
            EnderecoResponseDom response = enderecoService.atualizarEndereco(id, endereco);

            if(response == null) {
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Erro inesperado"));
            }
            return ResponseEntity.ok(response);
        } catch (CustomException ce) {
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado"));
        }
    }

}
