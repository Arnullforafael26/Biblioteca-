package com.ceiba.biblioteca.prestamo;


import com.ceiba.biblioteca.dao.PrestamoDao;
import com.ceiba.biblioteca.dominio.prestamo.dto.Prestamo;
import com.ceiba.biblioteca.servicio.ImplServicePrestamo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
 public class ImplServicePrestamoTest {

    @InjectMocks
    ImplServicePrestamo implServicePrestamo;

    @Mock
    PrestamoDao prestamoDao;

    @Test
    public void registrarPrestamoTipoUsuarioAfiliadoExitosoTest() throws Exception {
        Prestamo prestamo = new Prestamo();
        prestamo.setIsbn("123");
        prestamo.setTipoUsuario(1);
        prestamo.setIdentificacionUsuario("123");

        Prestamo prestamoResponse = new Prestamo();
        prestamoResponse.setId(1l);
        prestamoResponse.setIsbn("123");
        prestamoResponse.setTipoUsuario(1);
        prestamoResponse.setIdentificacionUsuario("123");
        prestamoResponse.setFechaMaximaDevolucion("18/08/2022");

        when(prestamoDao.save(any())).thenReturn(prestamoResponse);
        PrestamoDao prestamoDao = Mockito.mock(PrestamoDao.class);

        Prestamo prestamoNew = implServicePrestamo.registrarPrestamo(prestamo);
        Assertions.assertNotNull(prestamoNew.getId());
        Assertions.assertNotNull(prestamoNew.getFechaMaximaDevolucion());
    }

    @Test
    public void registrarPrestamoTipoUsuarioEmpleadoExitosoTest() throws Exception {
        Prestamo prestamo = new Prestamo();
        prestamo.setIsbn("123");
        prestamo.setTipoUsuario(2);
        prestamo.setIdentificacionUsuario("123");

        Prestamo prestamoResponse = new Prestamo();
        prestamoResponse.setId(1l);
        prestamoResponse.setIsbn("123");
        prestamoResponse.setTipoUsuario(2);
        prestamoResponse.setIdentificacionUsuario("123");
        prestamoResponse.setFechaMaximaDevolucion("18/08/2022");

       when(prestamoDao.save(any())).thenReturn(prestamoResponse);

        Prestamo prestamoNew = implServicePrestamo.registrarPrestamo(prestamo);

        Assertions.assertNotNull(prestamoNew.getId());
        Assertions.assertNotNull(prestamoNew.getFechaMaximaDevolucion());
    }


    @Test
    public void registrarPrestamoTipoUsuarioInvitadoExitosoTest() throws Exception {
        Prestamo prestamo = new Prestamo();
        prestamo.setIsbn("123");
        prestamo.setTipoUsuario(3);
        prestamo.setIdentificacionUsuario("123");

        Prestamo prestamoResponse = new Prestamo();
        prestamoResponse.setId(1l);
        prestamoResponse.setIsbn("123");
        prestamoResponse.setTipoUsuario(3);
        prestamoResponse.setIdentificacionUsuario("123");
        prestamoResponse.setFechaMaximaDevolucion("18/08/2022");

       when(prestamoDao.save(any())).thenReturn(prestamoResponse);

        Prestamo prestamoNew = implServicePrestamo.registrarPrestamo(prestamo);

        Assertions.assertNotNull(prestamoNew.getId());
        Assertions.assertNotNull(prestamoNew.getFechaMaximaDevolucion());
    }


    @Test(expected = RuntimeException.class)
    public void registrarPrestamoTipoUsuarioInvitadoExistenteErrorTest() throws Exception {

        Prestamo prestamoRespondeInvitado = new Prestamo();
        prestamoRespondeInvitado.setIsbn("123");
        prestamoRespondeInvitado.setTipoUsuario(3);
        prestamoRespondeInvitado.setIdentificacionUsuario("123");

        when(prestamoDao.existeByTipoUsuario(anyInt())).thenReturn(1);
        implServicePrestamo.registrarPrestamo(prestamoRespondeInvitado);

    }

    @Test(expected = RuntimeException.class)
    public void registrarPrestamoTipoUsuarioNovalidoExitosoTest() throws Exception {
        Prestamo prestamo = new Prestamo();
        prestamo.setIsbn("123");
        prestamo.setTipoUsuario(4);
        prestamo.setIdentificacionUsuario("123");
       implServicePrestamo.registrarPrestamo(prestamo);
    }


}
