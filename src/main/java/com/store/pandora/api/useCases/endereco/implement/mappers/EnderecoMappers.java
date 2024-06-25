package com.store.pandora.api.useCases.endereco.implement.mappers;

import com.store.pandora.api.entitys.Endereco;
import com.store.pandora.api.useCases.endereco.domains.EnderecoResponseDom;

public class EnderecoMappers {

    public static EnderecoResponseDom enderecoParaEnderecoResponseDom(Endereco endereco){

        EnderecoResponseDom response = new EnderecoResponseDom();

        response.setId(endereco.getId());
        response.setApelido(endereco.getApelido());
        response.setLogradouro(endereco.getLogradouro());
        response.setCep(endereco.getCep());
        response.setBairro(endereco.getBairro());
        response.setNumero(endereco.getNumero());
        response.setComplemento(endereco.getComplemento());
        response.setCliente_id(endereco.getCliente().getId());
        response.setDeletedAt(endereco.getDeletedAt());

        return response;
    }

}
