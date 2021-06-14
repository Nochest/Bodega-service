package com.bodeguin.bodegaservice.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodeguin.bodegaservice.entities.Vendedor;
import com.bodeguin.bodegaservice.repository.VendedorRepository;
import com.bodeguin.bodegaservice.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService{

	@Autowired
	private VendedorRepository vendedorRepository;

	@Override
	public List<Vendedor> findAll() throws Exception {
		return vendedorRepository.findAll();
	}

	@Override
	public Optional<Vendedor> findById(Integer id) throws Exception {
		return vendedorRepository.findById(id);
	}

	@Override
	public Vendedor save(Vendedor t) throws Exception {
		return vendedorRepository.save(t);
	}

	@Override
	public Vendedor update(Vendedor t) throws Exception {
		return vendedorRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		vendedorRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		vendedorRepository.deleteAll();
	}
}