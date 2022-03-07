package RubenG.models;

import RubenG.utils.Color;

/**
 * Clase Butacas
 *
 * @author: Rubén Garcia-Redondo Marín
 * @version 1.0
 */

public class Butacas {
    private String fila;
    private int columna;
    private Estado estado = Estado.LIBRE;


    public Butacas(int fila, int columna) {
        switch (fila){
            case 0: this.fila = "A"; break;
            case 1: this.fila = "B"; break;
            case 2: this.fila = "C"; break;
            case 3: this.fila = "D"; break;
            case 4: this.fila = "E"; break;
        }
        this.columna = columna;
    }

    public String getFila() {return fila;}

    public int getColumna() {return columna;}

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return imprimirEstado();
    }

    /**
     * Imprime el estado de la butaca
     * @return El estado de la butaca: Verde si está libre, amarillo si está reservado y rojo si está ocupado
     */
    public String imprimirEstado() {
        if(estado == Estado.LIBRE){
            return(Color.GREEN_BOLD_BRIGHT + "[🟩]" + Color.RESET);
        }else if(estado == Estado.RESERVADO){
            return(Color.YELLOW_BOLD + "[🟨]" + Color.RESET);
        }else if(estado == Estado.OCUPADO){
            return(Color.RED_BOLD_BRIGHT + "[🟥]" + Color.RESET);
        }
        return null;
    }
}
