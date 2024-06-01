package com.store.pandora.api.useCases.pedido.domains;
import com.store.pandora.api.entitys.enums.FormaPagamentoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDom {
    private Long id;

    private BigDecimal valorTotal;

    private FormaPagamentoEnum formaPagamento;

    private LocalDateTime deletedAt;

    private Long endereco_id;

    private Long cliente_id;

    private List<PedidoPedidoItemResponseDom> listaPedidoItem;

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

    public FormaPagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Long endereco_id) {
        this.endereco_id = endereco_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public List<PedidoPedidoItemResponseDom> getListaPedidoItem() {
        return listaPedidoItem;
    }

    public void setListaPedidoItem(List<PedidoPedidoItemResponseDom> listaPedidoItem) {
        this.listaPedidoItem = listaPedidoItem;
    }
}
