package com.store.pandora.api.useCases.boleto.implement.repositorys;

import com.store.pandora.api.entitys.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long> {
}
