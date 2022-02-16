package main.java.es.ftoribio.dam;

import java.util.Scanner;

public class Cine {
    private final int fila;
    private final int columna;
    private final String[][] sala;
    private int butacaVendida;
    private int ingresoActual;
    private final int precio;

    public Cine(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        this.sala = new String[fila + 1][columna + 1];
        this.butacaVendida = 0;
        this.ingresoActual = 0;
        this.precio = 6;
    }

    public void llenarPorDefecto(){
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[0].length; j++) {
                if (i == 0 && j == 0) sala[i][j] = " ";
                else if (i == 0) sala[i][j] = String.valueOf(j) + "    ";
                else if (j == 0) sala[i][j] = String.valueOf(i);
                else sala[i][j] = "\033[42;30m[L😄]\033[0m ";
            }
        }
    }

    public void imprimirSala(){
        System.out.println("\nSala de cine: \n");
        for (String[]asientos : sala) {
            for (int j = 0; j < sala[0].length; j++) {
                System.out.print(asientos[j] + " ");
            }
            System.out.println("\n");
        }
    }

    public boolean verificarAsiento(int comprarFila, int comprarColumna) {
        boolean verificar = comprarFila > fila ||
                comprarColumna > columna ||
                comprarFila == 0 || comprarColumna == 0;
        if (verificar) {
            System.out.println("Entrada incorrecta");
            return false;
        }else if (sala[comprarFila][comprarColumna].equals("\033[41;30m[O😄]\033[0m ")) {
            System.out.println("Este asiento está ocupado");
            return false;
        }else if (sala[comprarFila][comprarColumna].equals("\033[43;30m[R😄]\033[0m ")) {
            System.out.println("Este asiento está reservado");
            return false;
        }else
        return true;
    }

    public boolean verificarAsientoReservado(int comprarFila, int comprarColumna) {
        boolean verificar = comprarFila > fila ||
                comprarColumna > columna ||
                comprarFila == 0 || comprarColumna == 0;
        if (verificar) {
            System.out.println("Entrada incorrecta");
            return false;
        }else if (sala[comprarFila][comprarColumna].equals("\033[41;30m[O😄]\033[0m ")) {
            System.out.println("Este asiento está ocupado");
            return false;
        }else
            return true;
    }

    public void comprarEntrada(int comprarFila, int comprarColumna) {
        int precio = 6;
        butacaVendida += 1;
        ingresoActual += precio;
        sala[comprarFila][comprarColumna] = "\033[41;30m[O😄]\033[0m ";
        System.out.println("\nEl precio de la entrada es " + precio + " Euros.");
    }

    public void reservarEntrada(int comprarFila, int comprarColumna) {
        sala[comprarFila][comprarColumna] = "\033[43;30m[R😄]\033[0m ";
    }

    public void anularReserva(int comprarFila, int comprarColumna) {
        sala[comprarFila][comprarColumna] = "\033[42;30m[L😄]\033[0m ";
    }

    public void reservarTicket() {
        Scanner scanner = new Scanner(System.in);
        boolean ok;
        int comprarFila = 10;
        int comprarColumna = 10;

        do {

            System.out.println("\nIntroduce un número de fila: ");
            try {
                comprarFila = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Introduce un entero");
                scanner.next();
            }

            System.out.println("\nIntroduce un número de columna: ");
            try {
                comprarColumna = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Introduce un entero");
                scanner.next();}
            ok = verificarAsiento(comprarFila,comprarColumna);

        } while (!ok);

        reservarEntrada(comprarFila,comprarColumna);
    }

    public void anularReservaTicket() {
        Scanner scanner = new Scanner(System.in);
        boolean ok;
        int comprarFila = 10;
        int comprarColumna = 10;

        do {


            System.out.println("\nIntroduce un número de fila: ");
            try {
                comprarFila = scanner.nextInt();
            }catch (Exception e) {
                System.out.println("Introduce un entero");
                scanner.next();
            }
            System.out.println("\nIntroduce un número de columna: ");
            try {
                comprarColumna = scanner.nextInt();
            }catch (Exception e) {
                System.out.println("Introduce un entero");
                scanner.next();
            }
            ok = verificarAsientoReservado(comprarFila,comprarColumna);
        } while (!ok);

        anularReserva(comprarFila,comprarColumna);

    }

    public void comprarTicket() {
        Scanner scanner = new Scanner(System.in);
        boolean ok;
        int comprarFila = 10;
        int comprarColumna = 10;

        do {


            System.out.println("\nIntroduce un número de fila: ");
            try {
                comprarFila = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Introduce un entero");
                scanner.next();
            }
            System.out.println("\nIntroduce un número de columna: ");
            try {
                comprarColumna = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Introduce un entero");
                scanner.next();}
            ok = verificarAsiento(comprarFila,comprarColumna);
        } while (!ok);

        comprarEntrada(comprarFila,comprarColumna);
    }

    public float porcentajeVentas() {
        int cantidadAsientos = fila * columna;
        return Math.round(((float) butacaVendida / (float) cantidadAsientos * 100f) * 100f) / 100f;
    }


    public void estadisticas() {
        ingresoActual = butacaVendida * precio;
        System.out.println("El número de asientos vendidos son: " + butacaVendida + "\n" +
                "El porcentaje de asientos vendidos es: " + porcentajeVentas() + " %\n" +
                "El total recaudado es: " + ingresoActual + " Euros.");
    }

    public void menu() {
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        String menu = "\n1. Ver asientos\n" +
                "2. Comprar entrada\n" +
                "3. Reservar entrada\n" +
                "4. Anular reserva\n" +
                "5. Estadísticas\n" +
                "0. Salir";

        do {
            System.out.println(menu);
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Introduce una opción valida (0-6)");
                scanner.next();
            }
            switch (opcion) {
                case 1:
                    imprimirSala();
                    break;
                case 2:
                    comprarTicket();
                    break;
                case 3:
                    reservarTicket();
                    break;
                case 4:
                    anularReservaTicket();
                    break;
                case 5:
                    estadisticas();
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;

            }
        } while (opcion != 0);

    }

}

