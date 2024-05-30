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
}
