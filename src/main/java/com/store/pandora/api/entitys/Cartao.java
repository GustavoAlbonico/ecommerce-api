package com.store.pandora.api.entitys;

import com.store.pandora.api.entitys.enums.BandeiraCartaoEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@SQLDelete(sql = "UPDATE cartao SET deleted_at = now() WHERE id=?")
@SQLRestriction("deleted_at is null")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroCartao;

    @Column(nullable = false)
    private String nomeTitular;

    @Column(nullable = false)
    private String codigoSeguranca;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BandeiraCartaoEnum bandeiraCartao;

    private LocalDateTime deletedAt;
    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public BandeiraCartaoEnum getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(BandeiraCartaoEnum bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }
}
