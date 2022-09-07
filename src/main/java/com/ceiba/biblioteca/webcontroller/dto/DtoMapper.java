package com.ceiba.biblioteca.webcontroller.dto;

import com.ceiba.biblioteca.dominio.prestamo.dto.Prestamo;

public class DtoMapper {

    public static Prestamo crearPrestamo(SolicitudPrestarLibroDTO solicitudPrestarLibroDTO){   // Mapea la solicitud de crear un nuevo  prestamo
        Prestamo prestamo = new Prestamo(); // se crea un nuevo objeto  tipo prestamo con todos los atributos
        prestamo.setIsbn(solicitudPrestarLibroDTO.getIsbn());
        prestamo.setIdentificacionUsuario(solicitudPrestarLibroDTO.getIdentificacionUsuario());
        prestamo.setTipoUsuario(solicitudPrestarLibroDTO.getTipoUsuario());
        return prestamo;
    }

}
