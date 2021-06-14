package com.bodeguin.bodegaservice.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bodeguin.bodegaservice.dto.BodegaDto;
import com.bodeguin.bodegaservice.entities.Bodega;


@Component
public class BodegaDtoToEntity {
	@Autowired
	private ModelMapper modelMapper;
	
	public Bodega convertDtoToEntity(BodegaDto bodegaDto) {
        return modelMapper.map(bodegaDto, Bodega.class);
    }
	 public List<Bodega> convertDtoToEntity(List<BodegaDto> bodegasDto) {
	        return bodegasDto.stream()
	                .map(bodegaDto -> convertDtoToEntity(bodegaDto))
	                .collect(Collectors.toList());
	 }
}
