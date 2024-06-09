package com.store.pandora.api.useCases.cliente.implement.repositorys;

import com.store.pandora.api.entitys.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
