package com.backend.laudoleite.repositories;

import com.backend.laudoleite.domain.Laudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaudoRepository extends JpaRepository<Laudo, Integer> {

}
