package com.store.pandora.api.useCases.produto.implement.mappers;
import com.store.pandora.api.entitys.Produto;
import com.store.pandora.api.useCases.produto.domains.ProdutoResponseDom;

public class ProdutoMappers {
    public static ProdutoResponseDom produtoParaProdutoResponseDom(Produto produto){
        ProdutoResponseDom response = new ProdutoResponseDom();

        response.setId(produto.getId());
        response.setNome(produto.getNome());
        response.setValorUnitario(produto.getValorUnitario());
        response.setImagem(produto.getImagem());
        response.setDescricao(produto.getDescricao());
        response.setClassificacaoIndicativa(produto.getClassificacaoIndicativa());
        response.setNumeroJogadores(produto.getNumeroJogadores());
        response.setCategoriasEnum(produto.getCategoriasEnum());
        response.setDeletedAt(produto.getDeletedAt());

        return response;
    }
}
