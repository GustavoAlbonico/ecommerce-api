package com.store.pandora.api.useCases.pedido.implement.repositorys;

import com.store.pandora.api.entitys.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteId (Long id);
}
