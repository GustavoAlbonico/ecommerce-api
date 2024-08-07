package com.store.pandora.api.useCases.cliente.domains;

import com.store.pandora.api.entitys.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ClienteResponseDom {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private Long usuario_id;
    private List<ClienteEnderecoResponseDom> enderecos;
    private LocalDateTime deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public List<ClienteEnderecoResponseDom> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<ClienteEnderecoResponseDom> enderecos) {
        this.enderecos = enderecos;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
