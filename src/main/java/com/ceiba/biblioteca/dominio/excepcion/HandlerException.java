package com.ceiba.biblioteca.dominio.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice

public class HandlerException {

@ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Error> RuntimeExceptionHandler(RuntimeException ex){

    Error error= Error.builder().mensaje(ex.getMessage()).build();
    return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

