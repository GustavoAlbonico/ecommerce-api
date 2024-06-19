package com.store.pandora.api.useCases.produto.implement.mappers;

import com.store.pandora.api.entitys.Produto;
import com.store.pandora.api.useCases.produto.domains.ProdutoEstoqueResponseDom;

public class ProdutoEstoqueMappers {
    public static ProdutoEstoqueResponseDom produtoParaProdutoEstoqueResponseDom(Produto produto){
        ProdutoEstoqueResponseDom response = new ProdutoEstoqueResponseDom();

        response.setId(produto.getId());
        response.setNome(produto.getNome());
        response.setValorUnitario(produto.getValorUnitario());
        response.setImagem(produto.getImagem());
        response.setDescricao(produto.getDescricao());
        response.setClassificacaoIndicativa(produto.getClassificacaoIndicativa());
        response.setNumeroJogadores(produto.getNumeroJogadores());
        response.setCategoria(produto.getCategoria());
        response.setDeletedAt(produto.getDeletedAt());

        return response;
    }
}
