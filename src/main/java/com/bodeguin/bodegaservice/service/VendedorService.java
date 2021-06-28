package com.bodeguin.bodegaservice.service;

import java.util.List;

import com.bodeguin.bodegaservice.dto.CreateVendedorDto;
import com.bodeguin.bodegaservice.dto.VendedorDto;

public interface VendedorService {
	VendedorDto getVendedorById(Long id) throws Exception;
	VendedorDto createVendedor(CreateVendedorDto createVendedorDto) throws Exception;
	List<VendedorDto> getVendedores() throws Exception;
}