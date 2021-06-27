package com.bodeguin.bodegaservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodeguin.bodegaservice.converters.VendedorDtoToEntity;
import com.bodeguin.bodegaservice.converters.VendedorEntityToDto;
import com.bodeguin.bodegaservice.dto.VendedorDto;
import com.bodeguin.bodegaservice.entities.Vendedor;
import com.bodeguin.bodegaservice.service.VendedorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@ApiOperation(value = "Endpoint que devuelve la lista de vendedores")
    @GetMapping(value = "/")
	public ResponseEntity<List<Vendedor>> findAll() {
		ResponseEntity<List<Vendedor>> response;
		try {
			List<Vendedor> vendedores = vendedorService.findAll();
			response = new ResponseEntity<>(vendedores, HttpStatus.OK);
			return response;
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}
}
