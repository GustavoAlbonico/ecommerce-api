package com.store.pandora.api.useCases.usuario;

import com.store.pandora.api.entitys.Usuario;
import com.store.pandora.api.useCases.usuario.domains.UsuarioRequestDom;
import com.store.pandora.api.useCases.usuario.domains.UsuarioResponseDom;
import com.store.pandora.api.useCases.usuario.implement.UsuarioRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDom carregarUsuarioById(Long id){
        Optional<Usuario> resultado = usuarioRepository.findById(id);

        if(resultado.isPresent()){
            Usuario usuario = resultado.get();
            UsuarioResponseDom response = new UsuarioResponseDom();

            response.setId(usuario.getId());
            response.setLogin(usuario.getLogin());
            response.setSenha(usuario.getSenha());
            response.setDeleted_at(usuario.getDeletedAt());

            return response;
        }
        return null;
    }

    public List<UsuarioResponseDom> carregarUsuario(){
        List<Usuario> resultadoLista = usuarioRepository.findAll();
        List<UsuarioResponseDom> responseLista = new ArrayList<>();

        for(Usuario resultado: resultadoLista){
            UsuarioResponseDom aux = new UsuarioResponseDom();
            aux.setId(resultado.getId());
            aux.setLogin(resultado.getLogin());
            aux.setSenha(resultado.getSenha());
            aux.setDeleted_at(resultado.getDeletedAt());

            responseLista.add(aux);
        }

        return responseLista;
    }

    public UsuarioResponseDom criarUsuario(UsuarioRequestDom usuario) throws CustomException {

        List<String> mensagens =  this.validaUsuario(usuario);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Usuario usuarioEntidade = new Usuario();

        usuarioEntidade.setLogin(usuario.getLogin());
        usuarioEntidade.setSenha(usuario.getSenha());

        Usuario resultado = usuarioRepository.save(usuarioEntidade);

        UsuarioResponseDom response = new UsuarioResponseDom();
        response.setId(resultado.getId());
        response.setLogin(resultado.getLogin());
        response.setSenha(resultado.getSenha());

        return response;
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

        if (resultado.isPresent()) {
            Usuario usuarioEntidade = resultado.get();

            UsuarioResponseDom response = new UsuarioResponseDom();
            response.setLogin(usuarioEntidade.getLogin());
            response.setSenha(usuarioEntidade.getSenha());

            return response;
        }
        return null;
    }

    private List<String> validaUsuario(UsuarioRequestDom usuario){
        List<String> mensagens =  new ArrayList<>();


        if (usuario.getLogin() == null || usuario.getLogin().equals("")){
            mensagens.add("Login do usuario não informado");
        }
        if (usuario.getSenha() == null || usuario.getSenha().equals("")){
            mensagens.add("Senha do usuario não informada");
        }

        return mensagens;
    }
}
