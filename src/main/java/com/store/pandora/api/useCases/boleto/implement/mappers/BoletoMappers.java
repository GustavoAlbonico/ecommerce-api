package com.store.pandora.api.useCases.boleto.implement.mappers;

import com.store.pandora.api.entitys.Boleto;
import com.store.pandora.api.useCases.boleto.domains.BoletoResponseDom;

public class BoletoMappers {

    public static BoletoResponseDom boletoParaBoletoResponseDom(Boleto boleto){
        BoletoResponseDom response = new BoletoResponseDom();

        response.setId(boleto.getId());
        response.setValor(boleto.getValor());
        response.setDataVencimento(boleto.getDataVencimento());
        response.setPedido_id(boleto.getPedido().getId());
        response.setDeletedAt(boleto.getDeletedAt());

        return response;
    }
}
