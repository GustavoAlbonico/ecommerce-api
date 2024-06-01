package com.store.pandora.api.useCases.pedido.implement.mappers;

import com.store.pandora.api.useCases.pedido.domains.PedidoPedidoItemResponseDom;
import com.store.pandora.api.useCases.pedidoItem.domains.PedidoItemResponseDom;

public class PedidoPedidoItemMappers {
    public static PedidoPedidoItemResponseDom pedidoItemResponseDomParaPedidoPedidoItemResponseDom(PedidoItemResponseDom pedidoItem){
        PedidoPedidoItemResponseDom response = new PedidoPedidoItemResponseDom();

        response.setId(pedidoItem.getId());
        response.setQuantidade(pedidoItem.getQuantidade());
        response.setValorUnitario(pedidoItem.getValorUnitario());
        response.setProduto_id(pedidoItem.getProduto_id());
        response.setPedido_id(pedidoItem.getPedido_id());

        return response;
    }
}
