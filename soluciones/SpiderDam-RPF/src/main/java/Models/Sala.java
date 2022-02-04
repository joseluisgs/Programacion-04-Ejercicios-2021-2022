package Models;


import utils.Input;

import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;

public class Sala {

    //Instancia
    private static Sala instance= null;

    //Constantes
    private final int MAX_FILA=5;
    private final int MAX_COLUMNA=9;
    private final int price;

    //Variables de cantidad butacas(tipos)
    private int butacasCompradas;
    private int butacasReservadas;
    private int butacasLibres;
    private int filasCompradasCompletas;

    //Butacas
    private final Butacas[][] butaca;
    //Letras para filas
    private final char[] columnaLetras = {'A','B','C','D','E'};
    //Tickets
    private final Ticket[] tickets;


    //Getters
    public int getButacasCompradas() {return butacasCompradas;}

    public int getButacasReservadas() {return butacasReservadas;}

    public int getButacasLibres() {return butacasLibres;}

    public int getPrice() {return price;}


    /**
     * Instancia de sala.
     * @return te devuelve siempre la misma sala.
     */
    public static Sala getInstance(int price){
        if (instance==null){
            instance = new Sala(price);

        }
        return instance;
    }


    /**
     * Constructor de Sala.
     */
    private Sala(int price) {
        this.price=price;
        butaca = new Butacas[MAX_FILA][MAX_COLUMNA];
        butacasNewSala();
        tickets = new Ticket[45];
    }


    /**
     * Iniciarlizar todas las butacas en libres.
     */
    private void butacasNewSala() {
        for (int i=0; i<butaca.length; i++) {
            for (int j=0; j<butaca[i].length; j++){
                butaca[i][j] = new Butacas(Estado.LIBRE);
                butacasLibres++;
            }
        }
    }


    /**
     * Switch de opciones del menú.
     * @param option la opcion elegida.
     */
    public void switchOptionMenu(int option){
        switch (option){
            case 1: verSala();
            break;
            case 2: comprarEntrada();
            break;
            case 3: reservarEntrada();
            break;
            case 4: confirmarReservaEntrada();
            break;
            case 5: anularEntrada();
            break;
            case 6: anularTicketCompra();
            break;
            case 7: resumen();
            break;
            case 8: readAllTickets();
            break;
        }
    }


    /**
     * Método de anulación de ticket.
     */
    private void anularTicketCompra() {
        int idAnularTicket;
        int posicionTicket;
        int filaAnularTicket;
        int colAnularTicket;
        boolean okTicket= false;

        do {
            do {
                idAnularTicket = Input.pedirIdTicket();
                posicionTicket = getPosicionTicket(idAnularTicket);
                    if(posicionTicket == -1) System.out.println("Este ID no existe");
            }while(posicionTicket == -1);

                filaAnularTicket = tickets[posicionTicket].getFilaButaca();
                colAnularTicket = tickets[posicionTicket].getColumnaButaca();

                if (butaca[filaAnularTicket][colAnularTicket].getEstado() == Estado.COMPRADO){
                    System.out.println(colorize("Has confirmado la anulación de la butaca por ticket",TEXT_COLOR(196)));

                    butaca[filaAnularTicket][colAnularTicket].setEstado(Estado.LIBRE);
                    tickets[posicionTicket] = null;

                    okTicket = true;
                    butacasCompradas--;
                    butacasLibres++;

            }else System.out.println(colorize("Lo siento 😮 esta butaca no está comprada, vuelva a elegir", RED_TEXT()));
        }while(!okTicket);
    }


    /**
     * Método para la compra de la entrada.
     */
    private void comprarEntrada() {
        int colCompra;
        int filaCompra;
        int posicion;
        boolean ok= false;

        do {
            filaCompra = Input.pedirFila();
            if (filaCompra == 3617) ok = true;

            if (filaCompra != 3617) {
                colCompra = Input.pedirColumn();
                if (butaca[filaCompra][colCompra].getEstado() == Estado.LIBRE) {
                    System.out.println((colorize("Has comprado la butaca 🎟🎟 ", GREEN_TEXT())));
                        butaca[filaCompra][colCompra].setEstado(Estado.COMPRADO);

                    posicion = buscarSitio();
                    tickets[posicion] = new Ticket(filaCompra, colCompra,butaca[filaCompra][colCompra]);
                    System.out.println(tickets[posicion].toString());
                    ok = true;
                    butacasCompradas++;
                    butacasLibres--;

                } else
                    System.out.println(colorize("Lo siento 😮 esta butaca ya está ocupada o reservada, vuelva a elegir", RED_TEXT()));
            }
        }while (!ok) ;
    }


