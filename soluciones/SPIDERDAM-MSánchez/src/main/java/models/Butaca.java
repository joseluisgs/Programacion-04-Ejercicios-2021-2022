package models;

import utils.Colors;
import utils.Inputs;

public class Butaca {
    //Estado
    private int filaSala;
    private int columnaSala;
    private Estado estado ;

    //Constructores
    public Butaca(){}

    public Butaca(int filasSala, int columnasSala) {
        setFilaSala(filasSala);
        setColumnaSala(columnasSala);
    }

    //Setters & Getters
    public int getFilaSala() {
        return filaSala;
    }

    public void setFilaSala(int filaSala) {
        this.filaSala = filaSala;
    }

    public int getColumnaSala() {
        return columnaSala;
    }

    public void setColumnaSala(int columnaSala) {
        this.columnaSala = columnaSala;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    //Comportamiento

}
