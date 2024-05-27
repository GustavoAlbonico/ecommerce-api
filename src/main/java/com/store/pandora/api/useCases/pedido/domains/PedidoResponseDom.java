package com.store.pandora.api.useCases.pedido.domains;

import com.store.pandora.api.entitys.Cliente;
import com.store.pandora.api.entitys.Endereco;
import com.store.pandora.api.entitys.enums.FormaPagamentoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoResponseDom {
    private Long id;
    private BigDecimal valorTotal;

    private FormaPagamentoEnum formaPagamento;

    private LocalDateTime deletedAt;

    private Endereco endereco;

    private Cliente cliente;
}
