package com.store.pandora.api.useCases.pedidoItem;

import com.store.pandora.api.entitys.Pedido;
import com.store.pandora.api.entitys.PedidoItem;
import com.store.pandora.api.entitys.Produto;
import com.store.pandora.api.useCases.pedido.domains.PedidoPedidoItemRequestDom;
import com.store.pandora.api.useCases.pedido.implement.repositorys.PedidoRepository;
import com.store.pandora.api.useCases.pedidoItem.domains.PedidoItemResponseDom;
import com.store.pandora.api.useCases.pedidoItem.implement.mappers.PedidoItemMappers;
import com.store.pandora.api.useCases.pedidoItem.implement.repositorys.PedidoItemRepository;
import com.store.pandora.api.useCases.produto.implement.repositorys.ProdutoRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoItemService {

    @Autowired
    PedidoItemRepository pedidoItemRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public List<PedidoItem> criarListaPedidoItem(Long pedidoId, List<PedidoPedidoItemRequestDom> listaPedidoItem) throws CustomException{

        List<String> mensagens = this.validaListaPedidoItem(listaPedidoItem);

        if (!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(pedidoId);
        Pedido pedido = pedidoEncontrado.get();

        List<PedidoItem>  listaPedidoItemEntidade = listaPedidoItem.stream().map(pedidoItem -> {

            Optional<Produto> produtoEncontrado = produtoRepository.findById(pedidoItem.getProduto_id());
            Produto produto = produtoEncontrado.get();

            PedidoItem pedidoItemEntidade = new PedidoItem();

            pedidoItemEntidade.setQuantidade(pedidoItem.getQuantidade());
            pedidoItemEntidade.setValorUnitario(pedidoItem.getValorUnitario());
            pedidoItemEntidade.setPedido(pedido);
            pedidoItemEntidade.setProduto(produto);

            return pedidoItemEntidade;
        }).toList();

        return pedidoItemRepository.saveAll(listaPedidoItemEntidade);
    }

    private List<String> validaListaPedidoItem(List<PedidoPedidoItemRequestDom> listaPedidoItemRequest){

        List<String> mensagens = new ArrayList<>();

        for(PedidoPedidoItemRequestDom pedidoItemRequest : listaPedidoItemRequest){

            Optional<Produto> produtoEncontrado = produtoRepository.findById(pedidoItemRequest.getProduto_id());

            if(pedidoItemRequest.getProduto_id() == null){
                mensagens.add("produto_id do produto não informado!");
                continue;
            } else if(produtoEncontrado.isEmpty()){
                mensagens.add("produto_id " + pedidoItemRequest.getProduto_id() + " inválido!");
                continue;
            }

            if(pedidoItemRequest.getQuantidade() == null){
                mensagens.add("Quantidade do produto " + produtoEncontrado.get().getNome() + " não informada!");
            } else if(pedidoItemRequest.getQuantidade() <= 0){
                mensagens.add("Quantidade do produto " + produtoEncontrado.get().getNome() + " inválida!");
            }

            if(pedidoItemRequest.getValorUnitario() == null){
                mensagens.add("Valor Unitário do produto " + produtoEncontrado.get().getNome() + " não informado!");
            } else if(pedidoItemRequest.getValorUnitario().compareTo(BigDecimal.ZERO) < 1){
                mensagens.add("Valor Unitário do produto " + produtoEncontrado.get().getNome() + " inválido!");
            }
        }
        return mensagens;
    }
}
