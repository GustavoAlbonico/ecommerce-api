package com.store.pandora.api.useCases.cliente;

import com.store.pandora.api.entitys.Cliente;
import com.store.pandora.api.useCases.cliente.domains.ClienteRequestDom;
import com.store.pandora.api.useCases.cliente.domains.ClienteResponseDom;
import com.store.pandora.api.useCases.cliente.implement.repositorys.ClienteRepository;
import com.store.pandora.api.useCases.cliente.implement.mappers.ClienteMappers;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDom carregarClienteById(Long id) {
        Optional<Cliente> resultado = clienteRepository.findById(id);

        return resultado.map(ClienteMappers::clienteParaClienteResponseDom).orElse(null);
    }

    public List<ClienteResponseDom> carregarCliente(){
        List<Cliente> resultadoLista = clienteRepository.findAll();
        List<ClienteResponseDom> responseLista = new ArrayList<>();

        if(!resultadoLista.isEmpty()){
            responseLista = resultadoLista.stream().map(ClienteMappers::clienteParaClienteResponseDom).toList();

        }
        return responseLista;
    }

    public ClienteResponseDom criarCliente(ClienteRequestDom cliente) throws CustomException {
        List<String> mensagens = this.validaCliente(cliente);
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Cliente clienteEntidade = new Cliente();
        clienteEntidade.setNome(cliente.getNome());
        clienteEntidade.setDataNascimento(cliente.getDataNascimento());
        clienteEntidade.setEmail(cliente.getEmail());
        clienteEntidade.setTelefone(cliente.getTelefone());
        clienteEntidade.setUsuario(cliente.getUsuario());
        clienteEntidade.setDeletedAt(cliente.getDeletedAt());

        Cliente resultado = clienteRepository.save(clienteEntidade);

        return ClienteMappers.clienteParaClienteResponseDom(resultado);
    }

    public ClienteResponseDom atualizarCliente(Long id, ClienteRequestDom cliente) throws CustomException {

        List<String> mensagens = this.validaCliente(cliente);
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Cliente> resultado = clienteRepository.findById(id).map(record -> {
            record.setNome(cliente.getNome());
            record.setDataNascimento(cliente.getDataNascimento());
            record.setEmail(cliente.getEmail());
            record.setTelefone(cliente.getTelefone());
            record.setUsuario(cliente.getUsuario());
            record.setDeletedAt(cliente.getDeletedAt());

            return clienteRepository.save(record);
        });

        return resultado.map(ClienteMappers::clienteParaClienteResponseDom).orElse(null);
    }

    public List<String> validaCliente(ClienteRequestDom cliente) {
        List<String> mensagens = new ArrayList<>();

        if(cliente.getNome() == null || cliente.getNome().equals("")){
            mensagens.add("Nome do cliente não informado");
        }

        if(cliente.getDataNascimento() == null){
            mensagens.add("Data de nascimento do cliente não informada");
        }

        if(cliente.getEmail() == null || cliente.getEmail().equals("")){
            mensagens.add("E-mail do cliente não informado");
        }

        if(cliente.getTelefone() == null || cliente.getTelefone().equals("")){
            mensagens.add("Telefone do cliente não informado");
        }

        return mensagens;
    }
}
