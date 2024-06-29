package com.store.pandora.api.useCases.pedido.implement.mappers;

import com.store.pandora.api.entitys.PedidoItem;
import com.store.pandora.api.useCases.pedido.domains.PedidoPedidoItemResponseDom;

import java.math.BigDecimal;

public class PedidoPedidoItemMappers {

    public static PedidoPedidoItemResponseDom pedidoItemParaPedidoGetPedidoItemResponseDom(PedidoItem pedidoItem){
        PedidoPedidoItemResponseDom response = new PedidoPedidoItemResponseDom();

        BigDecimal valorTotal = pedidoItem.getValorUnitario().multiply(new BigDecimal(pedidoItem.getQuantidade()));

        response.setId(pedidoItem.getId());
        response.setQuantidade(pedidoItem.getQuantidade());
        response.setValorUnitario(pedidoItem.getValorUnitario());
        response.setValorTotal(valorTotal);
        response.setProduto(PedidoProdutoMappers.produtoParaPedidoGetProdutoResponseDom(pedidoItem.getProduto()));

        return response;
    }
}
