package com.store.pandora.api.useCases.pedido;

import com.store.pandora.api.entitys.*;
import com.store.pandora.api.useCases.cliente.implement.repositorys.ClienteRepository;
import com.store.pandora.api.useCases.endereco.implement.repositorys.EnderecoRepository;
import com.store.pandora.api.useCases.estoque.EstoqueService;
import com.store.pandora.api.useCases.pedido.domains.PedidoPedidoItemResponseDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoRequestDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoResponseDom;
import com.store.pandora.api.useCases.pedido.implement.mappers.PedidoMappers;
import com.store.pandora.api.useCases.pedido.implement.mappers.PedidoPedidoItemMappers;
import com.store.pandora.api.useCases.pedido.implement.repositorys.PedidoRepository;
import com.store.pandora.api.useCases.pedidoItem.PedidoItemService;
import com.store.pandora.api.useCases.pedidoItem.domains.PedidoItemResponseDom;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    private PedidoItemService pedidoItemService;
    private EstoqueService estoqueService;

    public PedidoService(PedidoItemService pedidoItemService, EstoqueService estoqueService) {
        this.pedidoItemService = pedidoItemService;
        this.estoqueService = estoqueService;
    }
    @Transactional(rollbackFor = {Exception.class, CustomException.class})
    public PedidoResponseDom criarPedido(PedidoRequestDom pedido) throws CustomException {
        List<String> mensagens = this.validaPedido(pedido);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        BigDecimal valorTotal = pedido.getListaPedidoItem().stream()
                .map(pedidoItem -> pedidoItem.getValorUnitario().multiply(new BigDecimal(pedidoItem.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Optional<Cliente> clienteEncontrado = clienteRepository.findById(pedido.getCliente_id());
        Cliente cliente = clienteEncontrado.get();

        Optional<Endereco> enderecoEncontrado = enderecoRepository.findById(pedido.getEndereco_id());
        Endereco endereco = enderecoEncontrado.get();

        Pedido pedidoEntidade = new Pedido();
        pedidoEntidade.setFormaPagamento(pedido.getFormaPagamento());
        pedidoEntidade.setStatus(pedido.getStatus());
        pedidoEntidade.setValorTotal(valorTotal);
        pedidoEntidade.setCliente(cliente);
        pedidoEntidade.setEndereco(endereco);

        Pedido resultadoPedido = pedidoRepository.save(pedidoEntidade);

        List<PedidoItemResponseDom> responseListPedidoItem = pedidoItemService.criarListaPedidoItem(resultadoPedido.getId(),pedido.getListaPedidoItem());
        List<PedidoPedidoItemResponseDom> responseListPedidoPedidoItem =
                responseListPedidoItem.stream().map(PedidoPedidoItemMappers::pedidoItemResponseDomParaPedidoPedidoItemResponseDom).toList();

        estoqueService.atualizarListaEstoque(pedido.getListaPedidoItem());

        return PedidoMappers.pedidoPostParaPedidoResponseDom(resultadoPedido,responseListPedidoPedidoItem);
    }

    public PedidoResponseDom atualizarStatus(Long id, PedidoRequestDom pedido) throws CustomException {
        List<String> mensagens = new ArrayList<>();
        String mensagem = this.validaIdPathVariablePedido(id);

        if(pedido.getStatus() == null){
            mensagens.add("Status do pedido não informado!");
        }
        if(mensagem != null){
            mensagens.add(mensagem);
        }
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Pedido> resultado = pedidoRepository.findById(id).map(record -> {
            record.setStatus(pedido.getStatus());
            return pedidoRepository.save(record);
        });

        return resultado.map(PedidoMappers::pedidoParaPedidoResponseDom).orElse(null);
    }

    private List<String> validaPedido(PedidoRequestDom pedido){
        List<String> mensagens = new ArrayList<>();

        if(pedido.getFormaPagamento() == null){
            mensagens.add("Forma de pagamento do pedido não informada!");
        }

        if(pedido.getStatus() == null){
            mensagens.add("Status do pedido não informado!");
        }

        if(pedido.getCliente_id() == null){
            mensagens.add("cliente_id do pedido não informado!");
        } else if(clienteRepository.findById(pedido.getCliente_id()).isEmpty()){
            mensagens.add("cliente_id do pedido inválido!");
        }

        if(pedido.getEndereco_id() == null){
            mensagens.add("endereco_id do pedido não informado!");
        } else if(enderecoRepository.findById(pedido.getEndereco_id()).isEmpty()){
            mensagens.add("endereco_id do pedido inválido!");
        }

        return  mensagens;
    }

    private String validaIdPathVariablePedido(Long id){
        if (pedidoRepository.findById(id).isEmpty()){
            return "Id do Pedido inválido!";
        }
        return null;
    }
}
