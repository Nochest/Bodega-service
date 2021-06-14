package com.bodeguin.bodegaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bodeguin.bodegaservice.entities.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
	
}
