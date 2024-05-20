package com.store.pandora.api.useCases.produto.domains;

import com.store.pandora.api.entitys.CategoriasEnum;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoRequestDom {

    private String nome;
    private String imagem;
    private BigDecimal valorUnitario;
    private String Descricao;
    private String classificacaoIndicativa;
    private String numeroJogadores;
    private CategoriasEnum categoriasEnum;
    private LocalDateTime deletedAt;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public String getNumeroJogadores() {
        return numeroJogadores;
    }

    public void setNumeroJogadores(String numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
    }

    public CategoriasEnum getCategoriasEnum() {
        return categoriasEnum;
    }

    public void setCategoriasEnum(CategoriasEnum categoriasEnum) {
        this.categoriasEnum = categoriasEnum;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
