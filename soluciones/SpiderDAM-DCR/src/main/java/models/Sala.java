package models;

import Utils.Input;
import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
import static models.Estado.*;

public class Sala {
    private int recaudacion;
    private Butaca [][] butacas= new Butaca[5][9];
    private final int precio=6;
    private final int TOTAL_BUTACAS= butacas.length * butacas[butacas.length-1].length;

    public Sala() {
        this.recaudacion=0;
        construirSala();
    }
    public int getPrecio() {
        return precio;
    }
    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion += recaudacion;
    }
    public void construirSala(){
        for (int i = 0; i < butacas.length ; i++) {
            for (int j = 0; j < butacas[i].length ; j++) {
                butacas[i][j] = new Butaca();
                butacas[i][j].setFilas(butacas.length-i);
                butacas[i][j].setColumns(j+1);
            }
        }
        recaudacion();
    }
    public void verSala(){
        char letra=65;
        System.out.println("           🕷"+colorize(" SALA SPIDER-DAM ",BACK_COLOR(233), TEXT_COLOR(15))+ "🕷");
        System.out.println("     1   2   3   4   5   6   7   8   9");
        System.out.println("  |-------------[ PANTALLA ]-------------|");
        for (int i = 0; i < butacas.length ; i++) {
            System.out.print("\n"+(letra++) +" | ");
            for (int j = 0; j < butacas[i].length ; j++) {
                System.out.print(butacas[i][j]+ " ");
            }
            System.out.println("|\n");
        }
        System.out.println("  |-------------------------------------|");
        System.out.println("\n"+colorize("LEYENDA",TEXT_COLOR(214), BOLD(), UNDERLINE()));
        System.out.println("- Asientos disponibles: " +(colorize("[ ]", GREEN_BACK()))+"");
        System.out.println("- Asientos reservados:  " +(colorize("[ ]", BACK_COLOR(208))));
        System.out.println("- Asientos ocupados:    " +(colorize("[ ]", BACK_COLOR(1)))+"\n");
    }
    public void comprarEntrada(){
        String butaca;
        boolean libre;
        verSala();
        System.out.println("¿Qué butaca quiere?:");

        do {
            do {
                butaca = butacaIsCorrect();
                if (!correctFila(butaca) || !correctColumn(butaca))
                    System.out.println("La butaca seleccionada no existe.");
            } while (!correctFila(butaca) || !correctColumn(butaca));

            libre = butacaLibre(butaca);
            if (!libre) System.out.println("La butaca no esta disponible.");
        } while (!libre);
        System.out.println("Ha comprado la butaca " + butaca + ". Gracias por su compra.");
        cambiarEstado(butaca, OCUPADO);
        setRecaudacion(getPrecio());

    }
    public void reservarEntrada(){
        String butaca;
        boolean libre;
        verSala();
        System.out.println("¿Qué butaca quiere reservar?:");
        do {
            do {
                butaca= butacaIsCorrect();
                if (!correctFila(butaca) || !correctColumn(butaca)) System.out.println("La butaca seleccionada no existe.");
            }while(!correctFila(butaca) || !correctColumn(butaca));

            libre=butacaLibre(butaca);
            if (!libre) System.out.println("La butaca no esta disponible.");
        }while (!libre);
        cambiarEstado(butaca, RESERVADO);
        System.out.println("Enhorabuena su reserva ha sido realizada.");
    }
    public void confirmarReserva(){
        String butaca;
        boolean libre;
        System.out.println("¿Qué butaca quiere confirmar la reserva?:");
        do {
            do {
                butaca= butacaIsCorrect();
                if (!correctFila(butaca) || !correctColumn(butaca)) System.out.println("La butaca seleccionada no existe.");
            }while(!correctFila(butaca) || !correctColumn(butaca));

            libre=butacaReservada(butaca);
            if (!libre) System.out.println("La butaca no esta reservada.");
        }while (!libre);
        cambiarEstado(butaca, OCUPADO);
        setRecaudacion(getPrecio());

        System.out.println("Ha sido confirmada la reserva de la butaca "+ butaca +".");
    }
    public void anularEntrada(){
        String butaca;
        boolean libre;
        System.out.println("¿Qué entrada quiere anular?:");
        do {
            do {
                butaca= butacaIsCorrect();
                if (!correctFila(butaca) || !correctColumn(butaca)) System.out.println("La butaca seleccionada no existe.");
            }while(!correctFila(butaca) || !correctColumn(butaca));

            libre=butacaLibre(butaca);
            if (libre) System.out.println("La butaca esta libre.");
        }while (libre);

        if (!butacaReservada(butaca)){
            setRecaudacion(-6);
            System.out.println("Se ha anulado la compra de la entrada.");

        } else System.out.println("Se ha anulado la reserva.");
        cambiarEstado(butaca, LIBRE);

    }
    public void resumen(){
        int butacasOcupadas= busquedadEstado(OCUPADO);
        int butacasLibres= busquedadEstado(LIBRE);
        int butacasReservadas= busquedadEstado(RESERVADO);
        int numFilasOcupadas= filasOcupadas();

        System.out.println(colorize("⚫", GREEN_TEXT())+" Butacas libres: "+ butacasLibres+ "| " + porcentaje(butacasLibres) +"%\n"+
                colorize("⚫", TEXT_COLOR(208))+" Butacas reservadas: "+ butacasReservadas+ "| " + porcentaje(butacasReservadas) +"%\n"+
                colorize("⚫", RED_TEXT())+" Butacas ocupadas: "+ butacasOcupadas + "| " + porcentaje(butacasOcupadas) +"%");

        System.out.println("Hay " + numFilasOcupadas + " filas ocupadas completamente.");

        System.out.println("La recaudacion total de la sala es de " + getRecaudacion() + "€");

        
    }
    public int busquedadEstado(Estado estado){
        int numButacas= 0;
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length ; j++) {
                if (butacas[i][j].getEstado() == estado) numButacas++;
            }
        }
        return numButacas;
    }
    public int filasOcupadas(){
        int[] filasOcupadas= new int[butacas.length];
        int numFilasOcupadas=0;
        for (int i = 0; i < butacas.length ; i++) {
            boolean ocupada= true;
            for (int j = 0; j < butacas[i].length && ocupada ; j++) {
                if (butacas[i][j].getEstado() == LIBRE) ocupada=false;
            }
            if (ocupada) filasOcupadas[i]=1;
        }
        for (int i = 0; i < filasOcupadas.length ; i++) {
            if (filasOcupadas[i]==1) numFilasOcupadas++;
        }
        return numFilasOcupadas;
    }

    public String butacaIsCorrect(){
        Input input= new Input();
        boolean ok;
        String butaca;
        do {
            butaca = input.readString().toUpperCase();
            ok = Character.isLetter(butaca.charAt(0)) && Character.isDigit(butaca.charAt(1));
            if (!ok) System.out.println("La butaca seleccionada es incorrecta.");
        }while(!ok);
        return butaca;
    }
    public boolean correctFila(String butaca){
        char[] filas= {'A','B','C','D','E'};
        boolean ok=false;
        for (int i = 0; i < filas.length ; i++) {
            if (butaca.charAt(0) == filas[i]) ok=true;
        }
        return ok;
    }
    public boolean correctColumn(String butaca){
        return butaca.charAt(1) >= 1;
    }
    public boolean butacaLibre(String butaca){
        boolean ok= false;
        int fila= obtenerFila(butaca);
        int column= obtenerColumna(butaca);
        if (butacas[fila][column].getEstado() == LIBRE) ok=true;
        return ok;
    }
    public boolean butacaReservada(String butaca){
        boolean ok= false;
        int fila= obtenerFila(butaca);
        int column= obtenerColumna(butaca);
        if (butacas[fila][column].getEstado() == RESERVADO) ok=true;
        return ok;
    }
    public void cambiarEstado(String butaca , Estado estado){
        int fila= obtenerFila(butaca);
        int column= obtenerColumna(butaca);
        butacas[fila][column].setEstado(estado);
    }

    public int obtenerFila(String butaca){
        int num=4;
        if (butaca.charAt(0)== 'A') num=0;
        else if (butaca.charAt(0)== 'B') num=1;
        else if (butaca.charAt(0)== 'C') num=2;
        else if (butaca.charAt(0)== 'D') num=3;
        return num;
    }
    public int obtenerColumna(String butaca){
        int num=8;
        if (butaca.charAt(1)== '1') num=0;
        else if (butaca.charAt(1)== '2') num=1;
        else if (butaca.charAt(1)== '3') num=2;
        else if (butaca.charAt(1)== '4') num=3;
        else if (butaca.charAt(1)== '5') num=4;
        else if (butaca.charAt(1)== '6') num=5;
        else if (butaca.charAt(1)== '7') num=6;
        else if (butaca.charAt(1)== '8') num=7;
        return num;
    }
    public void recaudacion(){
        for (int i = 0; i < butacas.length ; i++) {
            for (int j = 0; j < butacas[i].length ; j++) {
                if (butacas[i][j].getEstado() == OCUPADO) setRecaudacion(getPrecio());
            }

        }
    }
    private float porcentaje(int butacas){
        float porcentaje= ((float)butacas*100/TOTAL_BUTACAS);
        porcentaje =(float) Math.round(porcentaje*100)/100;
        return porcentaje;
    }

}
