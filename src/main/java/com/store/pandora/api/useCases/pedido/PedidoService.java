package com.store.pandora.api.useCases.pedido;

import com.store.pandora.api.useCases.estoque.EstoqueService;
import com.store.pandora.api.useCases.pedidoItem.PedidoItemService;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private PedidoItemService pedidoItemService;
    private EstoqueService estoqueService;

    public PedidoService(PedidoItemService pedidoItemService, EstoqueService estoqueService) {
        this.pedidoItemService = pedidoItemService;
        this.estoqueService = estoqueService;
    }
}
