package com.ceiba.biblioteca.webcontroller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class RespuestaSolicitudPrestarLibro {
    private Long id;
    private String fechaMaximaDevolucion;
}


// clase que contiene los Atributos de la rerspueta  de la solicitud