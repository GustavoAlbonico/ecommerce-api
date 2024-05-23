package com.store.pandora.api.useCases.endereco.implement.repositorys;

import com.store.pandora.api.entitys.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
