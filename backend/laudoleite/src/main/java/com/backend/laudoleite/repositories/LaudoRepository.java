package com.backend.laudoleite.repositories;

import com.backend.laudoleite.domain.Laudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LaudoRepository extends JpaRepository<Laudo, Integer> {
    @Transactional(readOnly=true)
    List<Laudo> findBySituacao(Integer situacao);

}
