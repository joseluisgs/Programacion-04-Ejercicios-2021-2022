package com.azahara;

import static com.azahara.Utiles.*;

public class Alumna extends Persona implements Animal {

    private String nombre;
    private String sexo ="Mujer";

    @Override
    public void orina() {
        System.out.println("si voy a l baño meo de sentada");
    }

    @Override
    public String toString() {
        return "Alumna{" +
                " Edad = "+ edad +
                " apellido = "+apellido+
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                '}' ;

    }

    public Alumna(){
        super();
        this.nombre=nombreAlumnaRandom();
        this.sexo="Mujer";
    }


}
