package models;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Pedir fila.
     * @return número de fila elegida.
     */
    public static int pedirFila(){
        int numFila;
        do {
            try {
                System.out.println("Dime que fila quieres 1-3: ");
                numFila = sc.nextInt();
            }catch (Exception e) {
                numFila = -1;
                System.out.println("Error, vuelva a intentarlo.");
            }
        }while (numFila <1 || numFila >3);
        return numFila-1;
    }


    /**
     * Pedir columna.
     * @return número de columna elegida.
     */
    public static int pedirCol(){
        int numCol;
        do {
            try {
                System.out.println("Dime que columna quieres 1-4: ");
                numCol = sc.nextInt();
            }catch (Exception e) {
                numCol = -1;
                System.out.println("Error, vuelva a intentarlo.");
            }
        }while (numCol <1 || numCol >4);
        return numCol-1;
    }


}
