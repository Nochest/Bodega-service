package com.bodeguin.bodegaservice.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bodeguin.bodegaservice.dto.VendedorDto;
import com.bodeguin.bodegaservice.entities.Vendedor;

@Component
public class VendedorDtoToEntity {

	@Autowired
	private ModelMapper modelMapper;
	
	public Vendedor convertDtoToEntity(VendedorDto vendedorDto) {
        return modelMapper.map(vendedorDto, Vendedor.class);
    }
	 public List<Vendedor> convertDtoToEntity(List<VendedorDto> vendedoresDto) {
	        return vendedoresDto.stream()
	                .map(vendedorDto -> convertDtoToEntity(vendedorDto))
	                .collect(Collectors.toList());
	 }
}
