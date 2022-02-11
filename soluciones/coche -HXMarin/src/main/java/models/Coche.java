package models;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Coche {
    private String marca;
    private String modelo;
    private String color;
    private String matricula;
    private boolean isEncendido;
    private boolean isApagado;
    private int marchaActual;
    private int velocidadActual;
    private boolean isSubirMarcha;
    private boolean isBajarMarcha;
    private int velocidadPedida;
    private int tiempoPedido;
    private int tiempoPantalla = 0;

    public Coche(String marca, String modelo, String color, String matricula, boolean isEncendido, int marchaActual, int velocidadActual) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matricula = setMatricula(matricula);
        this.isEncendido = setEncendido(isEncendido);
        this.marchaActual = setMarchaActual(marchaActual);
        this.velocidadActual = setVelocidadActual(velocidadActual);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public String setMatricula(String matricula) {
        if (matricula.length() != 7) {
            throw new IllegalArgumentException("La Matrícula tiene que tener 7 dígitos");
        } else
            return this.matricula = matricula;
    }

    public boolean getEncendido() {
        return isEncendido;
    }

    public boolean setEncendido(boolean isEncendido) {
        if (!isApagado)
            return this.isEncendido = isEncendido;
        else
            System.out.println("El coche está apagado.");
        return this.isApagado;
    }

    public boolean getApagado() {
        return isApagado;
    }

    public void setApagado(boolean isApagado) {
        isApagado = isApagado;
    }

    public int getMarchaActual() {
        return marchaActual;
    }

    public int setMarchaActual(int marchaActual) {
        if (marchaActual < 0 || marchaActual > 6) {
            throw new InvalidParameterException("Marchas disponibles de 1ª a 5ª");
        } else
            return this.marchaActual = marchaActual;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public int setVelocidadActual(int velocidadActual) {
        switch (velocidadActual) {
            case 1:
                velocidadActual = (int) (Math.random() * (30 - 0) + 30);
                break;
            case 2:
                velocidadActual = (int) (Math.random() * (50 - 30) + 30);
                break;

            case 3:
                velocidadActual = (int) (Math.random() * (70 - 50) + 50);
                break;
            case 4:
                velocidadActual = (int) (Math.random() * (100 - 70) + 70);
                break;
            case 5:
                velocidadActual = (int) (Math.random() * (210 - 100) + 100);
                break;
        }
        return this.velocidadActual = velocidadActual;
    }

    public void isReposando() {
        System.out.println("El Coche está quieto...");
    }

    public void isArrancando() {
        if (isEncendido)
            System.out.println("El coche está Arrancando... ");
    }

    public int subirMarcha(boolean isAcelerando) {
        if (isAcelerando)
            System.out.println("Subiendo Marcha...");
        return marchaActual++;
    }

    /**
     * Método que pide la velocidad pedida por teclado.
     *
     * @return
     */
    public int inputAceleracion() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("A que velocidad quiere llegar (Menor a 256):");
                velocidadPedida = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Dato introducido no válido");
                velocidadPedida = sc.nextInt();
            }
        } while (velocidadPedida > 255);
        return velocidadPedida;
    }

    public int inputMantenerVelocidad(){
        Scanner sc = new Scanner(System.in);
        tiempoPedido = 0;
        do{
            try {
                System.out.println("¿Cuanto tiempo quiere mantener la velocidad?: ");
                tiempoPedido = sc.nextInt();
            }catch (Exception e){
                System.out.println("Dato introducido no válido");
                tiempoPedido = sc.nextInt();
            }
        }while(tiempoPedido == 0);
        return tiempoPedido;
    }

    /**
     * Método que hace que el coche acelere hasta que llegue a una velocidad pedida por teclado:
     *
     * @return
     */
    public int acelerar() {
        velocidadActual = 0;
        for (int i = 0; i < velocidadPedida; i++) {
            velocidadActual++;
            System.out.println(velocidadActual + " Km/h");
        }
        return velocidadActual;
    }
    /**
     * Método que mantiene la Velocidad durante un tiempo pedido por teclado:
     *
     * @return
     */
    public int mantenerVelocidad() {
        for (int i = 0; i < tiempoPedido; i++) {
            tiempoPantalla++;
            System.out.println(tiempoPantalla + "s");
        }
        System.out.println(velocidadActual + " Km/h, mantenida: " + tiempoPantalla + " Segundos");
        return velocidadActual;
    }

    public int decelerar() {
        System.out.println(velocidadActual + " Km/h");
        System.out.println(velocidadActual - 1 + " Km/h");
        while (velocidadActual > 0) {
            velocidadActual--;
            System.out.println(velocidadActual + " Km/h");
        }
        return velocidadActual;
    }

    public boolean deadPoint() {
        System.out.println("Motor Apagado...");
        return isApagado = true;
    }
    public void frenazoGato(){
        int gato = 10;
        int probabilidad =(int)(Math.random()*100);
        if (probabilidad <= gato){
            System.out.println("CUIDADO GATO EN LA CARRETERA FRENA.");
            System.out.println("Motor calado...");
            System.exit(0);
        }
    }
}


