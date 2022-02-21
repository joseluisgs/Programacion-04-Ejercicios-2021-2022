package models;

import utils.Input;

public class Coche {
    private final String marca;
    private final String modelo;
    private final String color;
    private final String matricula;

    private String motor;   //Encendidio o apagado.
    private int marchaActual;   //Rangos de marcha: 1ª 0 – 30; 2ª 30 – 50; 3ª 50 – 70; 4ª 70 – 100; 5ª 100 →
    private int velocidadActual;

    private int tiempo;
    private final int velocidadMaxima;
    private boolean freno;


    /**
     * Constructor.
     * @param marca marca aleatoria de coche.
     * @param modelo modelo aleatorio de coche.
     * @param color color aleatorio de coche.
     * @param matricula matrícula aleatoria de coche.
     */
    public Coche(String marca, String modelo, String color, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matricula = matricula;

        tiempo = Input.pedirTiempo();
        this.tiempo = tiempo * 1000;    //Pasado ya a milisegundos
        velocidadMaxima = Input.pedirVelocidad();
    }


    /**
     * Método que engloba todos los métodos de arrancar hasta parar.
     */
    public void cicloCoche(){
        System.out.println(this);
        arrancar();
        subirMarchas();
        mantenerTiempoMarcha();
        bajarMarcha();
        apagar();
    }


    /**
     *Apagar coche.
     */
    private void apagar() {
        if (!freno) {
            motor = "apagado";
            System.out.println("Apagamos el coche");
            System.out.println("Motor: " + motor);
        }
    }


    /**
     * Bajar las marchas.
     */
    private void bajarMarcha() {
        for (int i = velocidadMaxima-1; i >= 0 && !freno; i--){
                velocidadActual = i;
                switchMarchas(velocidadActual);
                System.out.println("Estás en la marcha 🕹:" + marchaActual);
                System.out.println(velocidadActual);
                frenazo();
        }
    }


    /**
     * Tiempo que debe mantener la marcha.
     */
    private void mantenerTiempoMarcha() {
        while(tiempo>0 && !freno) {
            frenazo();
            if (!freno) {
                System.out.println(velocidadMaxima);
                tiempo -= 1000;     //Pongo 1000 ya que eso es un segundo
            }
        }
    }


    /**
     * Ir subiendo marchas.
     */
    private void subirMarchas() {
        for (int i = 0; i < velocidadMaxima && !freno; i++){
                velocidadActual = i;
                switchMarchas(velocidadActual);
                System.out.println("Estás en la marcha 🕹:" + marchaActual);
                System.out.println(velocidadActual);
                frenazo();
        }
    }


    /**
     * Saber en que marcha está
     * @param velocidad velocidad actual.
     */
    private void switchMarchas(int velocidad) {
        if (velocidad < 30){
            marchaActual = 1;
        }else if (velocidad < 50){
            marchaActual = 2;
        }else if (velocidad < 70){
            marchaActual = 3;
        }else if (velocidad < 100){
            marchaActual = 4;
        }else{
            marchaActual = 5;
        }
    }


    /**
     * Arrancar coche.
     */
    private void arrancar() {
        motor = "encendido";
        System.out.println("Arrancamos el coche");
        System.out.println("Motor: " +motor);
    }


    /**
     * Probabilidad de frenazo y consecuencias de esta.
     */
    private void frenazo() {
        int num = (int) (Math.random() *100);

        if (num < 10) {
            freno = true;
            motor = "calado";
            velocidadActual = 0;
            System.out.println("Se nos ha cruzado el gato");
            System.out.println("Motor : " + motor);
            System.out.println("Velocidad por frenazo: " + velocidadActual);
        }else{
            freno = false;
        }

    }


    @Override
    public String toString() {
        return "Coche --> 🚗 " + "\n" +
                "marca:" + marca + "\n" +
                "modelo: " + modelo + "\n" +
                "color: " + color + "\n" +
                "matricula: " + matricula + "\n";
    }
}
