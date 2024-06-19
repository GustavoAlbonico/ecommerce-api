package com.store.pandora.api.useCases.pedido.domains;

import com.store.pandora.api.entitys.enums.FormaPagamentoEnum;
import com.store.pandora.api.entitys.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoGetResponseDom {
    private Long id;

    private BigDecimal valorTotal;

    private FormaPagamentoEnum formaPagamento;

    private StatusEnum status;

    private LocalDateTime deletedAt;

    private String enderecoApelido;

    private String clienteNome;

    private List<PedidoGetPedidoItemResponseDom> listaPedidoItem;

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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getEnderecoApelido() {
        return enderecoApelido;
    }

    public void setEnderecoApelido(String enderecoApelido) {
        this.enderecoApelido = enderecoApelido;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public List<PedidoGetPedidoItemResponseDom> getListaPedidoItem() {
        return listaPedidoItem;
    }

    public void setListaPedidoItem(List<PedidoGetPedidoItemResponseDom> listaPedidoItem) {
        this.listaPedidoItem = listaPedidoItem;
    }
}
