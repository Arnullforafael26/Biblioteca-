package com.ceiba.biblioteca.servicio;

import com.ceiba.biblioteca.dao.PrestamoDao;
import com.ceiba.biblioteca.dominio.excepcion.NuevaExcepcionNegocio;
import com.ceiba.biblioteca.dominio.prestamo.TipoUsuario;
import com.ceiba.biblioteca.dominio.prestamo.dto.Prestamo;
import com.ceiba.biblioteca.dominio.prestamo.PrestamoOperacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplServicePrestamo implements RepositorioPrestamo{

    public static final String ERROR_USUARIO_INVITADO_MAS_DE_UN_PRESTAMO = "El usuario con identificación %s ya tiene un " +
            "libro prestado por lo cual no se le puede realizar otro préstamo";
    public static final String ERROR_TIPO_USUARIO_NO_PERMITIDO = "Tipo de usuario no permitido en la biblioteca";

    @Autowired
    private PrestamoDao prestamoDao;         // se realiza la inyeccion de dependencia  a la interface PrestamoDao

    @Override
    public Prestamo registrarPrestamo(Prestamo prestamo) throws Exception {      // se realiza la implementacion del metodo  registrarprestamo

        PrestamoOperacion prestamoOperacion = new PrestamoOperacion();      // Se crea objeto prestamoOperacion  de tipo prestamoOperacion

        if (TipoUsuario.INVITADO.geValor() == prestamo.getTipoUsuario() && prestamoDao.existeByTipoUsuario(prestamo.getTipoUsuario())>0){ //
            throw NuevaExcepcionNegocio.NuevaExcepcionNegocio(String.format(ERROR_USUARIO_INVITADO_MAS_DE_UN_PRESTAMO,
                    prestamo.getIdentificacionUsuario())        // se crea la condicion que evalua  si un usuario  invitado  realiza mas de un pretamo, no puede  efectuar  otro
            );                                                  // hasta que  se haya cumplido la fecha limite del anterir
        }

        if (TipoUsuario.AFILIADO.geValor() == prestamo.getTipoUsuario()) {   // condicion  que evalua  si el valor  ingresado  pertenece a Afiliado
            prestamo.setFechaMaximaDevolucion(prestamoOperacion.calcularFechaMaximaParaAfiliado());
        } else if (TipoUsuario.EMPLEADO.geValor() == prestamo.getTipoUsuario()) {   // condicion  que evalua  si el valor  ingresado pertenece a Empleado
            prestamo.setFechaMaximaDevolucion(prestamoOperacion.calcularFechaMaximaParaEmpleado());
        } else if (TipoUsuario.INVITADO.geValor() == prestamo.getTipoUsuario()) {    // condicion  que evalua  si el valor de usuario  ingresado  pertenece a Empleado
            prestamo.setFechaMaximaDevolucion(prestamoOperacion.calcularFechaMaximaParaInvitado());
        } else {
            throw NuevaExcepcionNegocio.NuevaExcepcionNegocio(ERROR_TIPO_USUARIO_NO_PERMITIDO);    // excecion  si  el valor ingresado no pretenece a ningun usuario
        }

        return prestamoDao.save(prestamo);
    }

    @Override
    public Prestamo consultarPrestamo(Long id) {    // se realiza la implementacion del metodo  ConsultarPrestamo
        return prestamoDao.findById(id)
                .orElse(null);
    }

}
