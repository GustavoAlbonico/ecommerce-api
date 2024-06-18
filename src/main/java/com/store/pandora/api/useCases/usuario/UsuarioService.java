package com.store.pandora.api.useCases.usuario;

import com.store.pandora.api.entitys.Usuario;
import com.store.pandora.api.infra.security.TokenService;
import com.store.pandora.api.useCases.usuario.domains.UsuarioLoginResponseDom;
import com.store.pandora.api.useCases.usuario.domains.UsuarioRequestDom;
import com.store.pandora.api.useCases.usuario.domains.UsuarioResponseDom;
import com.store.pandora.api.useCases.usuario.implement.mappers.UsuarioMappers;
import com.store.pandora.api.useCases.usuario.implement.repositorys.UsuarioRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public UsuarioLoginResponseDom cadastroUsuario(UsuarioRequestDom usuario) throws CustomException {
        List<String> mensagens =  this.validaUsuario(usuario);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Usuario usuarioEntidade = new Usuario();

        usuarioEntidade.setLogin(usuario.getLogin());
        usuarioEntidade.setSenha(passwordEncoder.encode(usuario.getSenha()));

        Usuario response = this.usuarioRepository.save(usuarioEntidade);

        String token = this.tokenService.gerarToken(usuarioEntidade);
        return new UsuarioLoginResponseDom(response.getId(),response.getLogin(),token);
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
}
