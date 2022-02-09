package com.azahara;

import java.util.Scanner;

public class Utiles {

    /**
     *
     * @pide un entero positivo mayor que 0
     */
    public static int getPositiveInt(){
        int n = -1;
        boolean ok = false;
        do {
            try{
                Scanner sc = new Scanner(System.in);
                n=sc.nextInt();
                if (n>0){
                    ok=true;
                }
            }catch (Exception e){
                System.out.println("no es un entero correcto");
            }
        }while(!ok);
        return n;

    }

    /**
     *
     * @return pedimos un 12 o u 24
     */
    public static int pedirFormato() {


        int n = -1;
        boolean ok = false;
        do {
            try{
                System.out.println("Dime el formato...");
                Scanner sc = new Scanner(System.in);
                n=sc.nextInt();
                if (n==12 || n ==24 ){
                    ok=true;
                }
            }catch (Exception e){
                System.out.println("no formato correcto");
            }
        }while(!ok);
        return n;
    }

    /**
     *
     * @returnpedimos un entero entre 0 y 24
     */
    public static int pedirHoras() {
        int n = -1;
        boolean ok = false;
        do {
            try{
                System.out.println("Dime la hora...");
                Scanner sc = new Scanner(System.in);
                n=sc.nextInt();
                if (n>=0 && n<24){
                    ok=true;
                    System.out.println(" la hora es correcta");
                }else{
                    System.out.println(" la hora no correcta");
                }
            }catch (Exception e){
                System.out.println(" la hora no correcta");
            }
        }while(!ok);
        return n;
    }

    /**
     *
     * @param formato int de 12 o 24
     * @param hora  comprobamos si la hora esta en la franja correcta
     * @return un boleano true si es una hora correcta en cuanto a el formato
     */
    public static boolean comprobarHoraCorrecta(int formato, int hora) {
        if (formato==12) {
            if (hora < 12) {
                return true;
            }
        }
        if (formato==24){
            if (hora < 24) {
                return true;
            }

        }
            System.out.println("El formato no es correcto");
            return false;


    }

    /**
     *
     * @returndevuleve un bolean true si quieres salir
     */
    public static boolean preguntarSalir() {
        boolean ok = false;
        String n =" " ;
        do {
            try{
                System.out.println("¿¿quieres salir del programa??");
                Scanner sc = new Scanner(System.in);
                n=sc.nextLine();
                if (n.trim().equalsIgnoreCase("s") || n.trim().equalsIgnoreCase("n")){
                    ok=true;
                }
            }catch (Exception e){
                System.out.println("Opcion incorrecta : S/N");
            }
        }while(!ok);
        return n.equalsIgnoreCase("s");
    }

    public static int pedirMinutos() {
        int n = -1;
        boolean ok = false;
        do {
            try{
                System.out.println("Dime los minutos...");
                Scanner sc = new Scanner(System.in);
                n=sc.nextInt();
                if (n>=0 && n<60){
                    ok=true;
                    System.out.println(" los minutos  son correctos");
                }else {
                    System.out.println(" los minutos NO son correctos");
                }
            }catch (Exception e){
                System.out.println(" los minutos NO son correctos");
            }
        }while(!ok);
        return n;
    }

    public static int pedirSegundos() {
        int n = -1;
        boolean ok = false;
        do {
            try{
                System.out.println("Dime los segundos...");
                Scanner sc = new Scanner(System.in);
                n=sc.nextInt();
                if (n>=0 && n<60){
                    ok=true;
                    System.out.println(" los segundos son correctos");
                }else{
                    System.out.println(" los segundos NO son correctos");
                }
            }catch (Exception e){
                System.out.println(" los segundos NO son correctos");
            }
        }while(!ok);
        return n;
    }
}
