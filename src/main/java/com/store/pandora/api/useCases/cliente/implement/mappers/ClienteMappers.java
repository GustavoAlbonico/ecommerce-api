package com.store.pandora.api.useCases.cliente.implement.mappers;

import com.store.pandora.api.entitys.Cliente;
import com.store.pandora.api.useCases.cliente.domains.ClienteResponseDom;

public class ClienteMappers {

    public static ClienteResponseDom clienteParaClienteResponseDom(Cliente cliente) {

        ClienteResponseDom response = new ClienteResponseDom();

        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setDataNascimento(cliente.getDataNascimento());
        response.setEmail(cliente.getEmail());
        response.setTelefone(cliente.getTelefone());
        response.setUsuario(cliente.getUsuario());
        response.setDeletedAt(cliente.getDeletedAt());

        return response;
    }
}
