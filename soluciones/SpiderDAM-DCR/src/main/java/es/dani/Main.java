package es.dani;

import Utils.Input;
import com.diogonunes.jcolor.Attribute;
import models.Sala;
import java.util.Scanner;
import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Main {
    public static void main(String[] args){
        System.out.println("\n"+colorize(" Bienvenido a Cines DAM ", BACK_COLOR(99), TEXT_COLOR(15), BOLD() )+ " ");
        menu();
        System.out.println("Gracias por su visita.");

    }

    public static void menu() {
        Input input = new Input();
        Sala sala = new Sala();
        int num=0;
        boolean continuar=true;
        do {
            System.out.println("\n¿Que quieres hacer?");
            System.out.println("1- Ver sala \n" +
                    "2- Comprar entrada \n"+
                    "3- Reservar \n"+
                    "4- Confirmar \n"+
                    "5- Anular \n"+
                    "6- Resumen \n"+
                    "0- Salir \n");
            do {
                num= input.readInt();
                if (num<0 || num > 6) System.out.println("Error en la introduccion de dato.");
            }while (num < 0 || num >6);
            switch(num){
                case 1: sala.verSala();
                    break;
                case 2: if (continuar())sala.comprarEntrada();
                    break;
                case 3: if (continuar())sala.reservarEntrada();
                    break;
                case 4: if (continuar())sala.confirmarReserva();
                    break;
                case 5: if (continuar())sala.anularEntrada();
                    break;
                case 6: sala.resumen();
                    break;
                case 0: continuar=false;
                    break;
            }
        }while (continuar);

    }
    public static boolean continuar(){
        boolean continuar=false;
        Scanner sc = new Scanner(System.in);
        String next;
        System.out.print("\n¿Quieres continuar?(y/n):\n-> ");
        next= sc.next().trim().toLowerCase();
        if (next.equals("y"))continuar= true;
        return continuar;
    }
}
