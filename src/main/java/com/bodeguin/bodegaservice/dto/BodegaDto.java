package com.bodeguin.bodegaservice.dto;

import com.bodeguin.bodegaservice.entities.Vendedor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Esta clase representa a las bodegas que poseen listados de productos y un vendedor")
public class BodegaDto {
	
	@ApiModelProperty(notes = "Id interno de una bodega en la base de datos", example = "1")
	private Integer id;
	
	@ApiModelProperty(notes = "Nombre de la bodega", example = "Bodega del barrio")
	private String nombre;
	@ApiModelProperty(notes = "Pequeña descripción de la bodega", example = "Para toda la familia y amigos la bodega del barrio")
	private String descripcion;
	@ApiModelProperty(notes = "Direccion donde se encuentra la bodega", example = "Av. Los Pinos 123")
	private String direccion;
	@ApiModelProperty(notes = "RUC de la tienda/persona", example = "10123456781")
	private String ruc;
	@ApiModelProperty(notes = "Latitud para obtener la ubicacion de la bodega", example = "-12.004831227640935")
	private float latitud;
	@ApiModelProperty(notes = "Longitud para obtener la ubicacion de la bodega", example = "-77.11351759635114")
	private float longitud;	
	@ApiModelProperty(notes = "Vendedor al cual pertenece la bodega")
	private Vendedor vendedor;
}