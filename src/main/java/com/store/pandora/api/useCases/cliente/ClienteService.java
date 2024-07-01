package com.store.pandora.api.useCases.cliente;

import com.store.pandora.api.entitys.Cliente;
import com.store.pandora.api.entitys.Usuario;
import com.store.pandora.api.useCases.cliente.domains.ClienteRequestDom;
import com.store.pandora.api.useCases.cliente.domains.ClienteResponseDom;
import com.store.pandora.api.useCases.cliente.implement.repositorys.ClienteRepository;
import com.store.pandora.api.useCases.cliente.implement.mappers.ClienteMappers;
import com.store.pandora.api.useCases.endereco.implement.repositorys.EnderecoRepository;
import com.store.pandora.api.useCases.usuario.implement.repositorys.UsuarioRepository;
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

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ClienteResponseDom carregarClienteById(Long id) {
        Optional<Cliente> resultado = clienteRepository.findById(id);

        return resultado.map(ClienteMappers::clienteParaClienteEnderecoResponseDom).orElse(null);
    }

    public ClienteResponseDom carregarClienteByUsuarioId(Long id) throws CustomException {
        String mensagem = this.validaIdPathVariableUsuario(id);
        if(mensagem != null){
            throw new CustomException(mensagem);
        }

        Cliente resultado = clienteRepository.findByUsuarioId(id);
        return ClienteMappers.clienteParaClienteEnderecoResponseDom(resultado);
    }

    public List<ClienteResponseDom> carregarCliente(){
        List<Cliente> resultadoLista = clienteRepository.findAll();
        List<ClienteResponseDom> responseLista = new ArrayList<>();

        if(!resultadoLista.isEmpty()){
            responseLista = resultadoLista.stream().map(ClienteMappers::clienteParaClienteEnderecoResponseDom).toList();
        }
        return responseLista;
    }

    public ClienteResponseDom criarCliente(ClienteRequestDom cliente) throws CustomException {
        List<String> mensagens = this.validaCliente(cliente);
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(cliente.getUsuario_id());
        Usuario usuario = usuarioEncontrado.get();

        Cliente clienteEntidade = new Cliente();
        clienteEntidade.setNome(cliente.getNome());
        clienteEntidade.setDataNascimento(cliente.getDataNascimento());
        clienteEntidade.setEmail(cliente.getEmail());
        clienteEntidade.setTelefone(cliente.getTelefone());
        clienteEntidade.setUsuario(usuario);
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

            Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(cliente.getUsuario_id());
            Usuario usuario = usuarioEncontrado.get();

            record.setNome(cliente.getNome());
            record.setDataNascimento(cliente.getDataNascimento());
            record.setEmail(cliente.getEmail());
            record.setTelefone(cliente.getTelefone());
            record.setUsuario(usuario);
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
        } else if (!cliente.getEmail().contains("@")){
            mensagens.add("E-mail inválido");
        }

        if(cliente.getTelefone() == null || cliente.getTelefone().equals("")){
            mensagens.add("Telefone do cliente não informado");
        } else if (cliente.getTelefone().length() < 9){
            mensagens.add("Telefone inválido");
        }

        return mensagens;
    }

    private String validaIdPathVariableUsuario(Long id){
        if (usuarioRepository.findById(id).isEmpty()){
            return "Id do Usuário inválido!";
        }
        return null;
    }
}