    /**
     * Método de reserva de entrada.
     */
    private void reservarEntrada() {
        int colReserva;
        int filaReserva;
        boolean ok= false;

        do {
            filaReserva = Input.pedirFila();
            if (filaReserva == 3617) ok = true;

            if (filaReserva != 3617) {
                colReserva = Input.pedirColumn();

                if (butaca[filaReserva][colReserva].getEstado() == Estado.LIBRE) {
                    System.out.println(colorize("Has reservado la butaca 📩", TEXT_COLOR(45)));
                    butaca[filaReserva][colReserva].setEstado(Estado.RESERVADO);

                    ok = true;
                    butacasReservadas++;
                    butacasLibres--;

                } else
                    System.out.println(colorize("Lo siento 😮 esta butaca ya está ocupada o reservada, vuelva a elegir", RED_TEXT()));
            }
        }while(!ok);
    }


    /**
     * Método para confirmar reserva de entrada.
     */
    private void confirmarReservaEntrada() {
        int colConfirmar;
        int filaConfirmar;
        int posicion;
        boolean ok= false;

        do {
            filaConfirmar = Input.pedirFila();
            if (filaConfirmar == 3617) ok = true;

            if (filaConfirmar != 3617) {
                colConfirmar = Input.pedirColumn();

                if (butaca[filaConfirmar][colConfirmar].getEstado() == Estado.RESERVADO) {
                    System.out.println(colorize("Has confirmado la compra de la reserva de la butaca 🎟🎟 ", TEXT_COLOR(201)));
                    butaca[filaConfirmar][colConfirmar].setEstado(Estado.COMPRADO);

                    posicion = buscarSitio();
                    tickets[posicion] = new Ticket(filaConfirmar, colConfirmar, butaca[filaConfirmar][colConfirmar]);
                    System.out.println(tickets[posicion].toString());

                    ok = true;
                    butacasReservadas--;
                    butacasCompradas++;

                } else
                    System.out.println(colorize("Lo siento 😮 esta butaca no está en reservados o ya está comprada, vuelva a elegir", RED_TEXT()));
            }
        }while (!ok) ;
    }


    /**
     * Método de anulación de entrada.
     */
    private void anularEntrada() {
        int colAnular;
        int filaAnular;
        boolean ok= false;

        do {
            filaAnular = Input.pedirFila();
            if (filaAnular == 3617) ok = true;

            if (filaAnular != 3617) {
                colAnular = Input.pedirColumn();

                if (butaca[filaAnular][colAnular].getEstado() != Estado.LIBRE) {
                    ok = true;
                    System.out.println(colorize("Has confirmado la anulación de la butaca", TEXT_COLOR(196)));

                    if (butaca[filaAnular][colAnular].getEstado() == Estado.COMPRADO) {
                        butaca[filaAnular][colAnular].setEstado(Estado.LIBRE);
                        tickets[borrarTicket(butaca[filaAnular][colAnular])] = null;
                        butacasCompradas--;
                        butacasLibres++;
                    } else if (butaca[filaAnular][colAnular].getEstado() == Estado.RESERVADO) {
                        butaca[filaAnular][colAnular].setEstado(Estado.LIBRE);
                        butacasReservadas--;
                        butacasLibres++;
                    }

                } else System.out.println(colorize("Lo siento 😮 esta butaca está libre, vuelva a elegir", RED_TEXT()));
            }
        }while (!ok) ;
    }


