package Models;


import utils.Input;

import java.util.Date;

//TODO añadir relación con butaca. Y mejorar métodos de búsqueda
public class Ticket {
    public static int contador=1;
    private final int id;
    private final Butacas butaca;
    private final int filaButaca;
    private final int columnaButaca;
    private final Date fecha;



    //Constructor
    public Ticket(int filaButaca, int columnaButaca, Butacas butaca) {
        this.filaButaca = filaButaca;
        this.columnaButaca = columnaButaca;
        this.butaca = butaca;
        fecha = new Date();
        id = contador;
        contador++;
    }


    //Getter id
    public int getId() {
        return id;
    }

    public int getFilaButaca() {
        return filaButaca;
    }

    public int getColumnaButaca() {
        return columnaButaca;
    }

    public Butacas getButaca() {return butaca;}

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", filaButaca=" + (Input.charOfFila(filaButaca)) +
                ", columnaButaca=" + (columnaButaca+1) +
                ", fecha=" + fecha +
                '}';
    }
}
