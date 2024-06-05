package com.store.pandora.api.useCases.pix.implement.repositorys;

import com.store.pandora.api.entitys.Pix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixRepository extends JpaRepository<Pix, Long> {
}