    /**
     * Método que al eliminar la butaca se elimine el ticket.
     * @return la posicion del ticket a borrar.
     */
    public int borrarTicket(Butacas butaca) {
        int num = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null){
                if (tickets[i].getButaca()==butaca) {
                    num = i;
                }
            }
        }
        return num;
    }


    /**
     * Conseguir la posicion del ticket deseado mediante su id
     * @param idAnularTicket id del ticket a anular
     * @return la posicion del ticket
     */
    private int getPosicionTicket(int idAnularTicket) {
        int num = -1;
        for (int i = 0; i < tickets.length; i++){
            if (tickets[i] != null){
                if (tickets[i].getId()==idAnularTicket) {
                    num = i;
                }
            }
        }
        return num;
    }


    /**
     * Buscar que sitio hay primero vacio para añadir el nuevo ticket
     * @return el primer hueco que hay vacío
     */
    public int buscarSitio() {
        int num = 0;
        for (int i = 0; i < tickets.length; i++){
            if (tickets[i] == null) {
                num = i;
            }
        }
        return num;
    }


    /**
     * Método para saber las filas completas que hay
     * @return número de filas completas
     */
    public int filasCompletas() {
        for (int i = 0; i < butaca.length; i++) {
            int fila = 0;
            for (int j = 0; j < butaca[i].length; j++) {

                if (butaca[i][j].getEstado() != Estado.LIBRE) {
                    fila++;
                }
                if (fila == butaca[i].length)
                    filasCompradasCompletas++;
            }

        }
        return  filasCompradasCompletas;
    }


    /**
     * Método para saber el porcentajes de las entradas
     * @param butacasNum número de butacas con un tipo de estado
     * @return float de porcentaje
     */
    public float porcentajesEntradas(int butacasNum) {
        float porcentaje;
        porcentaje = (float) butacasNum /  (MAX_FILA*MAX_COLUMNA) * 100.0f;
        return Math.round(porcentaje * 100.0f) / 100.0f;
    }


    /**
     * Método para ver la sala.
      */
    private void verSala() {
        StringBuilder result = new StringBuilder();
        result.append("    1    2    3   4    5    6    7   8    9" + "\n");

        for (int i = 0; i <butaca.length;i++){

            result.append(columnaLetras[i]).append("  ");

            for (int j = 0; j<butaca[i].length; j++){

                result.append(butaca[i][j].toString()).append(" ");
            }
            result.append("\n");
            result.append("\n");
        }
        System.out.println(result);
    }


    /**
     * Resumen con estadísticas, porcentajes.
     */
    public void resumen() {
        String resumen = colorize("Número de entradas compradas: ", TEXT_COLOR(177)) + getButacasCompradas() + "\n" +
                colorize("Porcentaje de entradas  compradas: ", TEXT_COLOR(177)) + porcentajesEntradas(getButacasCompradas()) + "%" + "\n" +
                colorize("Número de entradas reservadas: ", TEXT_COLOR(177)) + getButacasReservadas() + "\n" +
                colorize("Porcentaje de entradas reservadas: ", TEXT_COLOR(177)) + porcentajesEntradas(getButacasReservadas()) + "%" + "\n" +
                colorize("Número de entradas libres: ", TEXT_COLOR(177)) + getButacasLibres() + "\n" +
                colorize("Porcentaje de entradas libres: ", TEXT_COLOR(177)) + porcentajesEntradas(getButacasLibres()) + "%" + "\n" +
                colorize("Filas completas reservadas y/o compradas: ", TEXT_COLOR(177)) + filasCompletas() + "\n" +
                colorize("Total recaudación: ", TEXT_COLOR(177)) + ((getButacasCompradas()) * (getPrice())) + "€";

        System.out.println(resumen);

    }


    /**
     *  Método leer todos los tickets
     */
    public void orderTickets() {
        Ticket aux;
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < tickets.length; j++) {
                    if (tickets[i] != null & tickets[j] != null &&
                       (tickets[i].getId() < tickets[j].getId())) {
                           aux = tickets[i];
                            tickets[i] = tickets[j];
                            tickets[j] = aux;
                    }
                }
            }
        }



    /**
     * Listado
     */
    public void readAllTickets() {
        orderTickets();
        StringBuilder result = new StringBuilder();

            for (Ticket ticket : tickets) {
                if (ticket != null) {
                    result.append(" - ").append(ticket).append("\n");
                }
            }

        if (result.length() == 0) {
            result.append("No hay tickets");
        }
        System.out.println(result);
    }

}
