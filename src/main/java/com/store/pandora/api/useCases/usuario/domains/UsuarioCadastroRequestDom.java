package com.store.pandora.api.useCases.usuario.domains;

import com.store.pandora.api.entitys.Cliente;
import com.store.pandora.api.entitys.Endereco;

public class UsuarioCadastroRequestDom {

    private String login;

    private String senha;

    private UsuarioCadastroEnderecoRequestDom endereco;

    private UsuarioCadastroClienteRequestDom cliente;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioCadastroEnderecoRequestDom getEndereco() {
        return endereco;
    }

    public void setEndereco(UsuarioCadastroEnderecoRequestDom endereco) {
        this.endereco = endereco;
    }

    public UsuarioCadastroClienteRequestDom getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioCadastroClienteRequestDom cliente) {
        this.cliente = cliente;
    }
}
