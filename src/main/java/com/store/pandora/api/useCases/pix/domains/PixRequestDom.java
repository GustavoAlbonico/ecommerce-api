package com.store.pandora.api.useCases.pix.domains;

import java.math.BigDecimal;

public class PixRequestDom {

    private BigDecimal valor;

    private Long pedido_id;

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
}
