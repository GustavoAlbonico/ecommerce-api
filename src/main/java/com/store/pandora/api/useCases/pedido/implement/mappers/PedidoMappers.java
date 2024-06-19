package com.store.pandora.api.useCases.pedido.implement.mappers;

import com.store.pandora.api.entitys.Pedido;;
import com.store.pandora.api.useCases.pedido.domains.PedidoPedidoItemResponseDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoResponseDom;


import java.util.List;

public class PedidoMappers {
    public static PedidoResponseDom pedidoPostParaPedidoResponseDom(Pedido pedido, List<PedidoPedidoItemResponseDom> listaPedidoPedidoItem){

        PedidoResponseDom response = new PedidoResponseDom();
        response.setId(pedido.getId());
        response.setDeletedAt(pedido.getDeletedAt());
        response.setFormaPagamento(pedido.getFormaPagamento());
        response.setStatus(pedido.getStatus());
        response.setValorTotal(pedido.getValorTotal());
        response.setCliente_id(pedido.getCliente().getId());
        response.setEndereco_id(pedido.getEndereco().getId());
        response.setListaPedidoItem(listaPedidoPedidoItem);

        return response;
    }

    public static PedidoResponseDom pedidoParaPedidoResponseDom(Pedido pedido){
//        List<PedidoPedidoItemResponseDom> listaPedidoItem =  new ArrayList<>();
//
//        for(PedidoItem pedidoItem: pedido.getListaPedidoItem()){
//            PedidoPedidoItemResponseDom pedidoItemEntidade = new PedidoPedidoItemResponseDom();
//
//            pedidoItemEntidade.setId(pedidoItem.getId());
//            pedidoItemEntidade.setQuantidade(pedidoItem.getQuantidade());
//            pedidoItemEntidade.setValorUnitario(pedidoItem.getValorUnitario());
//            pedidoItemEntidade.setProduto_id(pedidoItem.getProduto().getId());
//            pedidoItemEntidade.setPedido_id(pedidoItem.getPedido().getId());
//
//            listaPedidoItem.add(pedidoItemEntidade);
//        }

        List<PedidoPedidoItemResponseDom> listaPedidoItem =
                pedido.getListaPedidoItem().stream()
                        .map(PedidoPedidoItemMappers::pedidoItemParaPedidoPedidoItemResponseDom).toList();

        PedidoResponseDom response = new PedidoResponseDom();

        response.setId(pedido.getId());
        response.setDeletedAt(pedido.getDeletedAt());
        response.setFormaPagamento(pedido.getFormaPagamento());
        response.setStatus(pedido.getStatus());
        response.setValorTotal(pedido.getValorTotal());
        response.setCliente_id(pedido.getCliente().getId());
        response.setEndereco_id(pedido.getEndereco().getId());
        response.setListaPedidoItem(listaPedidoItem);

        return response;
    }
}
