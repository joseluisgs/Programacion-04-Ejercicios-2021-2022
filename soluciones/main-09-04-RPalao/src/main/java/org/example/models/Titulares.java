package org.example.models;

import utils.Input;

public class Titulares {
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final String telefono;

    public Titulares() {
        dni = Input.pedirDni();
        nombre = Input.pedirNombre();
        apellido = Input.pedirApellido();
        telefono = Input.pedirTelefono();
    }


    //Getter.
    public String getNombre() {
        return nombre;
    }


    @Override
    public String toString() {
        return "Titular{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
