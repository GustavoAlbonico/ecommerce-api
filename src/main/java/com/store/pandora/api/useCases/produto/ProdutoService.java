package com.store.pandora.api.useCases.produto;

import com.store.pandora.api.entitys.Produto;
import com.store.pandora.api.useCases.produto.domains.ProdutoRequestDom;
import com.store.pandora.api.useCases.produto.domains.ProdutoResponseDom;
import com.store.pandora.api.useCases.produto.implement.ProdutoRepository;
import com.store.pandora.api.utils.CustomException;
import org.aspectj.weaver.patterns.PointcutRewriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponseDom carregarProdutoById(Long id) {
        Optional<Produto> resultado = produtoRepository.findById(id);

        if(resultado.isPresent()){
            Produto produto = resultado.get();
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
        return null;
    }

    public List<ProdutoResponseDom> carregarProduto(){
        List<Produto> resultadoLista = produtoRepository.findAll();
        List<ProdutoResponseDom> responseLista = new ArrayList<>();

        for(Produto resultado : resultadoLista){
            ProdutoResponseDom aux = new ProdutoResponseDom();
            aux.setId(resultado.getId());
            aux.setNome(resultado.getNome());
            aux.setValorUnitario(resultado.getValorUnitario());
            aux.setImagem(resultado.getImagem());
            aux.setDescricao(resultado.getDescricao());
            aux.setClassificacaoIndicativa(resultado.getClassificacaoIndicativa());
            aux.setNumeroJogadores(resultado.getNumeroJogadores());
            aux.setCategoriasEnum(resultado.getCategoriasEnum());
            aux.setDeletedAt(resultado.getDeletedAt());

            responseLista.add(aux);
        }
        return responseLista;
    }

    public ProdutoResponseDom criarProduto(ProdutoRequestDom produto) throws CustomException {

        List<String> mensagens = this.validaProduto(produto);
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Produto produtoEntidade = new Produto();
        produtoEntidade.setNome(produto.getNome());
        produtoEntidade.setValorUnitario(produto.getValorUnitario());
        produtoEntidade.setImagem(produto.getImagem());
        produtoEntidade.setDescricao(produto.getDescricao());
        produtoEntidade.setClassificacaoIndicativa(produto.getClassificacaoIndicativa());
        produtoEntidade.setNumeroJogadores(produto.getNumeroJogadores());
        produtoEntidade.setCategoriasEnum(produto.getCategoriasEnum());
        produtoEntidade.setDeletedAt(produto.getDeletedAt());

        Produto resultado = produtoRepository.save(produtoEntidade);

        ProdutoResponseDom response = new ProdutoResponseDom();

        response.setId(resultado.getId());
        response.setNome(resultado.getNome());
        response.setValorUnitario(resultado.getValorUnitario());
        response.setImagem(resultado.getImagem());
        response.setDescricao(resultado.getDescricao());
        response.setClassificacaoIndicativa(resultado.getClassificacaoIndicativa());
        response.setNumeroJogadores(resultado.getNumeroJogadores());
        response.setCategoriasEnum(resultado.getCategoriasEnum());
        response.setDeletedAt(resultado.getDeletedAt());

        return response;
    }

    public ProdutoResponseDom atualizarProduto(Long id, ProdutoRequestDom produto) throws CustomException {

        List<String> mensagens = this.validaProduto(produto);
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Produto> resultado = produtoRepository.findById(id).map(record -> {
            record.setNome(produto.getNome());
            record.setValorUnitario(produto.getValorUnitario());
            record.setImagem(produto.getImagem());
            record.setDescricao(produto.getDescricao());
            record.setClassificacaoIndicativa(produto.getClassificacaoIndicativa());
            record.setNumeroJogadores(produto.getNumeroJogadores());
            record.setCategoriasEnum(produto.getCategoriasEnum());
            record.setDeletedAt(produto.getDeletedAt());

            return produtoRepository.save(record);
        });

        if(resultado.isPresent()) {
            Produto produtoEntidade = resultado.get();

            ProdutoResponseDom response = new ProdutoResponseDom();
            response.setNome(produtoEntidade.getNome());
            response.setValorUnitario(produtoEntidade.getValorUnitario());
            response.setImagem(produtoEntidade.getImagem());
            response.setDescricao(produtoEntidade.getDescricao());
            response.setClassificacaoIndicativa(produtoEntidade.getClassificacaoIndicativa());
            response.setNumeroJogadores(produtoEntidade.getNumeroJogadores());
            response.setCategoriasEnum(produtoEntidade.getCategoriasEnum());
            response.setDeletedAt(produtoEntidade.getDeletedAt());

            return response;
        }
        return null;
    }

    private List<String> validaProduto(ProdutoRequestDom produto){

        List<String> mensagens = new ArrayList<>();

        if(produto.getNome() == null || produto.getNome().equals("")){
            mensagens.add("Nome do produto não informado");
        }

        if(produto.getValorUnitario() == null || Objects.equals(produto.getValorUnitario(), new BigDecimal(BigInteger.ZERO))){
            mensagens.add("Valor unitário do produto não informado");
        }

        if(produto.getImagem() == null || produto.getImagem().equals("")){
            mensagens.add("Imagem do produto não informado");
        }

        if(produto.getCategoriasEnum() == null){
            mensagens.add("Categoria do produto não informado");
        }

        return mensagens;
    }
}
