package com.store.pandora.api.useCases.cliente.domains;

import com.store.pandora.api.entitys.Endereco;
import com.store.pandora.api.entitys.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ClienteRequestDom {

    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private Usuario usuario;
    private Long endereco_id;
    private LocalDateTime deletedAt;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Long endereco_id) {
        this.endereco_id = endereco_id;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
