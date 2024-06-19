package com.store.pandora.api.useCases.pedido.implement.mappers;

import com.store.pandora.api.entitys.Pedido;;
import com.store.pandora.api.useCases.pedido.domains.PedidoGetPedidoItemResponseDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoGetResponseDom;
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

    public static PedidoGetResponseDom pedidoGetParaPedidoResponseDom(Pedido pedido){

        List<PedidoGetPedidoItemResponseDom> listaPedidoItem =
                pedido.getListaPedidoItem().stream()
                        .map(PedidoPedidoItemMappers::pedidoItemParaPedidoGetPedidoItemResponseDom).toList();

        PedidoGetResponseDom response = new PedidoGetResponseDom();

        response.setId(pedido.getId());
        response.setDeletedAt(pedido.getDeletedAt());
        response.setFormaPagamento(pedido.getFormaPagamento());
        response.setStatus(pedido.getStatus());
        response.setValorTotal(pedido.getValorTotal());
        response.setClienteNome(pedido.getCliente().getNome());
        response.setEnderecoApelido(pedido.getEndereco().getApelido());
        response.setListaPedidoItem(listaPedidoItem);

        return response;
    }
}
