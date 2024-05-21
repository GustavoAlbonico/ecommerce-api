package com.store.pandora.api.useCases.usuario.implement.mappers;

import com.store.pandora.api.entitys.Usuario;
import com.store.pandora.api.useCases.usuario.domains.UsuarioResponseDom;

public class UsuarioMappers {
    public static UsuarioResponseDom usuarioParaUsuarioResponseDom(Usuario usuario){
        UsuarioResponseDom response = new UsuarioResponseDom();

        response.setId(usuario.getId());
        response.setLogin(usuario.getLogin());
        response.setSenha(usuario.getSenha());
        response.setDeleted_at(usuario.getDeletedAt());

        return response;
    }
}
