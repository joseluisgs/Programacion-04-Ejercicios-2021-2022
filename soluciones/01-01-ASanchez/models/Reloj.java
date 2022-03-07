package Reloj.models;

public class Reloj {
    //ESTADO
    private int hora;
    private int minutos;
    private int segundos;

    //CONSTRUCTOR
    public Reloj(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    //COMPORTAMIENTO
    public void recargarPila() {
        System.err.println("Recargando la pila...");
    }

    //GETTERS & SETTERS
    public int getHora(boolean formato24) {
        int hora24 = 0;
        if (formato24)
            return hora;
        else if (hora == 0)
            return 12;
        else if (hora > 12)
            hora24 = hora % 12;
            return hora24;
    }

    public void setHora(int hora24) {
        if (hora24 < 0 || hora24 > 23)
            throw new IllegalArgumentException("Hora no válida.");
        else
            this.hora = hora24;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        if (minutos < 0 || minutos > 59)
            throw new IllegalArgumentException("Minutos no válidos.");
        else
            this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        if (segundos < 0 || segundos > 59)
            throw new IllegalArgumentException("Segundos no válidos.");
        else
            this.segundos = segundos;
    }
}
