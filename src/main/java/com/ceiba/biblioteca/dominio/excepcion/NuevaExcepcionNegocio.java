package com.ceiba.biblioteca.dominio.excepcion;

public class NuevaExcepcionNegocio extends RuntimeException{
    public static Exception NuevaExcepcionNegocio(String mensaje){
        return new RuntimeException(mensaje);
    }
}
