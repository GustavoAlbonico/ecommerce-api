package com.store.pandora.api.useCases.pedido.domains;
import com.store.pandora.api.entitys.enums.FormaPagamentoEnum;
import com.store.pandora.api.entitys.enums.StatusEnum;

import java.util.List;

public class PedidoRequestDom {

    private FormaPagamentoEnum formaPagamento;

    private StatusEnum status;

    private Long endereco_id;

    private Long cliente_id;

    private List<PedidoPedidoItemRequestDom> listaPedidoItem;

    public FormaPagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
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

    public List<PedidoPedidoItemRequestDom> getListaPedidoItem() {
        return listaPedidoItem;
    }

    public void setListaPedidoItem(List<PedidoPedidoItemRequestDom> listaPedidoItem) {
        this.listaPedidoItem = listaPedidoItem;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
