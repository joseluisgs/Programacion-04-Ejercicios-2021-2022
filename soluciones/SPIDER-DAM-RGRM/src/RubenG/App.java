package RubenG;

import RubenG.models.Cine;
import RubenG.utils.Input;

/**
 * Cine donde puedes reservar, comprar y anular entradas. Además podrás ver los
 * tickets que se han comprado y un resumen del cine.
 *
 * @author: Rubén Garcia-Redondo Marín
 * @version 1.0
 */



public class App {
    public static void main(String[] args) {
        Cine cine = new Cine();
        boolean exit= false;
        Input sc = new Input();
        System.out.println("Bienvenido a CineDAM");
        do {
            boolean ok = false;
            exit = main(cine, exit, sc, ok);
        }while(!exit);
    }

    private static boolean main(Cine cine, boolean exit, Input sc, boolean ok) {
        int option;
        do {
            System.out.println("Elija una de estas opciones: \n" +
                    "1. Ver Sala \n" +
                    "2. Comprar entradas \n" +
                    "3. Reservar entradas \n" +
                    "4. Confirmar reserva \n" +
                    "5. Anular entrada/reserva \n" +
                    "6. Resumen \n" +
                    "7. Tickets \n" +
                    "0. Salir");
            option = sc.readInt();
            if(option >= 0 && option <= 7) {
                ok = true;
            }
        }while (!ok);

        switch (option) {
            case 0:
                exit = true; break;
            case 1:
                cine.imprimirSala(cine.getSala()); break;
            case 2:
                cine.comprarEntradas(); break;
            case 3:
                cine.reservarEntradas(); break;
            case 4:
                cine.confirmarReserva(); break;
            case 5:
                cine.anularReserva(); break;
            case 6:
                cine.resumen(); break;
            case 7:
                cine.imprimirTicket(); break;
        }
        return exit;
    }
}
