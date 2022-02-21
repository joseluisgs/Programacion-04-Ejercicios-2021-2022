package utils;

import java.util.Scanner;

public class Input {
private static final Scanner scanner= new Scanner(System.in);


    /**
     * Pedir la velocidad máxima que va a tener como máximo.
     * @return la velocidad.
     */
    public static int pedirVelocidad(){
        int velocidad;
        do {
            try {
                System.out.println("Dime a que velocidad quieres llegar con el coche: ");
                velocidad = scanner.nextInt();
            }catch (NumberFormatException e) {
                System.out.println("Error de velocidad, debe ser siempre por lo menos igual a 1.");
                velocidad = -1;
                scanner.next();
            }
        }while (velocidad<1);
        return velocidad;
    }


    /**
     * Pedir cuanto tiempo se va a mantener en la velocidad máxima.
     * @return tiempo elegido.
     */
    public static int pedirTiempo(){
        int tiempo;
        do {
            try{
                System.out.println("Dime cuántos segundos quieres que se mantenga la velocidad escrita: ");
                tiempo = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Error de tiempo, debe ser siempre por lo menos igual a 1.");
                tiempo = -1;
                scanner.next();
            }
        }while (tiempo<1);
        return tiempo;
    }
}
