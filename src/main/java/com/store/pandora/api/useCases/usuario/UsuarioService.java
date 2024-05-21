package com.store.pandora.api.useCases.usuario;

import com.store.pandora.api.entitys.Usuario;
import com.store.pandora.api.useCases.usuario.domains.UsuarioRequestDom;
import com.store.pandora.api.useCases.usuario.domains.UsuarioResponseDom;
import com.store.pandora.api.useCases.usuario.implement.mappers.UsuarioMappers;
import com.store.pandora.api.useCases.usuario.implement.repositorys.UsuarioRepository;
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

    public UsuarioResponseDom criarUsuario(UsuarioRequestDom usuario) throws CustomException {

        List<String> mensagens =  this.validaUsuario(usuario);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Usuario usuarioEntidade = new Usuario();

        usuarioEntidade.setLogin(usuario.getLogin());
        usuarioEntidade.setSenha(usuario.getSenha());

        Usuario resultado = usuarioRepository.save(usuarioEntidade);

        return UsuarioMappers.usuarioParaUsuarioResponseDom(resultado);
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
