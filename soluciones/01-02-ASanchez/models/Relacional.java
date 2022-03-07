package Fraccion.models;

public class Relacional {
    //ESTADO
    private int numerador;
    private int denominador;

    //CONSTRUCTOR
    public Relacional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Relacional() {

    }

    //COMPORTAMIENTO
    @Override
    public String toString() {
        return "Numerador: " + numerador + "\n"
                + "Denominador: " + denominador + "\n";
    }

    public Relacional simplificar(Relacional r) {
        int dividir = mcd();
        r.numerador /= dividir;
        r.denominador /= dividir;

        return this;
    }

    public Relacional sumar(Relacional r) {
        int num = numerador * r.denominador + r.numerador * denominador;
        int den = denominador * r.denominador;

        Relacional resultado = new Relacional(num, den);
        return resultado.simplificar(resultado);
    }

    public Relacional restar(Relacional r) {
        int num = numerador * r.denominador - r.numerador * denominador;
        int den = denominador * r.denominador;

        Relacional resultado = new Relacional(num, den);
        return resultado.simplificar(resultado);
    }

    public Relacional multiplicar(Relacional r) {
        int num = numerador * r.numerador;
        int den = denominador * r.denominador;

        Relacional resultado = new Relacional(num, den);
        return resultado.simplificar(resultado);
    }

    public int mcd() {
        int u = Math.abs(numerador);
        int v = Math.abs(denominador);


    }

    //GETTERS & SETTERS
    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
}
