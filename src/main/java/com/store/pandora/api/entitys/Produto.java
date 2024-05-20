package com.store.pandora.api.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@SQLDelete(sql = "UPDATE produto SET deleted_at = now() WHERE id=?")
//@SQLRestriction("deleted_at is null")
@Where(clause = "deleted_at is null")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String imagem;

    @Column(nullable = false)
    private BigDecimal valorUnitario;
    private String Descricao;
    private String classificacaoIndicativa;
    private String numeroJogadores;

    @Column(nullable = false)
    private CategoriasEnum categoriasEnum;

    @Column
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
