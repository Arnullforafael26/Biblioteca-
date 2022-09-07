package com.ceiba.biblioteca.dao;

import com.ceiba.biblioteca.dominio.prestamo.dto.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PrestamoDao extends CrudRepository<Prestamo, Long> {

    @Query(value = "SELECT count(id) from Pestamo where tipoUsuario = :tipoUsuario ")
    int existeByTipoUsuario(@Param("tipoUsuario") int tipoUsuario);      // Se crea un Metodo existeByTipoUsuario  que  consulta en la base de datos  a  travez de un Query nativo consulta
}                                                                        // en base de datos a traves de un iD si tipo usuario contiene algun valor.
