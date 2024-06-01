package com.store.pandora.api.useCases.pedidoItem.implement.repositorys;

import com.store.pandora.api.entitys.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository <PedidoItem, Long> {
}
