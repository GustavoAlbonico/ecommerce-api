package com.store.pandora.api.useCases.cartao.implement.mappers;

import com.store.pandora.api.entitys.Cartao;
import com.store.pandora.api.useCases.cartao.domains.CartaoResponseDom;

public class CartaoMappers {

    public static CartaoResponseDom cartaoParaCartaoResponseDom (Cartao cartao){

        CartaoResponseDom response = new CartaoResponseDom();

        response.setId(cartao.getId());
        response.setCodigoSeguranca(cartao.getCodigoSeguranca());
        response.setNumeroCartao(cartao.getNumeroCartao());
        response.setNomeTitular(cartao.getNomeTitular());
        response.setValor(cartao.getValor());
        response.setPedido_id(cartao.getPedido().getId());
        response.setDeletedAt(cartao.getDeletedAt());

        return response;
    }
}
