package com.store.pandora.api.useCases.estoque.implement.repositorys;

import com.store.pandora.api.entitys.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque,Long> {
}
