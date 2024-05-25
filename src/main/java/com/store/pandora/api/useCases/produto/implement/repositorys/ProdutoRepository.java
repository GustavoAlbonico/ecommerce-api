package com.store.pandora.api.useCases.produto.implement.repositorys;

import com.store.pandora.api.entitys.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}