package com.azahara;

import static com.azahara.Utiles.nombreAlumnaRandom;
import static com.azahara.Utiles.nombreAlumnoRandom;

public class Alumno extends Persona implements Animal{
    private String nombre;
    private String sexo;

    @Override
    public void orina() {
        System.out.println("si voy a l baño meo de pie");
    }

    public String getSexo() {
        return sexo;
    }

    public Alumno(){
        super();
        this.nombre = nombreAlumnoRandom();
        this.sexo="Hombre";
    }

    @Override
    public String toString() {
        return "Alumno{ edad ='" + edad + "' " +"apellido ='" + apellido + "' " +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
        //todo imprimir la superclase del objeto
         //String super1 = super.toString();
    }
}
