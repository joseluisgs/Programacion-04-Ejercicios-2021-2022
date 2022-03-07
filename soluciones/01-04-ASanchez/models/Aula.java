package Ordenador.models;

public class Aula {
    //ESTADO
    private String nombre;
    private int numero;
    private int capacidad;
    private int id;
    private static int contadorId = 1;

    //CONSTRUCTOR
    public Aula(String nombre, int numero, int capacidad) {
        this.nombre = nombre;
        this.numero = numero;
        this.capacidad = capacidad;
        this.id = contadorId++;
    }

    //COMPORTAMIENTO
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"
                + "Número: " + numero + "\n"
                + "Capacidad: " + capacidad + "\n"
                + "ID " + id;
    }

    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Aula.contadorId = contadorId;
    }
}
