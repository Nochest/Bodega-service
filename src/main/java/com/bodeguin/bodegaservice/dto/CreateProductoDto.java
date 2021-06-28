package com.bodeguin.bodegaservice.dto;


import com.example.bodeguinmicroinventario.entities.Categoria;
import lombok.Getter;

@Getter
public class CreateProductoDto{
        private String nombre;
        //private Integer precio;
        //private Integer stock;
        //private Categoria categoria;
        private Categoriadto categoria;
}
