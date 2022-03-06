package Ordenador.models;

public class Ordenador {
    //ESTADO
    private int ram;
    private int hd;
    private String procesador;

    //CONSTRUCTOR
    public Ordenador(String procesador, int ram, int hd) {
        this.ram = ram;
        this.hd = hd;
        this.procesador = procesador;
    }

    public Ordenador() {
    }

    //COMPORTAMIENTO
    public String toString() {
        return "Procesador:" + procesador + "\n"
                + "RAM: " + ram + "\n"
                + "HD: " + hd;
    }

    //GETTERS & SETTERS
    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
}
