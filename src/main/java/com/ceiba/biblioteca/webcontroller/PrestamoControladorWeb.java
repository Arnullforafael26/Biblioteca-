package com.ceiba.biblioteca.webcontroller;

import com.ceiba.biblioteca.servicio.ImplServicePrestamo;
import com.ceiba.biblioteca.webcontroller.dto.RespuestaSolicitudPrestarLibro;
import com.ceiba.biblioteca.webcontroller.dto.SolicitudPrestarLibroDTO;
import com.ceiba.biblioteca.dominio.prestamo.dto.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ceiba.biblioteca.webcontroller.dto.DtoMapper.crearPrestamo;

@RestController
@RequestMapping(value = "/prestamo", produces = MediaType.APPLICATION_JSON_VALUE)   // se mapea el link  donde se va a exponer el metodo post  prestamo y visualizamos esa respuesta en formato json
public class PrestamoControladorWeb {

    @Autowired
    private ImplServicePrestamo services; // inyeccion de dependencia  de  la clase ImplServicePrestamo

    @PostMapping
    public ResponseEntity<RespuestaSolicitudPrestarLibro> registrarPrestamo(@RequestBody SolicitudPrestarLibroDTO solicitudPrestarLibroDTO) throws Exception {    // Metodo para  Agregar un nuevo prestamo y que muestra la clase RespuestaSolicitudPrestarLibro
       Prestamo prestamo = services.registrarPrestamo(crearPrestamo(solicitudPrestarLibroDTO));    // se almacena  datos de prestamo en una variable tipo prestamo.
       RespuestaSolicitudPrestarLibro respuestaSolicitudPrestarLibro = new RespuestaSolicitudPrestarLibro(prestamo.getId(), prestamo.getFechaMaximaDevolucion());       // crea objeto de respuesta del metodo post
       return new ResponseEntity<RespuestaSolicitudPrestarLibro>(respuestaSolicitudPrestarLibro,HttpStatus.OK);       // le da formato a la respuesta http por medio de la anotacion ResponseEntity
    }

    @GetMapping("/{id-prestamo}")
    public ResponseEntity<Prestamo> consultarPrestamoPorId(@PathVariable("id-prestamo") Long idPrestamo){  //Metodo que recibe por medio de un paramtro (ID id-prestamo) y muestra la clase Prestamo
        Prestamo prestamo = services.consultarPrestamo(idPrestamo);  // se almacena  datos de prestamo en una variable tipo prestamo.
        return new ResponseEntity<Prestamo>(prestamo,HttpStatus.OK); //le da formato a la respuesta http por medio de la anotacion ResponseEntity
    }


}

