package com.bodeguin.bodegaservice.dto;

import lombok.Getter;

@Getter
public class CreateInventariodto {
    private Integer stock;
    private Integer precio;
    private String bodegaid;
    private ProducDto productoid;
}
