package com.bodeguin.bodegaservice.dto;

import java.util.List;

import com.bodeguin.bodegaservice.entities.Bodega;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Esta clase representa los vendedores dueño de las bodegas")
public class VendedorDto {
	
	@ApiModelProperty(notes = "Id interno de un vendedor en la base de datos", example = "1")
	private Long id;
	
	@ApiModelProperty(notes = "Nombre del vendedor", example = "Jose")
	private String nombre;
	@ApiModelProperty(notes = "DNI con el que se identifica el vendedor", example = "12345667")
	private String dni;
	@ApiModelProperty(notes = "Lista de bodegas pertenecientes a un vendedor")
	private List<Bodega> bodegas;
}
