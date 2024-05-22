package com.store.pandora.api.useCases.cliente;

import com.store.pandora.api.entitys.Cliente;
import com.store.pandora.api.useCases.cliente.domains.ClienteRequestDom;
import com.store.pandora.api.useCases.cliente.domains.ClienteResponseDom;
import com.store.pandora.api.useCases.cliente.implement.ClienteRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDom carregarClienteById(Long id) {
        Optional<Cliente> resultado = clienteRepository.findById(id);

        if(resultado.isPresent()){
            Cliente cliente = resultado.get();
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
        return null;
    }

    public List<ClienteResponseDom> carregarProduto(){
        List<Cliente> resultadoLista = clienteRepository.findAll();
        List<ClienteResponseDom> responseLista = new ArrayList<>();

        for(Cliente resultado : resultadoLista) {
            ClienteResponseDom aux = new ClienteResponseDom();

            aux.setId(resultado.getId());
            aux.setNome(resultado.getNome());
            aux.setDataNascimento(resultado.getDataNascimento());
            aux.setEmail(resultado.getEmail());
            aux.setTelefone(resultado.getTelefone());
            aux.setUsuario(resultado.getUsuario());
            aux.setDeletedAt(resultado.getDeletedAt());

            responseLista.add(aux);
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

        ClienteResponseDom response = new ClienteResponseDom();
        response.setId(resultado.getId());
        response.setNome(resultado.getNome());
        response.setDataNascimento(resultado.getDataNascimento());
        response.setEmail(resultado.getEmail());
        response.setTelefone(resultado.getTelefone());
        response.setUsuario(resultado.getUsuario());
        response.setDeletedAt(resultado.getDeletedAt());

        return response;
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

        if (resultado.isPresent()){
            Cliente clienteEntidade = resultado.get();

            ClienteResponseDom response = new ClienteResponseDom();
            response.setNome(clienteEntidade.getNome());
            response.setDataNascimento(clienteEntidade.getDataNascimento());
            response.setEmail(clienteEntidade.getEmail());
            response.setTelefone(clienteEntidade.getTelefone());
            response.setUsuario(clienteEntidade.getUsuario());
            response.setDeletedAt(clienteEntidade.getDeletedAt());

            return response;
        }
        return null;
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
