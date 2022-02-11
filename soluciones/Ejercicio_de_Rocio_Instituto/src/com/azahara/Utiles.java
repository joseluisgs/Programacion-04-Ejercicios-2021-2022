package com.azahara;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Utiles {
    /**
     * 50% entre 18 y 25
     * 30% entre 25 y 32
     * 20 % entre 32 y 40
     */
    public static int edadRandom() {
        int probabilidad= (int)(Math.random()*101);
        if (probabilidad<51){
            return 18 + ((int) (Math.random()*8));
        }else if (probabilidad<81){
            return 25 + ((int) (Math.random()*8));
        }else {
            return 32 + ((int) (Math.random()*8));
        }
    }

    public static String apellidoRandom() {
        ArrayList <String> listaApellidos = new ArrayList (Arrays.asList("Blanco", "Rodríguez",
                "Beltran", "Montes", "carmesiano", "Ayuso", "Camarena", "Palomares", "Pajares", "Botran"));

        return listaApellidos.get(((int)(Math.random()*10)));
    }

    public static String nombreAlumnoRandom() {
        ArrayList <String> listaApellidos = new ArrayList (Arrays.asList("Roberto", "Santiago",
                "Paco", "Naruto", "Dani", "Lorenzo", "Joam", "Mohamet", "kalimoka", "Jeremy", "Francisco",
                "Jose Luis", "Alberto", "Sebastian", "Juan", "Zayn", "Tanys", "Cid", "Ruben",
                "Samuel"));

        return listaApellidos.get(((int)(Math.random()*20)));
    }

    public static String nombreAlumnaRandom() {
        ArrayList<String> listaApellidos = new ArrayList (Arrays.asList("Azahara", "Rocio",
                "Gema", "Naiara", "Maria", "Beatriz", "Nerea", "Cristina", "Andrea", "Ana", "Rosa",
                "Pilar", "Esperanza", "Viztoria", "Eleanor", "Elisa", "Nieves", "Veronica", "Patricia",
                "Samuel"));

        return listaApellidos.get(((int)(Math.random()*20)));
    }

    public static int elegirNumero() {
        int numero= 0;
        boolean ok = false;
        Scanner sc = new Scanner(System.in);
        do {
            try{
                System.out.println("Elige un numero del clase del 1 al 10");
                numero = sc.nextInt();
                if (numero>0 && numero<11){
                    ok=true;
                }else {
                    System.out.println("no exixte el numero de clase que has elegido");
                }

            }catch (Exception e){
                sc.next();
                System.out.println("no exixte el numero de clase que has elegido");
            }

        }while(!ok);
        return numero;
    }
}
