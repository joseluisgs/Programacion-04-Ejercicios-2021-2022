package utils;
import models.Sala;

import java.time.Instant;

public class ControlarMenu {
    public void imprimirMenu(){
        System.out.println(Colors.BLUE_BOLD_BRIGHT +  "MENÚ:" + Colors.RESET+ "\n"
                + Colors.BLUE + " 1." + Colors.CYAN_BOLD_BRIGHT +" Ver sala \n"
                + Colors.BLUE + " 2." + Colors.CYAN_BOLD_BRIGHT + " Comprar \n"
                +  Colors.BLUE + " 3." + Colors.CYAN_BOLD_BRIGHT + " Reservar \n"
                + Colors.BLUE + " 4." + Colors.CYAN_BOLD_BRIGHT + " Confirmar \n"
                + Colors.BLUE + " 5."+ Colors.CYAN_BOLD_BRIGHT + " Anular \n"
                + Colors.BLUE + " 6." + Colors.CYAN_BOLD_BRIGHT +  " Resumen \n"
                + Colors.BLUE + " 7."+ Colors.CYAN_BOLD_BRIGHT + " Salir \n"
                //+ Colors.BLUE + " 8."+ Colors.CYAN_BOLD_BRIGHT + " Búsquedas \n \n"

        );

    }
    public boolean controlarEntradas(int input, boolean salir, Sala sala){
        switch(input){
            case 1:
                sala.grafico();
                break;
            case 2:
                sala.compra();
                break;
            case 3:
                sala.reserva();
                break;
            case 4:
                sala.confirmar();
                break;
            case 5:
                sala.anular();
                break;
            case 6:
                sala.resumen();
                System.out.println(sala.leerFactura());
                sala.ordenarAntiguoAReciente();
                break;
            case 7:
                salir = true;
                System.out.println(Colors.BLUE_BOLD_BRIGHT + "¡¡ Hasta pronto !!" + Colors.RESET);
                break;
            case 8:
                System.out.println(sala.buscarPorButaca(1,1));
                System.out.println(sala.buscarPorFecha(Instant.now()));
                break;
            default:
                System.out.println(Colors.RED + "No ha elegido ninguna de las opciones disponibles en el menú." + Colors.RESET);
                break;
        }
        return salir;
    }
}
