package com.bodeguin.bodegaservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodeguin.bodegaservice.dto.CreateVendedorDto;
import com.bodeguin.bodegaservice.dto.VendedorDto;
import com.bodeguin.bodegaservice.entities.Vendedor;
import com.bodeguin.bodegaservice.service.VendedorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path ="/vendedores")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping("/{id}")
	 public ResponseEntity<VendedorDto> getVendedorById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(vendedorService.getVendedorById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	 }

	    @GetMapping("/")
	    public ResponseEntity<List<VendedorDto>> getVendedores(){
	        try {
				return new ResponseEntity<>(vendedorService.getVendedores(),HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }

	    @PostMapping("/")
	    public ResponseEntity<VendedorDto> createVendedor(@RequestBody CreateVendedorDto createVendedorDto){
	        try {
				return new ResponseEntity<>(vendedorService.createVendedor(createVendedorDto), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
	    }
}
