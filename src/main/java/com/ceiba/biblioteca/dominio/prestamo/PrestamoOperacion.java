package com.ceiba.biblioteca.dominio.prestamo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrestamoOperacion {

    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String WEDNESDAY = "WEDNESDAY";                    // Se definen los atributos de los dias como  staticos
    public static final String FRIDAY = "FRIDAY";
    public static final String FORMATO_DD_MM_YYYY = "dd/MM/yyyy";



    public String calcularFechaMaximaParaAfiliado() {
        LocalDateTime fechaActual = LocalDateTime.now();                       // Metodos que realizan la operacion  de calcular  fecha maxima de entrega  de un prestamo cuando el
        if (fechaActual.getDayOfWeek().toString().equals(MONDAY)) {            //   usuario es Afiliado
            fechaActual = fechaActual.plusDays(12);
        } else {
            fechaActual = fechaActual.plusDays(14);
        }
        return obtenerNuevoFormatoFecha(fechaActual);

    }

    public String calcularFechaMaximaParaEmpleado() {
        LocalDateTime fechaActual = LocalDateTime.now();                  // Metodos que realizan la operacion  de calcular  fecha maxima de entrega  de un prestamo cuando el
        if (fechaActual.getDayOfWeek().toString().equals(MONDAY) ||       //   usuario es Empleado
                fechaActual.getDayOfWeek().toString().equals(TUESDAY) ||
                fechaActual.getDayOfWeek().toString().equals(WEDNESDAY)) {
            fechaActual = fechaActual.plusDays(10);
        } else {
            fechaActual = fechaActual.plusDays(12);
        }

        return obtenerNuevoFormatoFecha(fechaActual);
    }

    public String calcularFechaMaximaParaInvitado() {
        LocalDateTime fechaActual = LocalDateTime.now();                         // Metodos que realizan la operacion  de calcular  fecha maxima de entrega  de un prestamo cuando el
        if (fechaActual.getDayOfWeek().toString().equals(FRIDAY)) {              //   usuario es Invitado
            fechaActual = fechaActual.plusDays(11);
        } else {
            fechaActual = fechaActual.plusDays(9);
        }
        return obtenerNuevoFormatoFecha(fechaActual);
    }

    public String obtenerNuevoFormatoFecha(LocalDateTime fechaActual) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(FORMATO_DD_MM_YYYY);   // preguntar a juan camilo
        return fechaActual.format(fmt);
    }
}
