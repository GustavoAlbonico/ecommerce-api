package com.store.pandora.api.useCases.pedido.implement.mappers;

import com.store.pandora.api.entitys.Produto;
import com.store.pandora.api.useCases.pedido.domains.PedidoGetProdutoResponseDom;
import com.store.pandora.api.useCases.pedido.domains.PedidoPedidoItemResponseDom;
import com.store.pandora.api.useCases.pedidoItem.domains.PedidoItemResponseDom;

public class PedidoProdutoMappers {
    public static PedidoGetProdutoResponseDom produtoParaPedidoGetProdutoResponseDom(Produto produto){
        PedidoGetProdutoResponseDom response = new PedidoGetProdutoResponseDom();

        response.setNome(produto.getNome());
        response.setDescricao(produto.getDescricao());
        response.setImagem(produto.getImagem());

        return response;
    }

}
