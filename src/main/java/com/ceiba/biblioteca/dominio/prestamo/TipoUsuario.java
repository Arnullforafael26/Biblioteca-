package com.ceiba.biblioteca.dominio.prestamo;

public enum TipoUsuario {

    AFILIADO(1),
    EMPLEADO(2),     // Se definen el valor de los tipos de usuario
    INVITADO(3);

    private int valor;

    TipoUsuario(int valor) {    // Constructor tipo usuario
        this.valor = valor;
    }

    public int geValor() {     // Metodo Get del  Atributo valor
        return valor;
    }

}
