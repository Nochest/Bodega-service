package com.bodeguin.bodegaservice.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bodeguin.bodegaservice.dto.VendedorDto;
import com.bodeguin.bodegaservice.entities.Vendedor;

@Component
public class VendedorEntityToDto {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public VendedorDto convertEntityToDto(Vendedor vendedor) {
		return modelMapper.map(vendedor, VendedorDto.class);
	}
	
	public List<VendedorDto> convertEntityToDto(List<Vendedor> vendedores) {
		return vendedores.stream()
				.map(vendedor -> convertEntityToDto(vendedor))
				.collect(Collectors.toList());
	}
}
