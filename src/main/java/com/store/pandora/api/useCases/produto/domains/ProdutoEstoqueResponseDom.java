package com.store.pandora.api.useCases.produto.domains;

public class ProdutoEstoqueResponseDom extends ProdutoResponseDom{

    private Integer quantidadeEstoque;

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
