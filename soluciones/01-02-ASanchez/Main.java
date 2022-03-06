package Fraccion;

import Fraccion.models.Relacional;

public class Main {
    public static void main(String[] args) {
        Relacional r1 = new Relacional();

        r1.setNumerador(3);
        r1.setDenominador(4);
        System.out.println(r1);

        System.out.println();

        Relacional r2 = new Relacional(5, 4);
        System.out.println(r2);
        System.out.println("-- SUMAR --");
        System.out.println(r1.sumar(r2));

        System.out.println();

        System.out.println("-- MULTIPLICAR --");
        System.out.println(r1.multiplicar(r2));
    }
}
