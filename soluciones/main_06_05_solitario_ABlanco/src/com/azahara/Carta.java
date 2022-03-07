package com.azahara;

public class Carta {
    private int numero ;
    private String color;
    private String palo;

    public Carta(int numero, String color, String palo) {
        this.numero = numero;
        this.color = color;
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta{" + numero + color + palo +'}';
    }

    public int getNumero() {
        return numero;
    }

    public String getColor() {
        return color;
    }

    public String getPalo() {
        return palo;
    }
}
