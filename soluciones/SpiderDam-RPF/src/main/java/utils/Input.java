package utils;


import java.util.Scanner;


public class Input {
    private static final Scanner sc= new Scanner(System.in);
    private static int option=8;


    public static int getOption() {return option;}


    /**
     * Input para pedir la opción.
     * @return número de opción elegida.
     */
    public static int optionMenu(){
        do {
            try {
                System.out.println("\n" +
                        "Qué opción quieres?:" + "\n" +
                        ">1: Ver Sala " + "\n" +
                        ">2: Comprar entrada " + "\n" +
                        ">3: Reservar entrada " + "\n" +
                        ">4: Confirmar reserva " + "\n" +
                        ">5: Anular compra o reserva " + "\n" +
                        ">6: Anular ticket de compra " + "\n" +
                        ">7: Resumen " + "\n" +
                        ">8: Lista Tickets " + "\n" +
                        ">0: Salir " + "\n");
                option = sc.nextInt();
            }catch (Exception e){
                option = -1;
                sc.next();
            }
        }while(option<0 || option>8);
        sc.nextLine();   //Limpieza de scanner
        return option;
    }


    /**
     * Pedir ID del ticket.
     * @return el número de ticket.
     */
    public static int pedirIdTicket() {
        int ticket;
        do {
            try {
                System.out.println("Dime el id de ticket a anular:");
                ticket= sc.nextInt();
            }catch (Exception e){
                ticket= -1;
                sc.next();
            }
        }while (ticket<1);
        return ticket;
    }


    /**
     * Método para decir la fila.
     * @return número de fila o exit para salir de la opción.
     */
    public static int pedirFila() {
        String fila;
        int filaNumber;

        do {
            System.out.println("Dime que fila quieres: A,B,C,D,E");
            try {
                fila = sc.nextLine();
                fila= fila.toUpperCase().trim();
            } catch (Exception e) {
                fila = "G";
                sc.next();
            }
        } while (!fila.equals("A") && !fila.equals("B") && !fila.equals("C") &&
                !fila.equals("D") && !fila.equals("E") && !fila.equals("/EXIT"));

                if (!fila.equals("/EXIT")) {
                    filaNumber = numberOfFila(fila);
                }else{
                    filaNumber = 3617;}

        return filaNumber;
    }


    /**
     * Método para decir en que fila(numero) ha elegido la butaca.
     * @param fila fila en char.
     * @return el numero fila en el que está.
     */
    public static int numberOfFila(String fila){
        String[] letras= {"A","B","C","D","E"};
        int number = 0;

        for(int i=0; i<letras.length; i++){
            if (letras[i].equals(fila)){
                number = i;
            }
        }

        return number;
    }


    /**
     * Método para decir en que fila(char) ha elegido la butaca.
     * @param fila fila en numero.
     * @return el char de la fila en el que está.
     */
    public static char charOfFila(int fila){
        char[] letras= {'A','B','C','D','E'};
        return letras[fila];
    }


    /**
     * Método para pedir columna.
     * @return el número de columna elegido.
     */
    public static int pedirColumn() {
        int number;
        do {
            try {
                System.out.println("Dime que columna quieres: 1,2,3,4,5,6,7,8,9");
                number = sc.nextInt();
            }catch(Exception e){
                number = -1;
                sc.next();
            }
        }while(number<1 || number>9);
        number = number - 1;
        return number;
    }
}
