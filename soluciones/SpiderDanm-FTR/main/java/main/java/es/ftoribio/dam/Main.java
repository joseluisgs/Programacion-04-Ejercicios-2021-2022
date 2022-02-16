package main.java.es.ftoribio.dam;

import java.util.Date;

public class Main {

    static Cine cine;

    public static void main(String[] args) {


        System.out.println("\n");
        System.out.println("Se creará una sala de cine.");

        cine = new Cine(5,9);
        cine.llenarPorDefecto();
        cine.menu();



    }

}
