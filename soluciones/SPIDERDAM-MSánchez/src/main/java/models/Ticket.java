package models;
import creators.ControlarEntrada;
import utils.Colors;

import java.time.Instant;

public class Ticket {
    //Estado
    private static int idCounter = 1;
    ControlarEntrada entrada = new ControlarEntrada();
    private Instant instante;
    private float precio;
    private int fila;
    private int columna;
    private int id = 0;

    //Constructores
    public Ticket(){}
    public Ticket(float precio, int fila, int columna) {
        setPrecio(precio);
        setFila(fila);
        setColumna(columna);
        id = idCounter++;
        instante = Instant.now();

    }

    //Setters & Getters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Instant getInstante() {
        return instante;
    }

    public void setInstante(Instant instante) {
        this.instante = instante;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    //Comportamiento
    @Override
    public String toString(){
        return Colors.BLUE_BACKGROUND  + Colors.BLACK_BOLD + " Nº ticket: " + id + "   Fecha: " + instante + Colors.RESET + "\n" +
                Colors.BLUE_BACKGROUND + Colors.BLACK_BOLD + " Precio: " + precio +   "€                                     "  + Colors.RESET  + " \n" +
                Colors.BLUE_BACKGROUND + Colors.BLACK_BOLD + " Butaca: fila " + entrada.reasignarFila(fila) +  ", columna " + columna +  ".                       "+  Colors.RESET + " \n";
    }

}
