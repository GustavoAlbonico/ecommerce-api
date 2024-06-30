package com.store.pandora.api.useCases.usuario.implement.mappers;

import com.store.pandora.api.useCases.cliente.domains.ClienteResponseDom;
import com.store.pandora.api.useCases.usuario.domains.UsuarioCadastroClienteResponseDom;

public class UsuarioCadastroClienteMappers {

    public static UsuarioCadastroClienteResponseDom clienteResponseDomParaUsuarioCadastroClienteResponseDom(ClienteResponseDom cliente) {

        UsuarioCadastroClienteResponseDom response = new UsuarioCadastroClienteResponseDom();

        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setDataNascimento(cliente.getDataNascimento());
        response.setEmail(cliente.getEmail());
        response.setTelefone(cliente.getTelefone());
        response.setUsuario_id(cliente.getUsuario_id());
        response.setDeletedAt(cliente.getDeletedAt());

        return response;
    }
}
