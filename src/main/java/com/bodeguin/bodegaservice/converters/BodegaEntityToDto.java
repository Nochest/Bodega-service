package com.bodeguin.bodegaservice.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bodeguin.bodegaservice.dto.BodegaDto;
import com.bodeguin.bodegaservice.entities.Bodega;

@Component
public class BodegaEntityToDto {
	@Autowired
	private ModelMapper modelMapper;
	
	public BodegaDto convertEntityToDto(Bodega bodega) {
		return modelMapper.map(bodega, BodegaDto.class);
	}
	
	public List<BodegaDto> convertEntityToDto(List<Bodega> bodegas) {
		return bodegas.stream()
				.map(bodega -> convertEntityToDto(bodega))
				.collect(Collectors.toList());
	}
}
