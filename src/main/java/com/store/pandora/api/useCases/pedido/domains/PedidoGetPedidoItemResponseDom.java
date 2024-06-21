package com.store.pandora.api.useCases.pedido.domains;

import java.math.BigDecimal;

public class PedidoGetPedidoItemResponseDom {

    private Long id;

    private BigDecimal valorUnitario;

    private Integer quantidade;

    private BigDecimal valorTotal;

    private PedidoGetProdutoResponseDom produto;

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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PedidoGetProdutoResponseDom getProduto() {
        return produto;
    }

    public void setProduto(PedidoGetProdutoResponseDom produto) {
        this.produto = produto;
    }
}
