package models;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Butaca {
    private int filas;
    private int columns;
    private Estado estado;

    public Butaca() {
        crearButacasRandom();
    }

    public int getFilas() {
        return filas;
    }

    public int getColumns() {
        return columns;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setEstadoRandom() {
        int probabilidad= (int)(Math.random() * 100 + 1);
        if (probabilidad < 45) this.estado = Estado.LIBRE;
        else if (probabilidad < 55) this.estado = Estado.RESERVADO;
        else{
            this.estado = Estado.OCUPADO;
        }
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    public void crearButacasRandom() {
        int fila= (int)(Math.random() * 5 +1);
        int column= (int)(Math.random() * 9 +1);
        setColumns(column);
        setFilas(fila);
        setEstadoRandom();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (estado == Estado.LIBRE){
            sb.append(colorize("[ ]", GREEN_BACK()));
        } else if (estado == Estado.RESERVADO){
            sb.append(colorize("[ ]", BACK_COLOR(208)));
        }else if (estado == Estado.OCUPADO){
            sb.append(colorize("[ ]", BACK_COLOR(1)));
        } else {
            sb.append("[ ]");
        }
        return sb.toString();
    }
}
