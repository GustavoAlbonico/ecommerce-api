package com.store.pandora.api.useCases.estoque.implement.repositorys;

import com.store.pandora.api.entitys.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {
}
