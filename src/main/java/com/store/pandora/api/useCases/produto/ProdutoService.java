package com.store.pandora.api.useCases.produto;

import com.store.pandora.api.entitys.CategoriasEnum;
import com.store.pandora.api.entitys.Produto;
import com.store.pandora.api.useCases.produto.domains.ProdutoRequestDom;
import com.store.pandora.api.useCases.produto.domains.ProdutoResponseDom;
import com.store.pandora.api.useCases.produto.implement.mappers.ProdutoMappers;
import com.store.pandora.api.useCases.produto.implement.repositorys.ProdutoRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return resultado.map(ProdutoMappers::produtoParaProdutoResponseDom).orElse(null);
    }

    public List<ProdutoResponseDom> carregarProduto(){
        List<Produto> resultadoLista = produtoRepository.findAll();
        List<ProdutoResponseDom> responseLista = new ArrayList<>();

        if (!resultadoLista.isEmpty()){
            responseLista = resultadoLista.stream().map(ProdutoMappers::produtoParaProdutoResponseDom).toList();
        }

        return responseLista;
    }

    public List<ProdutoResponseDom> carregarProdutosByCategoria(CategoriasEnum categoria) {
        List<Produto> resultadoLista = produtoRepository.findByCategoria(categoria);
        List<ProdutoResponseDom> responseLista = new ArrayList<>();

        if(!resultadoLista.isEmpty()) {
            responseLista =  resultadoLista.stream().map(ProdutoMappers::produtoParaProdutoResponseDom).toList();
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
        produtoEntidade.setCategoria(produto.getCategoria());
        produtoEntidade.setDeletedAt(produto.getDeletedAt());

        Produto resultado = produtoRepository.save(produtoEntidade);

        return ProdutoMappers.produtoParaProdutoResponseDom(resultado);
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
            record.setCategoria(produto.getCategoria());
            record.setDeletedAt(produto.getDeletedAt());

            return produtoRepository.save(record);
        });

        return resultado.map(ProdutoMappers::produtoParaProdutoResponseDom).orElse(null);
    }

    public void excluirProduto(Long id){
         produtoRepository.deleteById(id);
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

        if(produto.getCategoria() == null){
            mensagens.add("Categoria do produto não informado");
        }

        return mensagens;
    }
}
