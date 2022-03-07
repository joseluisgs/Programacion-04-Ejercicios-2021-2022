package es.jeremyramos;

import es.jeremyramos.utils.Colors;

import java.util.Locale;
import java.util.Scanner;

public class Sala {
    private int recaudacion;
    private final int precio= 6;
    private Butaca[][] pinesa = new Butaca[5][9];
    private int libres;
    private int ocupadas;
    private int reservadas;


    public Sala() {
        crearSala();
        this.recaudacion=0;
    }

    public Sala(int recaudacion, int libres, int ocupadas, int reservadas) {
        this.recaudacion = recaudacion;
        this.pinesa = new Butaca[5][9];
        this.libres = libres;
        this.ocupadas = ocupadas;
        this.reservadas = reservadas;
    }

    public int getLibres() {
        return libres;
    }

    public void setLibres(int libres) {
        this.libres = libres;
    }

    public int getOcupadas() {
        return ocupadas;
    }

    public void setOcupadas(int ocupadas) {
        this.ocupadas = ocupadas;
    }

    public int getReservadas() {
        return reservadas;
    }

    public void setReservadas(int reservadas) {
        this.reservadas = reservadas;
    }

    public int getRecaudacion() {
        return recaudacion;
    }


    public void crearSala() {

        for (int i = 0; i < pinesa.length; i++) {
            for (int j = 0; j < pinesa[i].length ; j++) {
                pinesa[i][j] = new Butaca();
            }
        }
    }

    public void verSala() {
        char var=65;
        System.out.println( Colors.YELLOW +  "     ---------> Bienvenido a " + Colors.BLACK + Colors.YELLOW_BACKGROUND + Colors.BLACK_UNDERLINED +  "  Pinesa  " + Colors.YELLOW + Colors.reset + Colors.YELLOW  +  " <-----------" + Colors.reset );
        System.out.println(Colors.RED + "              -----> SPIDER-DAM <------" + Colors.reset);
        System.out.println();
        System.out.println("     1     2    3     4     5    6     7     8     9 " + "");
        System.out.println("     ―    ―    ―    ―    ―    ―    ―    ―    ― ");
        System.out.println();

        for (int i = 0; i < pinesa.length; i++) {
            System.out.print(var++ + " |");
            for (int j = 0; j < pinesa[i].length; j++) {
                System.out.print(pinesa[i][j] + Colors.reset);
            }
            System.out.println("|" + "\n");
        }
        System.out.println("     ―    ―    ―    ―    ―    ―    ―    ―    ― ");
        System.out.println( Colors.GREEN + "             -----> PANTALLA GRANDE <------" + Colors.reset);

        System.out.println();

        System.out.println("Códigos de colores: " + "\n" +  "Libres:  " +  Colors.GREEN_BACKGROUND + "[✅]" + Colors.reset +
                "\n" + "Ocupadas: "+ Colors.RED_BACKGROUND + "[❌]" + Colors.reset + "\n" + "Reservadas: " + Colors.WHITE_BACKGROUND +
                Colors.YELLOW +"[✋\uD83C\uDFFB]" + Colors.reset);

    }

    public void comprarEntrada() {
        this.verSala();
        String opcion;
        boolean ok = false;
        System.out.println("Dime la butaca que quieres comprar: ");
        opcion = longitudValida();
        do {
            if (comprobarFila(opcion) && isLibre(opcion) && comprbarColumna(opcion)) {
                cambiarEstadoButaca(opcion, Enum.OCUPADO);
                recaudacion= recaudacion + precio;
                ok = true;
            } else {
                System.out.println("No se puede comprar esa butaca lo sentimos"
                + "\n" + "Introduce una nueva butaca");
                opcion = longitudValida();

            }
        } while (!ok);
    }

    public void confirmarEntrada() {
        this.verSala();
        String opcion;
        boolean ok = false;
        System.out.println("Dime de que sitio quieres confirmar la compra: ");
        opcion = longitudValida();
        do {
            if (comprobarFila(opcion) && isReservada(opcion) && comprbarColumna(opcion) ) {
                cambiarEstadoButaca(opcion, Enum.OCUPADO);
                recaudacion= recaudacion + precio;
                ok = true;
            } else {
                System.out.println("No se puede confirmar la compra de esta butaca lo sentimos"
                        + "\n" + "Introduce una nueva butaca");
                opcion = longitudValida();

            }
        } while (!ok);
    }


