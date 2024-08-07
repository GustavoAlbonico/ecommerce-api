package com.store.pandora.api.useCases.produto.domains;

import com.store.pandora.api.entitys.enums.CategoriasEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoRequestDom {

    private String nome;
    private String imagem;
    private BigDecimal valorUnitario;
    private String descricao;
    private String classificacaoIndicativa;
    private String numeroJogadores;
    private CategoriasEnum categoria;
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
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public CategoriasEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasEnum categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
