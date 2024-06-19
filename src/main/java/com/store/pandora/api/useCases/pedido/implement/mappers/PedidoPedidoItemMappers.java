package com.store.pandora.api.useCases.pedido.implement.mappers;

import com.store.pandora.api.entitys.PedidoItem;
import com.store.pandora.api.useCases.pedido.domains.PedidoGetPedidoItemResponseDom;
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

    public static PedidoPedidoItemResponseDom pedidoItemParaPedidoPedidoItemResponseDom(PedidoItem pedidoItem){
        PedidoPedidoItemResponseDom response = new PedidoPedidoItemResponseDom();

        response.setId(pedidoItem.getId());
        response.setQuantidade(pedidoItem.getQuantidade());
        response.setValorUnitario(pedidoItem.getValorUnitario());
        response.setProduto_id(pedidoItem.getProduto().getId());
        response.setPedido_id(pedidoItem.getPedido().getId());

        return response;
    }

    public static PedidoGetPedidoItemResponseDom pedidoItemParaPedidoGetPedidoItemResponseDom(PedidoItem pedidoItem){
        PedidoGetPedidoItemResponseDom response = new PedidoGetPedidoItemResponseDom();

        response.setId(pedidoItem.getId());
        response.setQuantidade(pedidoItem.getQuantidade());
        response.setValorUnitario(pedidoItem.getValorUnitario());
        response.setNomeProduto(pedidoItem.getProduto().getNome());

        return response;
    }
}
