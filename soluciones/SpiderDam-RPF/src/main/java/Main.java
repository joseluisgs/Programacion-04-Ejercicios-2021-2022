import Models.Sala;
import utils.Input;

import java.util.Scanner;

/**
 * @author Rocio Palao
 * @version 1.5
 * github: Rochiio
 */

public class Main {

    public static void main(String[] args) {
        if (args[0].equals("-precio")) {

                int precio = argsOkey(args);

                int opcion = 10;

                //Creación de la sala
                Sala sala;
                sala = Sala.getInstance(precio);

                    //Menu
                    while (opcion != 0) {
                        sala.switchOptionMenu(Input.optionMenu());
                        opcion = Input.getOption();
                    }
        }else{
            System.out.println("Argumento incorrecto");
        }
    }


    /**
     * Filtro de args para pedir el precio.
     * @param args el argumento que contiene el precio.
     * @return el precio después de pasar varios filtros.
     */
    private static int argsOkey(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        //Primer filtro
            try {
                num = Integer.parseInt(args[1]);
            }catch (Exception e) {
                num =0;
                System.out.println("Precio incorrecto");
            }
         //Segundo filtro
            while (num <=0){
                try {
                    System.out.println("Repita el precio");
                    num = scanner.nextInt();
                }catch (Exception e) {
                    num = 0;
                    scanner.next();
                }
            }
        return num;
    }

}
