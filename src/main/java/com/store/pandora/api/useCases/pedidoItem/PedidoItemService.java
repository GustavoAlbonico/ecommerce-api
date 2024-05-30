package com.store.pandora.api.useCases.pedidoItem;

import com.store.pandora.api.entitys.Pedido;
import com.store.pandora.api.entitys.PedidoItem;
import com.store.pandora.api.entitys.Produto;
import com.store.pandora.api.useCases.pedido.domains.PedidoPedidoItemRequestDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoPedidoItemResponseDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoResponseDom;
import com.store.pandora.api.useCases.pedido.implement.repositorys.PedidoRepository;
import com.store.pandora.api.useCases.pedidoItem.domains.PedidoItemRequestDom;
import com.store.pandora.api.useCases.pedidoItem.domains.PedidoItemResponseDom;
import com.store.pandora.api.useCases.pedidoItem.implement.mappers.PedidoItemMappers;
import com.store.pandora.api.useCases.pedidoItem.implement.repositorys.PedidoItemRepository;
import com.store.pandora.api.useCases.produto.implement.repositorys.ProdutoRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<PedidoItemResponseDom> criarListaPedidoItem(Long pedidoId, List<PedidoPedidoItemRequestDom> listaPedidoItem) throws CustomException{

//        List<String> mensagens = this.validaPedidoItem(listaPedidoItem);
//
//        if (!mensagens.isEmpty()){
//            throw new CustomException(mensagens);
//        }

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

        List<PedidoItem> resultadoLista = pedidoItemRepository.saveAll(listaPedidoItemEntidade);

        return resultadoLista.stream().map(PedidoItemMappers::pedidoItemParaPedidoItemResponseDom).collect(Collectors.toList());
    }
}
