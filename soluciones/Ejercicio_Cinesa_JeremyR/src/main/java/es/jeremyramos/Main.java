package es.jeremyramos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sala pinesa = new Sala ();
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        int opcion=0;
        do {
            System.out.println("-----> Bienvenido a Pinesa <----------");
            System.out.println("¿Que desea hacer?: (1)Ver la sala  (2)Comprar Entrada  (3)Confirmar Reserva  (4)Anular Entrada  (5)Salir ");
            do {
                try {
                    opcion = sc.nextInt();
                    ok = true;
                } catch (Exception e) {
                    System.err.println("Introduce una opcion válida");
                    sc.next();
                }
            } while (!ok);


            switch (opcion) {

                case 1: {
                    pinesa.verSala();
                }break;

                case 2: {
                    pinesa.comprarEntrada();
                    pinesa.verSala();
                } break;
                case 3: {
                    pinesa.confirmarEntrada();
                    pinesa.verSala();
                }break;

                case 4: {
                    pinesa.anularEntrada();
                    pinesa.verSala();
                }break;

                case 5: {
                    break;
                }

            }

        }while (continuar());
        pinesa.resumenSala();
    }

    public static boolean continuar() {
        boolean continuar = false;
        Scanner sc = new Scanner(System.in);
            System.out.print("¿Quieres continuar?(y/n): ");
                String confirmar = sc.nextLine();
                    if (confirmar.equals("y")) {
                    continuar = true;
                    }

        return continuar;
    }
}
