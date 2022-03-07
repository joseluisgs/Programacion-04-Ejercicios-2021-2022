package creators;

import models.Butaca;
import models.Estado;
import utils.Colors;
import utils.Inputs;

import java.util.Scanner;

public class ControlarEntrada {
    public Butaca createButacaLibre(int fila, int columna) {
        Butaca butaca = new Butaca(fila,columna);
        butaca.setEstado(Estado.LIBRE);
        return butaca;
    }
    public Butaca createButacaReservada(int fila, int columna) {
        Butaca butaca = new Butaca(fila,columna);
        butaca.setEstado(Estado.RESERVADA);
        return butaca;
    }
    public Butaca createButacaOcupada(int fila, int columna) {
        Butaca butaca = new Butaca(fila,columna);
        butaca.setEstado(Estado.OCUPADA);
        return butaca;
    }

    public int leerColumna() {
        Inputs input = new Inputs();
        int columna;
        boolean ok = false;
        do {
            System.out.println(Colors.BLUE+ "Introduzca la columna de butaca que desea. " + Colors.RESET);
            columna = input.readInt();
            if (columna < 1 || columna > 9) {
                System.out.println(Colors.BLUE+ "La columna debe estar entre 1 y 9" + Colors.RESET);
            } else {
                ok = true;
            }
        } while (!ok);
        return columna;
    }

    public int leerEntrada() {
        Inputs input = new Inputs();
        int entrada;
        boolean ok = false;
        do {
            System.out.println(Colors.BLUE+ "Pulse su opción: " + Colors.RESET);
            entrada = input.readInt();
            if (entrada < 1 || entrada > 8) {
                System.out.println(Colors.RED + "No ha elegido ninguna de las opciones disponibles en el menú." + Colors.RESET);
            } else {
                ok = true;
            }
        } while (!ok);
        return entrada;
    }

    public int leerFila() {
        Inputs input = new Inputs();
        String letra;
        int fila;
        boolean ok = false;
        do {
            System.out.println(Colors.BLUE + "Introduzca la fila de butaca que desea. "+ Colors.RESET);
            letra = input.readLine();
            fila = reasignarFila(letra);
            if (fila == -1) {
                System.out.println( Colors.RED_BOLD_BRIGHT + "Las filas van de la A a la E." + Colors.RESET);
            } else {
                ok = true;
            }
        } while (!ok);
        return fila;
    }

    public int reasignarFila(String letra){
        int fila;
        if(letra.equalsIgnoreCase("A")){
            fila = 0;
        }else if(letra.equalsIgnoreCase("B")){
            fila = 1;
        }else if(letra.equalsIgnoreCase("C")){
            fila = 2;
        }else if(letra.equalsIgnoreCase("D")){
            fila = 3;
        }else if(letra.equalsIgnoreCase("E")){
            fila = 4;
        }else{
            fila = -1;
        }
        return fila;
    }

    public char reasignarFila(int numero){
        char letra;
        if(numero == 0){
            letra = 'A';
        }else if(numero == 1){
            letra = 'B';
        }else if(numero == 2){
            letra = 'C';
        }else if(numero == 3){
            letra = 'D';
        }else if(numero == 4){
            letra = 'E';
        }else{
            letra = '-';
        }
        return letra;
    }
}
