package com.store.pandora.api.useCases.pedido.domains;

import com.store.pandora.api.entitys.Cliente;
import com.store.pandora.api.entitys.Endereco;
import com.store.pandora.api.entitys.enums.FormaPagamentoEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoRequestDom {
    private BigDecimal valorTotal;

    private FormaPagamentoEnum formaPagamento;

    private Endereco endereco;

    private Cliente cliente;
}
