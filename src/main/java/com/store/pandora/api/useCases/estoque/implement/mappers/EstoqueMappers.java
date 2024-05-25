package com.store.pandora.api.useCases.estoque.implement.mappers;

import com.store.pandora.api.entitys.Estoque;
import com.store.pandora.api.useCases.estoque.domains.EstoqueResponseDom;

public class EstoqueMappers {
    public static EstoqueResponseDom estoqueParaEstoqueResponseDom(Estoque estoque){
        EstoqueResponseDom response = new EstoqueResponseDom();

        response.setId(estoque.getId());
        response.setQuantidade(estoque.getQuantidade());
        response.setProduto_id(estoque.getProduto().getId());
        response.setDeleted_at(estoque.getDeletedAt());

        return response;
    }
}
