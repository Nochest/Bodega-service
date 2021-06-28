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

import com.bodeguin.bodegaservice.dto.BodegaDto;
import com.bodeguin.bodegaservice.dto.CreateBodegaDto;
import com.bodeguin.bodegaservice.service.BodegaService;

@RestController
@RequestMapping(path = "/bodegas")
public class BodegaController {
	@Autowired
	private BodegaService bodegaService;
		
	@GetMapping("/{id}")
	public ResponseEntity<BodegaDto> getBodegaById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(bodegaService.getBodegaById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/")
    public ResponseEntity<List<BodegaDto>> getCategorias(){
        try {
			return new ResponseEntity<>(bodegaService.getBodegas(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	@PostMapping("/")
    public ResponseEntity<BodegaDto> createCategoria(@RequestBody CreateBodegaDto createBodegaDto){
        try {
			return new ResponseEntity<>(bodegaService.createBodega(createBodegaDto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
    }

}
