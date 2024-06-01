package com.store.pandora.api.useCases.pedidoItem.implement.mappers;

import com.store.pandora.api.entitys.PedidoItem;
import com.store.pandora.api.useCases.pedidoItem.domains.PedidoItemResponseDom;

public class PedidoItemMappers {
    public static PedidoItemResponseDom pedidoItemParaPedidoItemResponseDom(PedidoItem pedidoItem){
        PedidoItemResponseDom response = new PedidoItemResponseDom();

        response.setId(pedidoItem.getId());
        response.setQuantidade(pedidoItem.getQuantidade());
        response.setValorUnitario(pedidoItem.getValorUnitario());
        response.setProduto_id(pedidoItem.getProduto().getId());
        response.setPedido_id(pedidoItem.getPedido().getId());

        return response;
    }
}
