package com.bodeguin.bodegaservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodeguin.bodegaservice.dto.BodegaDto;
import com.bodeguin.bodegaservice.dto.CreateBodegaDto;
import com.bodeguin.bodegaservice.entities.Bodega;
import com.bodeguin.bodegaservice.repository.BodegaRepository;
import com.bodeguin.bodegaservice.service.BodegaService;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository bodegaRepository;
	
	private static final ModelMapper modelmapper = new ModelMapper();

	@Override
	public BodegaDto getBodegaById(Long id) throws Exception {
		return modelmapper.map(getBodegasEntity(id), BodegaDto.class);
	}

	@Transactional
	@Override
	public BodegaDto createBodega(CreateBodegaDto createBodegaDto) throws Exception {
		Bodega bodega = new Bodega();
		bodega.setNombre(createBodegaDto.getNombre());
		bodega.setDescripcion(createBodegaDto.getDescripcion());
		bodega.setDireccion(createBodegaDto.getDireccion());
		bodega.setRuc(createBodegaDto.getRuc());
		bodega.setLatitud(createBodegaDto.getLatitud());
		bodega.setLongitud(createBodegaDto.getLongitud());
		try {
			bodega = bodegaRepository.save(bodega);
		}catch (Exception e) {
			throw new Exception("Bad request");
		}
		return modelmapper.map(getBodegasEntity(bodega.getId()), BodegaDto.class);
	}

	@Override
	public List<BodegaDto> getBodegas() throws Exception {
		List<Bodega> bodegas = bodegaRepository.findAll();
		return bodegas.stream().map(bodega -> modelmapper.map(bodega, BodegaDto.class)).collect(Collectors.toList());
	}
	
	private Bodega getBodegasEntity(Long id) throws Exception {
		return bodegaRepository.findById(id).orElseThrow(()-> new Exception("Bad Request"));
	}
	
}
