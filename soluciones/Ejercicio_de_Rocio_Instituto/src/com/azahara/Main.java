package com.azahara;

public class Main {
    /**
     * Ejercicio realizado por Rocio:
     *
     * Tenemos un instituto en el que hay 10 aulas, cada aula tendrá un total de 15 alumnos de los que se
     * deberá saber su nombre, apellido y edad para ello deberemos crearlos de manera aleatoria. OK
     *
     * Se tiene que realizar con ArrayList OK
     *
     * Dependiendo de un porcentaje serán 60% alumnas y 40% alumnos. OK
     *
     * Dependiendo de si es alumno o alumna Habrá 20 nombres y 10 apellidos para elegir, de chico
     * y de chica OK
     *
     * Para las edades serán: OK
     *
     * 50% entre 18 y 25
     * 30% entre 25 y 32
     * 20 % entre 32 y 40
     *
     *
     * Deberemos de mostrar al final un informe de todas las aulas con todos los alumnos,
     * cuantos chicos y chicas hay en cada aula y por último, deberemos elegir q aula queremos
     * ver y se nos mostrará los alumnos de ese aula ordenados de manera descendente por nombre //
     *
     * no se ordenar por nombre, así que ordenarépor edad y más adelante añadiré el nombre
     *
     */

    public static void main(String[] args) {

        //Crear Instituto
        Instituto i = new Instituto();

        //imprimir instituto
        System.out.println(i);

        //mostrar informe
        mostrarInforme(i);

        //mostrar los nombres del aula
        mostrarNombreAlumnos(i);
    }

    private static void mostrarNombreAlumnos( Instituto i) {
        System.out.println("Vamos a ordenar una clase y mostrarla por pantalla : ");

        //elegir clase
        Clase c = i.elegirClase();


        //ordenarla por edad
        c.ordenarClase();
        c.imprimirla();




    }

    private static void mostrarInforme( Instituto i) {
        //sexo de los alumnos
        i.sexoAlumnes();
    }


}
