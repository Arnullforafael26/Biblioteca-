package com.ceiba.biblioteca.webcontroller.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class SolicitudPrestarLibroDTO {
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
}


// clase que contiene  valores  de los  atributos  al momento  de realizar una solicitud de un nuevo prestamo de libro