    public void anularEntrada() {
        this.verSala();
        String opcion;
        boolean ok = false;
        System.out.println("Dime de que sitio quieres anular la compra: ");
        opcion = longitudValida();
        do {
            if (comprobarFila(opcion) && isReservada(opcion) && comprbarColumna(opcion) || isLibre(opcion)  ) {
                cambiarEstadoButaca(opcion, Enum.LIBRE);
                recaudacion = recaudacion - precio;
                ok = true;
            } else {
                System.out.println("No se puede anular esta reserva lo sentimos"
                        + "\n" + "Introduce una nueva butaca");
                opcion = longitudValida();

            }
        } while (!ok);
    }


    public void cambiarEstadoButaca(String butaca, Enum estado) {
        int fila = this.sacarFila(butaca);
        int column = this.sacarColumna(butaca);
        this.pinesa[fila][column].setEstado(estado);
    }

    public boolean isLibre(String butaca) {
        boolean ok = false;
        int fila = this.sacarFila(butaca);
        int column = this.sacarColumna(butaca);
        if (this.pinesa[fila][column].getEstado() == Enum.LIBRE) {
            ok = true;
        }

        return ok;
    }

    public boolean isReservada(String butaca) {
        boolean ok = false;
        int fila = this.sacarFila(butaca);
        int column = this.sacarColumna(butaca);
        if (this.pinesa[fila][column].getEstado() == Enum.RESERVADO) {
            ok = true;
        }

        return ok;
    }

    public int sacarColumna(String opcion) {
        int pos = 8;
        if (opcion.charAt(1) == '1'){
            pos=0;
        }else if (opcion.charAt(1) == '2'){
            pos=1;
        }else if(opcion.charAt(1)== '3'){
            pos=2;
        }else if(opcion.charAt(1)== '4'){
            pos = 3;
        }else if (opcion.charAt(1)== '5') {
            pos = 4;
        }else if (opcion.charAt(1)== '6'){
            pos = 5;
        }else if (opcion.charAt(1)== '7'){
            pos = 6;
        }else if (opcion.charAt(1)== '8') {
            pos = 7;
        }
        return pos;
    }

    public int sacarFila(String opcion) {
        int pos;
        if (opcion.charAt(0) == 'A'){
            pos=0;
            }else if (opcion.charAt(0) == 'B'){
            pos=1;
            }else if(opcion.charAt(0)== 'C'){
            pos=2;
            }else if(opcion.charAt(0)== 'D'){
            pos = 3;
            }else
                pos = 4;

        return pos;
    }



    public boolean comprobarFila(String opcion) {
        boolean ok = false;
        String filasValidas = "ABCDE";
        do {

            if (filasValidas.contains(opcion.substring(0,1))){
                ok = true;

            } else {
                System.err.println("Fila Erronea intente de nuevo");
                opcion = longitudValida();
            }
        } while (!ok);

        return ok;
    }

    public boolean comprbarColumna(String opcion) {
        boolean ok = false;
        String columnasValidas= "123456789";
        do {
            if (columnasValidas.contains(opcion.substring(1,2))){
                ok = true;

            } else {
                System.err.println("Columna Erronea intente de nuevo");
                opcion = longitudValida();
            }
        } while (!ok);

        return ok;
    }

    private String longitudValida() {
        Scanner sc = new Scanner(System.in);
        String opcion;
        boolean ok = false;
        do {
            opcion = sc.nextLine();
            if (opcion.length() == 2 ) {
                ok = true;
            } else {
                System.out.println("Introduce una butaca válida");
            }
        }while(!ok);

        return opcion;
    }


    public void resumenSala(){
        this.verSala();
        for (int i = 0; i < pinesa.length; i++) {
            for (int j = 0; j < pinesa[i].length; j++) {
                if(pinesa[i][j].getEstado() == Enum.OCUPADO){
                    recaudacion = recaudacion + precio;
                    ocupadas++;
                }else if (pinesa[i][j].getEstado()== Enum.RESERVADO){
                    reservadas++;
                }else if (pinesa[i][j].getEstado()== Enum.LIBRE){
                    libres++;

                }
            }
        }
        System.out.println("Nº de butacas LIBRES: " + libres);
        System.out.println("Nº de butacas OCUPADAS: " + ocupadas);
        System.out.println("Nº de butacas RESERVADAS: " + reservadas);
        System.out.println("Este es el porcentaje de libres: " + porcentajes(libres)+ "%");
        System.out.println("Este es el porcentaje de ocupados: " + porcentajes(ocupadas) + "%");
        System.out.println("Este es el porcentaje de reservas: " + porcentajes(reservadas) + "%");
        System.out.println("Esta es la recaudación del total de butacas de hoy:  " + this.recaudacion + "€");




    }

    private float porcentajes(int estado) {
        int BUTACAS_TOTALES = 45;
        int porcentajes = estado * 100 / BUTACAS_TOTALES;
        porcentajes = Math.round(porcentajes * 100) / 100;
        return porcentajes ;
    }
}

