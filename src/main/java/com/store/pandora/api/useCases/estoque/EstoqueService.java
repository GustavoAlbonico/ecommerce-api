package com.store.pandora.api.useCases.estoque;

import com.store.pandora.api.entitys.Estoque;
import com.store.pandora.api.entitys.Produto;
import com.store.pandora.api.useCases.estoque.domains.EstoqueResponseDom;
import com.store.pandora.api.useCases.estoque.domains.EstoqueResquestDom;
import com.store.pandora.api.useCases.estoque.implement.mappers.EstoqueMappers;
import com.store.pandora.api.useCases.estoque.implement.repositorys.EstoqueRepository;
import com.store.pandora.api.useCases.produto.implement.repositorys.ProdutoRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public EstoqueResponseDom carregarEstoqueById(Long id){
        Optional<Estoque> resultado = estoqueRepository.findById(id);
        return resultado.map(EstoqueMappers::estoqueParaEstoqueResponseDom).orElse(null);
    }

    public List<EstoqueResponseDom> carregarEstoque(){
        List<Estoque> resultadoLista = estoqueRepository.findAll();
        List<EstoqueResponseDom> responseLista = new ArrayList<>();

        if (!resultadoLista.isEmpty()){
            responseLista = resultadoLista.stream().map(EstoqueMappers::estoqueParaEstoqueResponseDom).toList();
        }

        return responseLista;
    }

    public EstoqueResponseDom criarEstoque(EstoqueResquestDom estoque) throws CustomException {

        List<String> mensagens =  this.validaEstoque(estoque);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Estoque estoqueEntidade = new Estoque();
        estoqueEntidade.setQuantidade(estoque.getQuantidade());
        Optional<Produto> produtoEncontrado =  produtoRepository.findById(estoque.getProduto_id());
        Produto produto = produtoEncontrado.get();
        estoqueEntidade.setProduto(produto);


        Estoque resultado = estoqueRepository.save(estoqueEntidade);

        return EstoqueMappers.estoqueParaEstoqueResponseDom(resultado);
    }

    public EstoqueResponseDom atualizarEstoque(Long id, EstoqueResquestDom estoque) throws CustomException{

        List<String> mensagens = this.validaEstoque(estoque);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Estoque> resultado = estoqueRepository.findById(id).map(record -> {
            record.setQuantidade(estoque.getQuantidade());
            Optional<Produto> produtoEncontrado =  produtoRepository.findById(estoque.getProduto_id());
            Produto produto = produtoEncontrado.get();
            record.setProduto(produto);

            return estoqueRepository.save(record);
        });

        return resultado.map(EstoqueMappers::estoqueParaEstoqueResponseDom).orElse(null);
    }

    public void excluirEstoque(Long id){
        estoqueRepository.deleteById(id);
    }

    private List<String> validaEstoque(EstoqueResquestDom estoque){
        List<String> mensagens =  new ArrayList<>();
        Optional<Produto> produtoEncontrado =  produtoRepository.findById(estoque.getProduto_id());

        if (estoque.getQuantidade() == null){
            mensagens.add("Quantidade do estoque não informado");
        }
        if (estoque.getQuantidade() < 0){
            mensagens.add("Quantidade do estoque inválida");
        }
        if (estoque.getProduto_id() == null){
            mensagens.add("Produto do estoque não informado");
        }
        if (estoque.getProduto_id() <= 0){
            mensagens.add("Produto do estoque inválido");
        }
        if (produtoEncontrado.isEmpty()){
            mensagens.add("Produto não encontrado!");
        }

        return mensagens;
    }
}
