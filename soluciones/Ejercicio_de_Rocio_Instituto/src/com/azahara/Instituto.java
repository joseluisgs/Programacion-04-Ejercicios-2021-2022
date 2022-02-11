package com.azahara;

import java.util.ArrayList;

public class Instituto {


    private  static ArrayList<Clase> clases;

    public Instituto() {
        this.clases = new ArrayList<Clase>();
        for (int i = 0; i < 10; i++) {
            clases.add(new Clase());
        }
    }

    @Override
    public String toString() {
        return "Instituto{" +
                "clases=" + clases +
                '}';
    }

    static void sexoAlumnes() {
        int alumnos = 0;
        int alumnas = 0;
        int alumnes;

        for (int j = 0; j < 10; j++) {
           int alumnosClase = (clases.get(j).obtenerAlumnos());
           int alumnasClase = (clases.get(j).obtenerAlumnas());
           int alumnesClase = alumnasClase+alumnosClase;

            System.out.println("Los alumnos de la clase  "+ (j+1) +" son :"+ alumnesClase);
            System.out.println("Los alumnos: "+ alumnosClase);
            System.out.println("Las alumnas: "+ alumnasClase);
            alumnas = alumnasClase+alumnas;
            alumnos = alumnosClase+alumnos;

        }
        alumnes = alumnas+alumnos;
        System.out.println("el total de alumn@s del Istituto es :"+ alumnes);
        System.out.println("el total de alumnos del Istituto es :"+ alumnos);
        System.out.println("el total de alumnas del Istituto es :"+ alumnas);

    }

    public void ordenAlumnes() {
    }

    public Clase elegirClase() {
        //elegir numero
        int numero = Utiles.elegirNumero();
        return clases.get(numero-1);
    }
}

