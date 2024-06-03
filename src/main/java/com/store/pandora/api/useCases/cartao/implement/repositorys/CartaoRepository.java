package com.store.pandora.api.useCases.cartao.implement.repositorys;

import com.store.pandora.api.entitys.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository  extends JpaRepository<Cartao, Long> {
}
