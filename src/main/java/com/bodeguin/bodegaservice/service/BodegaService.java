package com.bodeguin.bodegaservice.service;

import java.util.List;

import com.bodeguin.bodegaservice.dto.BodegaDto;
import com.bodeguin.bodegaservice.dto.CreateBodegaDto;

public interface BodegaService {
	BodegaDto getBodegaById(Long id) throws Exception;
	BodegaDto createBodega(CreateBodegaDto createBodegaDto) throws Exception;
	List<BodegaDto> getBodegas() throws Exception;
}