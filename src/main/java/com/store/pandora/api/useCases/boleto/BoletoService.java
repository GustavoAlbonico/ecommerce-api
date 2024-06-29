package com.store.pandora.api.useCases.boleto;

import com.store.pandora.api.entitys.Boleto;
import com.store.pandora.api.entitys.Pedido;
import com.store.pandora.api.useCases.boleto.domains.BoletoRequestDom;
import com.store.pandora.api.useCases.boleto.domains.BoletoResponseDom;
import com.store.pandora.api.useCases.boleto.implement.mappers.BoletoMappers;
import com.store.pandora.api.useCases.boleto.implement.repositorys.BoletoRepository;
import com.store.pandora.api.useCases.pedido.implement.repositorys.PedidoRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoletoService {

    @Autowired
    BoletoRepository boletoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    public BoletoResponseDom criarBoleto(BoletoRequestDom boleto) throws CustomException {
        List<String> mensagens = this.validaBoleto(boleto);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(boleto.getPedido_id());
        Pedido pedido = pedidoEncontrado.get();

        Boleto boletoEntidade = new Boleto();
        boletoEntidade.setValor(boleto.getValor());
        boletoEntidade.setDataVencimento(LocalDateTime.now().plusDays(1));
        boletoEntidade.setPedido(pedido);

        Boleto resultado = boletoRepository.save(boletoEntidade);

        return BoletoMappers.boletoParaBoletoResponseDom(resultado);
    }

    public BoletoResponseDom carregarBoletoById(Long id) throws CustomException {
        String mensagem = this.validaIdPathVariableBoleto(id);

        if(mensagem != null){
            throw new CustomException(mensagem);
        }

        Optional<Boleto> resultado = boletoRepository.findById(id);

        return  resultado.map(BoletoMappers::boletoParaBoletoResponseDom).orElse(null);
    }

    public List<BoletoResponseDom> carregarBoleto (){
        List<Boleto> resultadoLista = boletoRepository.findAll();
        List<BoletoResponseDom> responseLista = new ArrayList<>();

        if(responseLista.isEmpty()){
            responseLista = resultadoLista.stream().map(BoletoMappers::boletoParaBoletoResponseDom).toList();
        }

        return responseLista;
    }

    public BoletoResponseDom atualizarBoleto(Long id, BoletoRequestDom boleto) throws CustomException {
        List<String> mensagens = this.validaBoleto(boleto);
        String mensagem = this.validaIdPathVariableBoleto(id);

        if(mensagem != null){
            mensagens.add(mensagem);
        }
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Boleto> resultado = boletoRepository.findById(id).map(record -> {
            Optional<Pedido> pedidoEncontrado =  pedidoRepository.findById(boleto.getPedido_id());
            Pedido pedido = pedidoEncontrado.get();

            record.setValor(boleto.getValor());
            record.setPedido(pedido);

            return boletoRepository.save(record);
        });

        return resultado.map(BoletoMappers::boletoParaBoletoResponseDom).orElse(null);
    }

    public void excluirBoleto(Long id){
        boletoRepository.deleteById(id);
    }

    private List<String> validaBoleto(BoletoRequestDom boleto) {
        List<String> mensagens = new ArrayList<>();

        if (boleto.getPedido_id() == null) {
            mensagens.add("pedido_id do boleto não informado!");
        } else if (pedidoRepository.findById(boleto.getPedido_id()).isEmpty()) {
            mensagens.add("pedido_id do boleto inválido!");
        }

        if (boleto.getValor() == null) {
            mensagens.add("Valor do boleto não informado!");
        } else if (boleto.getValor().compareTo(BigDecimal.ZERO) < 1) {
            mensagens.add("Valor do boleto inválido!");
        }
        return mensagens;
    }

    private String validaIdPathVariableBoleto(Long id){
        if (boletoRepository.findById(id).isEmpty()){
            return "Id do boleto inválido!";
        }
        return null;
    }

}
