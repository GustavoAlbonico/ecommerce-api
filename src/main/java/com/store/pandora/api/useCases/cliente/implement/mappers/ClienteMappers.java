package com.store.pandora.api.useCases.cliente.implement.mappers;

import com.store.pandora.api.entitys.Cliente;
import com.store.pandora.api.entitys.Endereco;
import com.store.pandora.api.useCases.cliente.domains.ClienteEnderecoResponseDom;
import com.store.pandora.api.useCases.cliente.domains.ClienteResponseDom;

import java.util.ArrayList;
import java.util.List;

public class ClienteMappers {

    public static ClienteResponseDom clienteParaClienteResponseDom(Cliente cliente) {

        List<ClienteEnderecoResponseDom> listaEnderecos = new ArrayList<>();

        for(Endereco endereco : cliente.getEnderecos()){
            ClienteEnderecoResponseDom clienteEnderecoResponseDom = new ClienteEnderecoResponseDom();
            clienteEnderecoResponseDom.setApelido(endereco.getApelido());
            clienteEnderecoResponseDom.setLogradouro(endereco.getLogradouro());
            clienteEnderecoResponseDom.setNumero(endereco.getNumero());
            clienteEnderecoResponseDom.setBairro(endereco.getBairro());
            clienteEnderecoResponseDom.setCep(endereco.getCep());
            clienteEnderecoResponseDom.setComplemento(endereco.getComplemento());

            listaEnderecos.add(clienteEnderecoResponseDom);
        }

        ClienteResponseDom response = new ClienteResponseDom();

        response.setId(cliente.getId());
        response.setNome(cliente.getNome());
        response.setDataNascimento(cliente.getDataNascimento());
        response.setEmail(cliente.getEmail());
        response.setTelefone(cliente.getTelefone());
        response.setUsuario_id(cliente.getUsuario().getId());
        response.setDeletedAt(cliente.getDeletedAt());
        response.setEnderecos(listaEnderecos);

        return response;
    }
}
