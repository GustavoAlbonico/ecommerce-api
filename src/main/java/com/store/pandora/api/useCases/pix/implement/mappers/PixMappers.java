package com.store.pandora.api.useCases.pix.implement.mappers;

import com.store.pandora.api.entitys.Pix;
import com.store.pandora.api.useCases.pix.domains.PixResponseDom;

public class PixMappers {

    public static PixResponseDom pixParaPixResponseDom(Pix pix){

        PixResponseDom response = new PixResponseDom();
        response.setId(pix.getId());
        response.setValor(pix.getValor());
        response.setDataExpiracao(pix.getDataExpiracao());
        response.setPedido_id(pix.getPedido().getId());
        response.setDeletedAt(pix.getDeletedAt());

        return response;
    }
}
