package com.store.pandora.api.useCases.pedido.domains;

import com.store.pandora.api.useCases.pedidoItem.domains.PedidoItemRequestDom;

import java.math.BigDecimal;

public class PedidoPedidoItemRequestDom {

    private BigDecimal valorUnitario;

    private Integer quantidade;

    private Long produto_id;

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }
}
