package es.ftoribio.dam.models;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);


    public static int getRow(){
        int numRow;
        do {
            try {
                System.out.println("Dime la fila 1-3: ");
                numRow = sc.nextInt();
            }catch (Exception e) {
                numRow = -1;
                System.out.println("Error, vuelve a intentarlo.");
            }
        }while (numRow <1 || numRow >3);
        return numRow-1;
    }



    public static int getCol(){
        int numCol;
        do {
            try {
                System.out.println("Dime que columna quieres 1-4: ");
                numCol = sc.nextInt();
            }catch (Exception e) {
                numCol = -1;
                System.out.println("Error, vuelve a intentarlo.");
            }
        }while (numCol <1 || numCol >4);
        return numCol-1;
    }


}
