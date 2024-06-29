package com.store.pandora.api.useCases.pedido;

import com.store.pandora.api.entitys.*;
import com.store.pandora.api.useCases.boleto.BoletoService;
import com.store.pandora.api.useCases.cartao.CartaoService;
import com.store.pandora.api.useCases.cliente.implement.repositorys.ClienteRepository;
import com.store.pandora.api.useCases.endereco.implement.repositorys.EnderecoRepository;
import com.store.pandora.api.useCases.estoque.EstoqueService;
import com.store.pandora.api.useCases.pedido.domains.*;
import com.store.pandora.api.useCases.pedido.implement.mappers.PedidoMappers;
import com.store.pandora.api.useCases.pedido.implement.repositorys.PedidoRepository;
import com.store.pandora.api.useCases.pedidoItem.PedidoItemService;
import com.store.pandora.api.useCases.pix.PixService;
import com.store.pandora.api.useCases.usuario.implement.repositorys.UsuarioRepository;
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

    @Autowired
    UsuarioRepository usuarioRepository;

    private  final PedidoItemService pedidoItemService;
    private  final EstoqueService estoqueService;

    private  final PixService pixService;

    private  final CartaoService cartaoService;

    private  final BoletoService boletoService;

    public PedidoService(PedidoItemService pedidoItemService, EstoqueService estoqueService,PixService pixService,CartaoService cartaoService,BoletoService boletoService) {
        this.pedidoItemService = pedidoItemService;
        this.estoqueService = estoqueService;
        this.pixService = pixService;
        this.cartaoService = cartaoService;
        this.boletoService = boletoService;
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

        List<PedidoItem> responseListPedidoItem = pedidoItemService.criarListaPedidoItem(resultadoPedido.getId(),pedido.getListaPedidoItem());

        estoqueService.atualizarListaEstoque(pedido.getListaPedidoItem());

        switch (pedido.getFormaPagamento()){
            case PIX:
                PedidoPixRequestDom pixRequestDom =
                        PedidoMappers.pedidoParaPedidoPixRequestDom(resultadoPedido);
                pixService.criarPix(pixRequestDom);
                break;
            case BOLETO:
                PedidoBoletoRequestDom boletoRequestDom =
                        PedidoMappers.pedidoParaBoletoRequestDom(resultadoPedido, pedido.getDadosFormaPagamento());
                boletoService.criarBoleto(boletoRequestDom);
                break;
            case CARTAO:
                PedidoCartaoRequestDom cartaoRequestDom =
                        PedidoMappers.pedidoParaCartaoRequestDom(resultadoPedido, pedido.getDadosFormaPagamento());
                cartaoService.criarCartao(cartaoRequestDom);
                break;
        }

        return PedidoMappers.pedidoParaPedidoPostResponseDom(resultadoPedido,responseListPedidoItem);
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

    public List<PedidoResponseDom> carregarPedidoByUsuarioId(Long id) throws CustomException{
        String mensagem = this.validaIdPathVariableUsuario(id);

        if(mensagem != null){
            throw new CustomException(mensagem);
        }

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        List<Pedido> listaPedidosEcontrados = pedidoRepository.findByClienteId(usuarioEncontrado.get().getCliente().getId());

        return listaPedidosEcontrados.stream().map(PedidoMappers::pedidoParaPedidoResponseDom).toList();
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

    private String validaIdPathVariableUsuario(Long id){
        if (usuarioRepository.findById(id).isEmpty()){
            return "Id do Usuário inválido!";
        }
        return null;
    }
}
