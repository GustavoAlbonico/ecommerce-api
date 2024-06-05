package com.store.pandora.api.useCases.pix;

import com.store.pandora.api.entitys.Cartao;
import com.store.pandora.api.entitys.Pedido;
import com.store.pandora.api.entitys.Pix;
import com.store.pandora.api.useCases.cartao.domains.CartaoRequestDom;
import com.store.pandora.api.useCases.cartao.domains.CartaoResponseDom;
import com.store.pandora.api.useCases.cartao.implement.mappers.CartaoMappers;
import com.store.pandora.api.useCases.pedido.implement.repositorys.PedidoRepository;
import com.store.pandora.api.useCases.pix.domains.PixRequestDom;
import com.store.pandora.api.useCases.pix.domains.PixResponseDom;
import com.store.pandora.api.useCases.pix.implement.mappers.PixMappers;
import com.store.pandora.api.useCases.pix.implement.repositorys.PixRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PixService {

    @Autowired
    PixRepository pixRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    public PixResponseDom criarPix(PixRequestDom pix) throws CustomException{
        List<String> mensagens = this.validaPix(pix);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(pix.getPedido_id());
        Pedido pedido = pedidoEncontrado.get();

        Pix pixEntidade = new Pix();
        pixEntidade.setValor(pix.getValor());
        pixEntidade.setDataExpiracao(LocalDateTime.now().plusMinutes(30));
        pixEntidade.setPedido(pedido);

        Pix resultado = pixRepository.save(pixEntidade);

        return PixMappers.pixParaPixResponseDom(resultado);
    }

    public PixResponseDom carregarPixById(Long id) throws CustomException{
        String mensagem = this.validaIdPathVariablePix(id);

        if(mensagem != null){
            throw new CustomException(mensagem);
        }

        Optional<Pix> resultado = pixRepository.findById(id);

        return resultado.map(PixMappers::pixParaPixResponseDom).orElse(null);
    }

    public List<PixResponseDom> carregarPix(){
        List<Pix> resultadoLista = pixRepository.findAll();
        List<PixResponseDom> responseLista = new ArrayList<>();

        if (!resultadoLista.isEmpty()){
            responseLista = resultadoLista.stream().map(PixMappers::pixParaPixResponseDom).toList();
        }

        return responseLista;
    }

    public PixResponseDom atualizarPix(Long id, PixRequestDom pix) throws CustomException{
        List<String> mensagens = this.validaPix(pix);
        String mensagem = this.validaIdPathVariablePix(id);

        if(mensagem != null){
            mensagens.add(mensagem);
        }
        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Pix> resultado = pixRepository.findById(id).map(record -> {
            Optional<Pedido> pedidoEncontrado =  pedidoRepository.findById(pix.getPedido_id());
            Pedido pedido = pedidoEncontrado.get();

            record.setValor(pix.getValor());
            record.setPedido(pedido);

            return pixRepository.save(record);
        });

        return resultado.map(PixMappers::pixParaPixResponseDom).orElse(null);
    }

    public void excluirPix(Long id){
        pixRepository.deleteById(id);
    }

    private List<String> validaPix(PixRequestDom pix){
        List<String> mensagens = new ArrayList<>();

        if (pix.getPedido_id() == null) {
            mensagens.add("pedido_id do pix não informado!");
        } else if (pedidoRepository.findById(pix.getPedido_id()).isEmpty()) {
            mensagens.add("pedido_id do pix inválido!");
        }

        if (pix.getValor() == null) {
            mensagens.add("Valor do pix não informado!");
        } else if (pix.getValor().compareTo(BigDecimal.ZERO) < 1) {
            mensagens.add("Valor do pix inválido!");
        }
        return mensagens;
    }

    private String validaIdPathVariablePix(Long id){
        if (pixRepository.findById(id).isEmpty()){
           return "Id do pix inválido!";
        }
        return null;
    }
}
