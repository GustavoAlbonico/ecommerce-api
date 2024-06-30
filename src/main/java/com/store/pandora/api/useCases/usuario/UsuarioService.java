package com.store.pandora.api.useCases.usuario;

import com.store.pandora.api.entitys.Usuario;
import com.store.pandora.api.infra.security.TokenService;
import com.store.pandora.api.useCases.cliente.ClienteService;
import com.store.pandora.api.useCases.endereco.EnderecoService;
import com.store.pandora.api.useCases.usuario.domains.*;
import com.store.pandora.api.useCases.usuario.implement.mappers.UsuarioCadastroClienteMappers;
import com.store.pandora.api.useCases.usuario.implement.mappers.UsuarioMappers;
import com.store.pandora.api.useCases.usuario.implement.repositorys.UsuarioRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;


    private final ClienteService clienteService;

    private final EnderecoService enderecoService;

    public UsuarioService(ClienteService clienteService, EnderecoService enderecoService) {
        this.clienteService = clienteService;
        this.enderecoService = enderecoService;
    }

    public UsuarioResponseDom carregarUsuarioById(Long id){
        Optional<Usuario> resultado = usuarioRepository.findById(id);

        return resultado.map(UsuarioMappers::usuarioParaUsuarioResponseDom).orElse(null);
    }

    public List<UsuarioResponseDom> carregarUsuario(){
        List<Usuario> resultadoLista = usuarioRepository.findAll();
        List<UsuarioResponseDom> responseLista = new ArrayList<>();

        if (!resultadoLista.isEmpty()){
            responseLista = resultadoLista.stream().map(UsuarioMappers::usuarioParaUsuarioResponseDom).toList();
        }

        return responseLista;
    }
    @Transactional(rollbackFor = {Exception.class, CustomException.class})
    public UsuarioLoginResponseDom cadastroUsuario(UsuarioCadastroRequestDom usuario) throws CustomException {
        List<String> mensagens =  this.validaUsuarioCadastro(usuario);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Usuario usuarioEntidade = new Usuario();

        usuarioEntidade.setLogin(usuario.getLogin());
        usuarioEntidade.setSenha(passwordEncoder.encode(usuario.getSenha()));

        Usuario responseUsuario = this.usuarioRepository.save(usuarioEntidade);

        usuario.getCliente().setUsuario_id(responseUsuario.getId());
        UsuarioCadastroClienteResponseDom clienteResponse =
                UsuarioCadastroClienteMappers.clienteResponseDomParaUsuarioCadastroClienteResponseDom
                        (clienteService.criarCliente(usuario.getCliente()));

        usuario.getEndereco().setCliente_id(clienteResponse.getId());
        enderecoService.criarEndereco(usuario.getEndereco());

        String token = this.tokenService.gerarToken(usuarioEntidade);
        return new UsuarioLoginResponseDom(responseUsuario.getId(),responseUsuario.getLogin(),token);
    }

    public UsuarioLoginResponseDom loginUsuario(UsuarioRequestDom usuario) throws CustomException {
        List<String> mensagens =  this.validaUsuarioLogin(usuario);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByLogin(usuario.getLogin());
        Usuario response = usuarioEncontrado.get();
        String token = this.tokenService.gerarToken(response);

        return new UsuarioLoginResponseDom(response.getId(),response.getLogin(),token);
    }

    public UsuarioResponseDom atualizarUsuario(Long id, UsuarioRequestDom usuario) throws CustomException{

        List<String> mensagens = this.validaUsuario(usuario);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Usuario> resultado = usuarioRepository.findById(id).map(record -> {
            record.setLogin(usuario.getLogin());
            record.setSenha(usuario.getSenha());

            return usuarioRepository.save(record);
        });

        return resultado.map(UsuarioMappers::usuarioParaUsuarioResponseDom).orElse(null);
    }

    private List<String> validaUsuarioLogin(UsuarioRequestDom usuario){
        List<String> mensagens =  new ArrayList<>();

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByLogin(usuario.getLogin());

        if (usuario.getLogin() == null || usuario.getLogin().equals("")){
            mensagens.add("Login não informado");
        }
        if (usuario.getSenha() == null || usuario.getSenha().equals("")){
            mensagens.add("Senha não informada");
        }
        if(usuarioEncontrado.isEmpty()){
            mensagens.add("Login inválido!");
        }else if(!this.passwordEncoder.matches(usuario.getSenha(),usuarioEncontrado.get().getSenha())){
            mensagens.add("Senha inválida!");
        }

        return mensagens;
    }

    private List<String> validaUsuario(UsuarioRequestDom usuario){
        List<String> mensagens =  new ArrayList<>();

        if (usuario.getLogin() == null || usuario.getLogin().equals("")){
            mensagens.add("Login não informado");
        }
        if (usuario.getSenha() == null || usuario.getSenha().equals("")){
            mensagens.add("Senha não informada");
        }
        if(!this.usuarioRepository.findByLogin(usuario.getLogin()).isEmpty()){
            mensagens.add("O Login já existe!");
        }

        return mensagens;
    }

    private List<String> validaUsuarioCadastro(UsuarioCadastroRequestDom usuario){
        List<String> mensagens =  new ArrayList<>();

        if (usuario.getLogin() == null || usuario.getLogin().equals("")){
            mensagens.add("Login não informado");
        }
        if (usuario.getSenha() == null || usuario.getSenha().equals("")){
            mensagens.add("Senha não informada");
        }
        if(!this.usuarioRepository.findByLogin(usuario.getLogin()).isEmpty()){
            mensagens.add("O Login já existe!");
        }

        return mensagens;
    }
}
