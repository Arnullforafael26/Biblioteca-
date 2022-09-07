package com.ceiba.biblioteca.dominio.excepcion;


import lombok.Builder;
import lombok.Data;

@Data     // Anotacion de Sprintg boot que trae todos los datos de una clase
@Builder    // Anotacion utilizada para crear constructor  de atributos de la clase
public class Error {
    private String mensaje;

}
