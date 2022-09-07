package com.ceiba.biblioteca.dominio.prestamo.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data      // Anotacion de Sprintg boot que trae todos los datos de una clase
@Table      // esta anotación se utiliza para indicar la tabla contra la que mapea la entidad
@Entity(name = "Pestamo")       // sirve únicamente para indicarle a JPA que esa clase es una Entity
public class Prestamo {

    @Id      // Se identifica el id para la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // indicamos  a JPA que regla de autogeneración de la llave primaria vamos a utilizar
    private Long id;
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
    private String fechaMaximaDevolucion;
}
