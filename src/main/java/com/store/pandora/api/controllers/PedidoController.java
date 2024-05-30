package com.store.pandora.api.controllers;

import com.store.pandora.api.useCases.pedido.PedidoService;
import com.store.pandora.api.useCases.pedido.domains.PedidoRequestDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoResponseDom;
import com.store.pandora.api.utils.CustomException;
import com.store.pandora.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarPedido(@RequestBody PedidoRequestDom pedido){

        try {
            PedidoResponseDom response = pedidoService.criarPedido(pedido);
            return ResponseEntity.status(201).body(response);
        }catch (CustomException ce){
            ce.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        }catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado" + ex.getMessage()));
        }
    }
}
