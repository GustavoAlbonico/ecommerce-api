package com.store.pandora.api.useCases.pedido.implement.mappers;

import com.store.pandora.api.entitys.Pedido;
import com.store.pandora.api.useCases.pedido.domains.PedidoPedidoItemResponseDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoRequestDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoResponseDom;

import java.util.List;

public class PedidoMappers {
    public static PedidoResponseDom pedidoParaPedidoResponseDom (Pedido pedido, List<PedidoPedidoItemResponseDom> listaPedidoPedidoItem){

        PedidoResponseDom response = new PedidoResponseDom();
        response.setId(pedido.getId());
        response.setDeletedAt(pedido.getDeletedAt());
        response.setFormaPagamento(pedido.getFormaPagamento());
        response.setValorTotal(pedido.getValorTotal());
        response.setCliente_id(pedido.getCliente().getId());
        response.setEndereco_id(pedido.getEndereco().getId());
        response.setListaPedidoItem(listaPedidoPedidoItem);

        return response;
    }
}
