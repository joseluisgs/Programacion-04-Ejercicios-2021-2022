package com.azahara;

import java.util.Scanner;

public  class Utiles {
    public static String pedirmazo() {
        Scanner sc = new Scanner(System.in);
        String elecion = sc.next();
        return elecion;
    }

    public static boolean preguntarSalir() {
        System.out.println("quieres salir S");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (s.equalsIgnoreCase(s)){
            return true;
        }else{
            return false;
        }
    }
}
