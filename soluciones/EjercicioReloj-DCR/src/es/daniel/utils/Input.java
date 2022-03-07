package es.daniel.utils;

import java.util.Scanner;

public class Input {
    private static final Scanner sc= new Scanner(System.in);

    public static int readInt(){
        int number=-1;
        boolean ok;
        do {
            try {
                System.out.print("-> ");
                number= sc.nextInt();
                ok=true;

            }catch (Exception e) {
                ok=false;
                System.out.println("Error en la introducción de dato.");
                sc.next();
            }
        }while(!ok);
        return number;
    }
    public static String readString(){
        String cadena;
        do {
            System.out.print("-> ");
            cadena= sc.next().trim().toUpperCase();

        }while(cadena.length()<=0);
        return cadena;
    }
}
