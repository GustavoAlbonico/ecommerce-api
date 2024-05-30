package com.store.pandora.api.useCases.pedido.domains;
import com.store.pandora.api.entitys.enums.FormaPagamentoEnum;

import java.util.List;

public class PedidoRequestDom {

    private FormaPagamentoEnum formaPagamento;

    private Long endereco_id;

    private Long cliente_id;

    private List<PedidoPedidoItemRequestDom> listaPedidoItem;
}
