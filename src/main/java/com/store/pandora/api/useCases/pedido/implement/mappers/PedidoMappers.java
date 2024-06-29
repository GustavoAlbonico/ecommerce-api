package com.store.pandora.api.useCases.pedido.implement.mappers;

import com.store.pandora.api.entitys.Pedido;
import com.store.pandora.api.entitys.PedidoItem;
import com.store.pandora.api.useCases.pedido.domains.*;

import java.util.List;

public class PedidoMappers {
    public static PedidoResponseDom pedidoParaPedidoPostResponseDom(Pedido pedido, List<PedidoItem> listaPedidoItemEntidade){

        List<PedidoPedidoItemResponseDom> listaPedidoItem =
                listaPedidoItemEntidade.stream()
                        .map(PedidoPedidoItemMappers::pedidoItemParaPedidoGetPedidoItemResponseDom).toList();

        PedidoResponseDom response = new PedidoResponseDom();

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

    public static PedidoResponseDom pedidoParaPedidoResponseDom(Pedido pedido){

        List<PedidoPedidoItemResponseDom> listaPedidoItem =
                pedido.getListaPedidoItem().stream()
                        .map(PedidoPedidoItemMappers::pedidoItemParaPedidoGetPedidoItemResponseDom).toList();

        PedidoResponseDom response = new PedidoResponseDom();

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

    public static PedidoPixRequestDom pedidoParaPedidoPixRequestDom(Pedido pedido){
        PedidoPixRequestDom response = new PedidoPixRequestDom();

        response.setValor(pedido.getValorTotal());
        response.setPedido_id(pedido.getId());

        return response;
    }

    public static PedidoBoletoRequestDom pedidoParaBoletoRequestDom(Pedido pedido, PedidoDadosFormaPagamentoRequestDom dadosFormaPagamento){
        PedidoBoletoRequestDom response = new PedidoBoletoRequestDom();

        response.setValor(pedido.getValorTotal());
        response.setPedido_id(pedido.getId());

        return response;
    }

    public static PedidoCartaoRequestDom pedidoParaCartaoRequestDom(Pedido pedido, PedidoDadosFormaPagamentoRequestDom dadosFormaPagamento){
        PedidoCartaoRequestDom response = new PedidoCartaoRequestDom();

        response.setValor(pedido.getValorTotal());
        response.setPedido_id(pedido.getId());
        response.setNumeroCartao(dadosFormaPagamento.getNumeroCartao());
        response.setNomeTitular(dadosFormaPagamento.getNomeTitular());
        response.setCodigoSeguranca(dadosFormaPagamento.getCodigoSeguranca());

        return response;
    }
}
