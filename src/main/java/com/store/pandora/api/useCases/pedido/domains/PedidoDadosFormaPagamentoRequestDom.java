package com.store.pandora.api.useCases.pedido.domains;

import com.store.pandora.api.entitys.enums.BandeiraCartaoEnum;

public class PedidoDadosFormaPagamentoRequestDom {

    private String numeroCartao;

    private String nomeTitular;

    private String codigoSeguranca;

    private BandeiraCartaoEnum bandeiraCartao;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
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
