package com.store.pandora.api.useCases.cartao;

import com.store.pandora.api.entitys.Cartao;
import com.store.pandora.api.entitys.Pedido;
import com.store.pandora.api.useCases.cartao.domains.CartaoRequestDom;
import com.store.pandora.api.useCases.cartao.domains.CartaoResponseDom;
import com.store.pandora.api.useCases.cartao.implement.mappers.CartaoMappers;
import com.store.pandora.api.useCases.cartao.implement.repositorys.CartaoRepository;
import com.store.pandora.api.useCases.pedido.implement.repositorys.PedidoRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public CartaoResponseDom criarCartao(CartaoRequestDom cartao) throws CustomException{
        List<String> mensagens =  this.validaCartao(cartao);
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Pedido> pedidoEncontrado =  pedidoRepository.findById(cartao.getPedido_id());
        Pedido pedido = pedidoEncontrado.get();

        Cartao cartaoEntidade = new Cartao();
        cartaoEntidade.setNumeroCartao(cartao.getNumeroCartao());
        cartaoEntidade.setCodigoSeguranca(cartao.getCodigoSeguranca());
        cartaoEntidade.setNomeTitular(cartao.getNomeTitular());
        cartaoEntidade.setValor(cartao.getValor());
        cartaoEntidade.setPedido(pedido);

        Cartao resultado = cartaoRepository.save(cartaoEntidade);

        return CartaoMappers.cartaoParaCartaoResponseDom(resultado);
    }

    public CartaoResponseDom carregarCartaoById(Long id) throws CustomException{
        String mensagem = this.validaIdPathVariableCartao(id);

        if(mensagem != null){
            throw new CustomException(mensagem);
        }

        Optional<Cartao> resultado = cartaoRepository.findById(id);
        return resultado.map(CartaoMappers::cartaoParaCartaoResponseDom).orElse(null);
    }

    public List<CartaoResponseDom> carregarCartao(){
        List<Cartao> resultadoLista = cartaoRepository.findAll();
        List<CartaoResponseDom> responseLista = new ArrayList<>();

        if (!resultadoLista.isEmpty()){
            responseLista = resultadoLista.stream().map(CartaoMappers::cartaoParaCartaoResponseDom).toList();
        }

        return responseLista;
    }

    public CartaoResponseDom atualizarCartao(Long id, CartaoRequestDom cartao) throws CustomException{

        List<String> mensagens = this.validaCartao(cartao);
        String mensagem = this.validaIdPathVariableCartao(id);

        if(mensagem != null){
            mensagens.add(mensagem);
        }
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Cartao> resultado = cartaoRepository.findById(id).map(record -> {
            Optional<Pedido> pedidoEncontrado =  pedidoRepository.findById(cartao.getPedido_id());
            Pedido pedido = pedidoEncontrado.get();

            record.setNumeroCartao(cartao.getNumeroCartao());
            record.setCodigoSeguranca(cartao.getCodigoSeguranca());
            record.setNomeTitular(cartao.getNomeTitular());
            record.setValor(cartao.getValor());
            record.setPedido(pedido);

            return cartaoRepository.save(record);
        });

        return resultado.map(CartaoMappers::cartaoParaCartaoResponseDom).orElse(null);
    }

    public void excluirCartao(Long id){
        cartaoRepository.deleteById(id);
    }

    private List<String> validaCartao(CartaoRequestDom cartao) {

        List<String> mensagens = new ArrayList<>();

        if (cartao.getPedido_id() == null) {
            mensagens.add("pedido_id do cartão não informado!");
        } else if (pedidoRepository.findById(cartao.getPedido_id()).isEmpty()) {
            mensagens.add("pedido_id do cartão inválido!");
        }

        if (cartao.getNumeroCartao() == null || cartao.getNumeroCartao().isEmpty()) {
            mensagens.add("Número do cartão não informado!");
        } else if (cartao.getNumeroCartao().length() < 14) {
            mensagens.add("Número do cartão inválido!");
        }

        if (cartao.getCodigoSeguranca() == null || cartao.getCodigoSeguranca().isEmpty()) {
            mensagens.add("Código de Segurança do cartão não informado!");
        } else if (cartao.getCodigoSeguranca().length() < 3) {
            mensagens.add("Código de Segurança do cartão inválido!");
        }

        if (cartao.getNomeTitular() == null || cartao.getNomeTitular().isEmpty()) {
            mensagens.add("Nome do Titular do cartão não informado!");
        } else if (cartao.getNomeTitular().length() < 5) {
            mensagens.add("Nome do Titular do cartão inválido!");
        }

        if(cartao.getValor() == null){
            mensagens.add("Valor do cartão não informado!");
        } else if(cartao.getValor().compareTo(BigDecimal.ONE) < 1){
            mensagens.add("Valor do cartão inválido!");
        }

        return mensagens;
    }

    private String validaIdPathVariableCartao(Long id){
        if (cartaoRepository.findById(id).isEmpty()){
            return "Id do pix inválido!";
        }
        return null;
    }
}
