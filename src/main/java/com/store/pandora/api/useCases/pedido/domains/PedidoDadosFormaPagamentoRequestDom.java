package com.store.pandora.api.useCases.pedido.domains;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoDadosFormaPagamentoRequestDom {

    private String numeroCartao;

    private String nomeTitular;

    private String codigoSeguranca;

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
}
