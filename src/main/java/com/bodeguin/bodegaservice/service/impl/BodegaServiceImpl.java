package com.bodeguin.bodegaservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bodeguin.bodegaservice.entities.Bodega;
import com.bodeguin.bodegaservice.repository.BodegaRepository;
import com.bodeguin.bodegaservice.service.BodegaService;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository bodegaRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Bodega> findAll() throws Exception {
		return bodegaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Bodega> findById(Integer id) throws Exception {
		return bodegaRepository.findById(id);
	}

	@Override
	public Bodega save(Bodega t) throws Exception {
		return bodegaRepository.save(t);
	}

	@Override
	public Bodega update(Bodega t) throws Exception {
		return bodegaRepository.save(t);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		bodegaRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		bodegaRepository.deleteAll();
	}

}
