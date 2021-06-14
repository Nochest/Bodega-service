package com.bodeguin.bodegaservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bodeguin.bodegaservice.entities.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer> {

}