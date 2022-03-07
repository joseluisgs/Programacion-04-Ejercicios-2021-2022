package RubenG.models;

import java.time.LocalDate;

/**
 * Clase Ticket
 *
 * @author: Rubén Garcia-Redondo Marín
 * @version 1.0
 */

public class Ticket {
    private int id;
    private String fila;
    private int columna;
    private LocalDate instante;
    private static int idcount;


    public String getFila() {return fila;}

    public int getColumna() {return columna;}

    public LocalDate getInstante() {return instante;}

    public void setTicket(String fila, int columna){
        this.id = idcount;
        this.fila = fila;
        this.columna = columna;
        this.instante = LocalDate.now();
        ++idcount;
    }

    @Override
    public String toString() {
        return "Ticket:" +
                "ID=" + id +
                ", Butaca=" + fila + (columna + 1) +
                ", Fecha=" + instante +
                '.';
    }
}
