package com.store.pandora.api.useCases.pedido.implement.mappers;

import com.store.pandora.api.entitys.Produto;
import com.store.pandora.api.useCases.pedido.domains.PedidoProdutoResponseDom;

public class PedidoProdutoMappers {
    public static PedidoProdutoResponseDom produtoParaPedidoGetProdutoResponseDom(Produto produto){
        PedidoProdutoResponseDom response = new PedidoProdutoResponseDom();

        response.setNome(produto.getNome());
        response.setDescricao(produto.getDescricao());
        response.setImagem(produto.getImagem());

        return response;
    }

}
