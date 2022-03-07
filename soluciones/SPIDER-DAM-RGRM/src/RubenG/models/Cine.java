package RubenG.models;

import RubenG.utils.Color;
import RubenG.utils.Input;
import java.util.Locale;

/**
 * Clase Cine
 *
 * @author: Rubén Garcia-Redondo Marín
 * @version 1.0
 */

public class Cine {

    //Estado

    private Butacas[][] sala = new Butacas[5][9];
    private double recaudaciones;
    private Ticket[] ticket = new Ticket[45];

    //Constructor
    public Cine() {
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                sala[i][j] = new Butacas(i,j);
            }
        }
        for (int i = 0; i < ticket.length; i++) {
            ticket[i] = new Ticket();
            ticket[i] = null;
        }
        this.recaudaciones = recaudaciones;
    }

    //Getter and Setter

    public Butacas[][] getSala() {
        return sala;
    }

    //Comportamiento

    public void imprimirSala(Butacas[][] aux){

        System.out.println("   1   2   3  4   5  6   7   8   9");
        System.out.println("  ---------------------------------");
        for (int i = 0; i < aux.length; i++) {
            switch (i){
                case 0: System.out.print("A|"); break;
                case 1: System.out.print("B|"); break;
                case 2: System.out.print("C|"); break;
                case 3: System.out.print("D|"); break;
                case 4: System.out.print("E|"); break;

            }
            for (int j = 0; j < aux[i].length; j++) {
                System.out.print(aux[i][j]);
            }

            System.out.println("|");

        }
        System.out.println("  ---------------------------------");
    }

    /**
     * Método para comprar entradas. Únicamente se comprará si la butaca está libre.
     */

    public void comprarEntradas(){
        String coordenada = "";
        int numero = -1;
        int numero0 = -1;
        boolean ok = false;
        boolean ok2 = false;
        boolean ok3 = false;
        Input sc = new Input();
        do {
            try{
                do{
                    System.out.println("Elija coordenada para comprar una entrada:");
                    coordenada = sc.readLine();
                    if(coordenada.trim().length() > 1){
                        ok3 = true;
                    }
                }while (!ok3);
                numero = Integer.parseInt(String.valueOf(coordenada.charAt(1)));
                coordenada = coordenada.toUpperCase(Locale.ROOT);
                if(coordenada.trim().length() == 2 && Character.isDigit(coordenada.charAt(1)) && Character.isLetter(coordenada.charAt(0))){
                    if(numero > 0 && numero < 10 ){
                        if(coordenada.charAt(0) == 'A' ||coordenada.charAt(0) == 'B' ||coordenada.charAt(0) == 'C' ||coordenada.charAt(0) == 'D' ||coordenada.charAt(0) == 'E'){
                            switch (coordenada.charAt(0)){
                                case 'A': numero0 = 0; ok = true; break;
                                case 'B': numero0 = 1; ok = true; break;
                                case 'C': numero0 = 2; ok = true; break;
                                case 'D': numero0 = 3; ok = true; break;
                                case 'E': numero0 = 4; ok = true; break;
                            }
                        }
                    }
                }else{
                    ok = false;
                }
                if(sala[numero0][numero - 1].getEstado() == Estado.LIBRE){
                    ok2 = true;
                }
            }catch (Exception e){
                System.out.println(Color.RED_BOLD + "Introduce unas coordenadas correctas.");
            }
        }while(!ok || !ok2);
        sala[numero0][numero - 1].setEstado(Estado.OCUPADO);
        recaudaciones += 6;
        for (int i = 0; i < ticket.length; i++) {
            if(ticket[i] == null){
                ticket[i] = new Ticket();
                ticket[i].setTicket(sala[numero0][numero - 1].getFila(), sala[numero0][numero - 1].getColumna());
                break;
            }
        }



    }

    /**
     * Método para reservar una entrada. Únicamente la reservará si la butaca está libre.
     */

    public void reservarEntradas(){
        String coordenada = "";
        int numero = -1;
        int numero0 = -1;
        boolean ok = false;
        boolean ok2 = false;
        boolean ok3 = false;
        Input sc = new Input();
        do {
            try{
                do{
                    System.out.println("Elija coordenada para reservar una entrada:");
                    coordenada = sc.readLine();
                    if(coordenada.trim().length() > 1){
                        ok3 = true;
                    }
                }while (!ok3);
                numero = Integer.parseInt(String.valueOf(coordenada.charAt(1)));
                coordenada = coordenada.toUpperCase(Locale.ROOT);
                if(coordenada.trim().length() == 2 && Character.isDigit(coordenada.charAt(1)) && Character.isLetter(coordenada.charAt(0))){
                    if(numero > 0 && numero < 10 ){
                        if(coordenada.charAt(0) == 'A' ||coordenada.charAt(0) == 'B' ||coordenada.charAt(0) == 'C' ||coordenada.charAt(0) == 'D' ||coordenada.charAt(0) == 'E'){
                            switch (coordenada.charAt(0)){
                                case 'A': numero0 = 0; ok = true; break;
                                case 'B': numero0 = 1; ok = true; break;
                                case 'C': numero0 = 2; ok = true; break;
                                case 'D': numero0 = 3; ok = true; break;
                                case 'E': numero0 = 4; ok = true; break;
                            }
                        }
                    }
                }else{
                    ok = false;
                }
                if(sala[numero0][numero - 1].getEstado() == Estado.LIBRE){
                    ok2 = true;
                }
            }catch (Exception e){
                System.out.println(Color.RED_BOLD + "Introduce unas coordenadas correctas.");
            }
        }while(!ok || !ok2);
        sala[numero0][numero - 1].setEstado(Estado.RESERVADO);

    }

    /**
     * Método para confirmar una reserva. Solo confirmará si la butaca está en reserva
     */

    public void confirmarReserva(){
        String coordenada = "";
        int numero = -1;
        int numero0 = -1;
        boolean ok = false;
        boolean ok2 = false;
        boolean ok3 = false;
        Input sc = new Input();
        do {
            try{
                do{
                    System.out.println("Elija coordenada para confirmar una reserva:");
                    coordenada = sc.readLine();
                    if(coordenada.trim().length() > 1){
                        ok3 = true;
                    }
                }while (!ok3);
                numero = Integer.parseInt(String.valueOf(coordenada.charAt(1)));
                coordenada = coordenada.toUpperCase(Locale.ROOT);
                if(coordenada.trim().length() == 2 && Character.isDigit(coordenada.charAt(1)) && Character.isLetter(coordenada.charAt(0))){
                    if(numero > 0 && numero < 10 ){
                        if(coordenada.charAt(0) == 'A' ||coordenada.charAt(0) == 'B' ||coordenada.charAt(0) == 'C' ||coordenada.charAt(0) == 'D' ||coordenada.charAt(0) == 'E'){
                            switch (coordenada.charAt(0)){
                                case 'A': numero0 = 0; ok = true; break;
                                case 'B': numero0 = 1; ok = true; break;
                                case 'C': numero0 = 2; ok = true; break;
                                case 'D': numero0 = 3; ok = true; break;
                                case 'E': numero0 = 4; ok = true; break;
                            }
                        }
                    }
                }else{
                    ok = false;
                }
                if(sala[numero0][numero - 1].getEstado() == Estado.RESERVADO){
                    ok2 = true;
                }
            }catch (Exception e){
                System.out.println(Color.RED_BOLD + "Introduce unas coordenadas correctas.");
            }
        }while(!ok || !ok2);
        sala[numero0][numero - 1].setEstado(Estado.OCUPADO);
        recaudaciones += 6;
        for (int i = 0; i < ticket.length; i++) {
            if(ticket[i].getInstante() == null){
                ticket[i].setTicket(sala[numero0][numero - 1].getFila(), sala[numero0][numero - 1].getColumna());
                break;
            }
        }
    }

    /**
     * Método el cual sirve para anular una reserva o una compra, y solo anulará si la butaca esta reservada u ocupada. Anulará también el ticket
     */

    public void anularReserva(){
        String coordenada = "";
        int numero = -1;
        int numero0 = -1;
        boolean ok = false;
        boolean ok2 = false;
        boolean ok3 = false;
        Input sc = new Input();
        do {
            try{
                do{
                    System.out.println("Elija coordenada para anular una entrada:");
                    coordenada = sc.readLine();
                    if(coordenada.trim().length() == 2){
                        ok3 = true;
                    }
                }while (!ok3);
                numero = Integer.parseInt(String.valueOf(coordenada.charAt(1)));
                coordenada = coordenada.toUpperCase(Locale.ROOT);
                if(coordenada.trim().length() == 2 && Character.isDigit(coordenada.charAt(1)) && Character.isLetter(coordenada.charAt(0))){
                    if(numero > 0 && numero < 10 ){
                        if(coordenada.charAt(0) == 'A' ||coordenada.charAt(0) == 'B' ||coordenada.charAt(0) == 'C' ||coordenada.charAt(0) == 'D' ||coordenada.charAt(0) == 'E'){
                            switch (coordenada.charAt(0)){
                                case 'A': numero0 = 0; ok = true; break;
                                case 'B': numero0 = 1; ok = true; break;
                                case 'C': numero0 = 2; ok = true; break;
                                case 'D': numero0 = 3; ok = true; break;
                                case 'E': numero0 = 4; ok = true; break;
                            }
                        }
                    }
                }else{
                    ok = false;
                }
                if(sala[numero0][numero - 1].getEstado() == Estado.RESERVADO || sala[numero0][numero - 1].getEstado() == Estado.OCUPADO){
                    ok2 = true;
                }
            }catch (Exception e){
                System.out.println(Color.RED_BOLD + "Introduce unas coordenadas correctas.");
            }
        }while(!ok || !ok2);
        sala[numero0][numero - 1].setEstado(Estado.LIBRE);
        recaudaciones -= 6;

        for (int i = 0; i < ticket.length; i++) {
            if (ticket[i] != null){
                if(ticket[i].getFila().equals(String.valueOf(coordenada.charAt(0))) && ticket[i].getColumna() == (numero - 1)){
                    ticket[i] = null;
                }
            }

        }
    }

    /**
     * Método que imprime el resumen del cine
     */
    public void resumen(){
        int filas = 0;
        double ocupacion = 0;
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                if(sala[i][j].getEstado() == Estado.OCUPADO || sala[i][j].getEstado() == Estado.RESERVADO){
                    filas += 1;
                }
            }
        }
        ocupacion = filas/45f;
        ocupacion = Math.round(ocupacion* 100f * 100f / 100f);

        System.out.println("Dinero recaudado: " + recaudaciones + "€");
        System.out.println("Numero de filas ocupadas: " + filas);
        System.out.println("Porcentaje de ocupación: " + ocupacion + "%");

    }

    /**
     * Método que imprime los tickets no nulos.
     */

    public void imprimirTicket() {
        for (int i = 0; i < ticket.length; i++) {
            if (ticket[i] != null){
                System.out.println(ticket[i].toString());
            }
        }

    }
}
