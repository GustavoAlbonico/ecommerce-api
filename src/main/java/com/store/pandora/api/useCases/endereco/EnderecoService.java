package com.store.pandora.api.useCases.endereco;

import com.store.pandora.api.entitys.Endereco;
import com.store.pandora.api.useCases.endereco.domains.EnderecoRequestDom;
import com.store.pandora.api.useCases.endereco.domains.EnderecoResponseDom;
import com.store.pandora.api.useCases.endereco.implement.mappers.EnderecoMappers;
import com.store.pandora.api.useCases.endereco.implement.repositorys.EnderecoRepository;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoResponseDom carregarEnderecoById(Long id){

        Optional<Endereco> resultado = enderecoRepository.findById(id);

        return resultado.map(EnderecoMappers::enderecoParaEnderecoResponseDom).orElse(null);
    }

    public List<EnderecoResponseDom> carregarEndereco(){

        List<Endereco> resultadoLista = enderecoRepository.findAll();
        List<EnderecoResponseDom> responseLista = new ArrayList<>();

        if(!resultadoLista.isEmpty()) {
            responseLista = resultadoLista.stream().map(EnderecoMappers::enderecoParaEnderecoResponseDom).toList();
        }
        return responseLista;
    }

    public EnderecoResponseDom criarEndereco(EnderecoRequestDom endereco) throws CustomException {

        List<String> mensagens = this.validaEndereco(endereco);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Endereco enderecoEntidade = new Endereco();
        enderecoEntidade.setApelido(endereco.getApelido());
        enderecoEntidade.setLogradouro(endereco.getLogradouro());
        enderecoEntidade.setCep(endereco.getCep());
        enderecoEntidade.setBairro(endereco.getBairro());
        enderecoEntidade.setNumero(endereco.getNumero());
        enderecoEntidade.setComplemento(endereco.getComplemento());

        Endereco resultado = enderecoRepository.save(enderecoEntidade);

        return EnderecoMappers.enderecoParaEnderecoResponseDom(resultado);
    }

    public EnderecoResponseDom atualizarEndereco(Long id, EnderecoRequestDom endereco) throws CustomException {
                List<String> mensagens = this.validaEndereco(endereco);

        if(!mensagens.isEmpty()){
            throw new CustomException(mensagens);
        }

        Optional<Endereco> resultado = enderecoRepository.findById(id).map(record -> {
            record.setApelido(endereco.getApelido());
            record.setLogradouro(endereco.getLogradouro());
            record.setCep(endereco.getCep());
            record.setBairro(endereco.getBairro());
            record.setNumero(endereco.getNumero());
            record.setComplemento(endereco.getComplemento());

            return enderecoRepository.save(record);
        });

        return resultado.map(EnderecoMappers::enderecoParaEnderecoResponseDom).orElse(null);
    }

    private List<String> validaEndereco(EnderecoRequestDom endereco){

        List<String> mensagens = new ArrayList<>();

        if(endereco.getLogradouro() == null || endereco.getLogradouro().equals("")){
            mensagens.add("Logradouro do endereço não informado");
        }

        if(endereco.getCep() == null || endereco.getCep().equals("")){
            mensagens.add("CEP do endereço não informado");
        }

        if (endereco.getCep().length() <= 8) {
            mensagens.add("Quantidade de números do CEP insuficiente");
        }

        if(endereco.getBairro() == null || endereco.getBairro().equals("")){
            mensagens.add("Bairro do endereço não informado");
        }

        if(endereco.getNumero() == null || endereco.getNumero().equals("")) {
            mensagens.add("Número do endereço não informado");
        }

        return mensagens;
    }

}
