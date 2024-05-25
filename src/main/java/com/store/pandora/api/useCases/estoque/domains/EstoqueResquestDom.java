package com.store.pandora.api.useCases.estoque.domains;

public class EstoqueResquestDom {

    private Integer quantidade;

    private Long produto_id;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }
}
