package com.store.pandora.api.useCases.cartao.domains;
import com.store.pandora.api.entitys.enums.BandeiraCartaoEnum;

import java.math.BigDecimal;

public class CartaoRequestDom {

    private String numeroCartao;

    private String nomeTitular;

    private String codigoSeguranca;

    private BigDecimal valor;

    private Long pedido_id;

    private BandeiraCartaoEnum bandeiraCartao;

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
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
