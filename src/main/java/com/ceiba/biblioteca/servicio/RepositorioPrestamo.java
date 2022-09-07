package com.ceiba.biblioteca.servicio;

import com.ceiba.biblioteca.dominio.prestamo.dto.Prestamo;


public interface RepositorioPrestamo {

     Prestamo registrarPrestamo(Prestamo prestamo) throws Exception;  // se crea  el metodo registrar prestamo

     Prestamo consultarPrestamo(Long id); // se crea el metodo registrar prestamo



}
