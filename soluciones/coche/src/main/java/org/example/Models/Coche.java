package org.example.Models;

import org.example.Utils.IotHK;

import java.util.Locale;

public class Coche {
    IotHK sc = new IotHK();

    private String marca;
    private String modelo;
    private String color;
    private String matricula;
    private int velocidad;
    private int marcha;
    private int temporizador;

    /**
     * Constructor.
     * @param matricula
     */
    public Coche(String matricula) {
        this.marca = listaMarcas();
        this.modelo = listaModelos();
        this.color = listaColores();
        setMatricula(matricula);
    }



    private String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    private String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    private String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private String getMatricula() {
        return matricula;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    private int getVelocidad() {
        return velocidad;
    }

    public int getMarcha() {
        return marcha;
    }

    private void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    private void setMatricula(String matricula) {
        if (longitudMatricula(matricula) && comprobarNumeros(matricula) && comprobarLetras(matricula)){
            this.matricula = matricula;
        }else{
            throw new IllegalArgumentException("La matricula introducida es incorrecta");
        }

    }


    //Métodos para comprobar la matrícula.

    /**
     * Comprueba la longitud de la matricula.
     * @param matricula
     * @return
     */
    private boolean longitudMatricula(String matricula){
        return matricula.length()==7;
    }

    /**
     * Comprueba si los 4 primeros caracteres con números
     * @param matricula
     * @return
     */
    private boolean comprobarNumeros(String matricula){
        for (int i = 0; i < 4; i++) {
            if (Character.isDigit(matricula.charAt(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba las letras de la matrícula.
     * @param matricula
     * @return
     */
    private boolean comprobarLetras(String matricula){
        for (int i = 4; i < matricula.length(); i++) {
            if (Character.isLetter(matricula.charAt(i))){
                return true;
            }
        }
        return false;
    }



    //Listado de las marcas

    /**
     * Lista de marca de coche
     * @return
     */
    private String listaMarcas(){
        String[] marcas = {"Toyota", "Mazda", "Infiniti", "Hyundai", "Audi", "BMW", "Mercedes"};
        int pos = (int) (Math.random() * marcas.length);
        return marcas[pos];
    }


    /**
     * Devuelve el modelo de coche según la marca
     * @return
     */
    private String listaModelos() {
        int pos = 0;
        switch (listaMarcas()) {
            case "Toyota":
                String[] modelosToyota = {"Corolla", "Yaris", "Rav4", "Land Cruiser", "Camry"};
                pos = (int) (Math.random() * modelosToyota.length);
                return modelosToyota[pos];
            case "Mazda":
                String[] modelosMazda = {"Mazda3", "Mazda6", "CX-3", "MX-5", "CX-3"};
                pos = (int) (Math.random() * modelosMazda.length);
                return modelosMazda[pos];
            case "Infiniti":
                String[] modelosInfiniti = {"QX30", "QX50", "Q30", "Q50", "Q60"};
                pos = (int) (Math.random() * modelosInfiniti.length);
                return modelosInfiniti[pos];
            case "Hyundai":
                String[] modelosHyundai = {"Tucson", "SantaFe", "I20", "I30", "IONIO"};
                pos = (int) (Math.random() * modelosHyundai.length);
                return modelosHyundai[pos];
            case "Audi":
                String[] modelosAudi = {"TT", "A4", "A3", "Q5", "A6"};
                pos = (int) (Math.random() * modelosAudi.length);
                return modelosAudi[pos];
            case "BMW":
                String[] modelosBMW = {"Serie 3", "Serie 4", "Serie 5", "X5", "X6"};
                pos = (int) (Math.random() * modelosBMW.length);
                return modelosBMW[pos];
            case "Mercedes":
                String[] modelosMercedes = {"Clase A", "Clase C", "Clase E", "Clase G", "Clase GLC"};
                pos = (int) (Math.random() * modelosMercedes.length);
                return modelosMercedes[pos];
            default:
                return "El modelo no se encuentra disponible";
        }
    }

    /**
     * Devuelve colores random
     * @return
     */
    private String listaColores(){
        String [] colores = {"Negro", "Azul", "Marron", "Gris", "Rojo", "Blanco"};
        int pos = (int) (Math.random()*colores.length);
        return colores[pos];
    }


    //Encender motor

    /**
     * Encender motor
     * @return
     */
    private boolean encenderCoche(String encender){
        IotHK sc =new IotHK();
        boolean isOk = false;
        if (encender.equals("ON")){
            System.out.println("🚗🚗");
            return isOk = true;
        }else {
            System.out.println("Coche apagado.");
            return isOk = false;
        }
    }

    /**
     * lectura de encendido
     * @return
     */
    private String lecturaDeEncendido() {
        String encender = "";
        do {
            try {
                System.out.println("Para encender el coche introduce [ON/OFF]");
                encender = sc.readLine().trim().toUpperCase(Locale.ROOT);
            }catch (Exception e){
                System.out.println("Introduce [ON/OFF] para encender el coche.");
                sc.readLine();
            }
        }while (!encender.equals("ON") && !encender.equals("OFF"));
        return encender;
    }


    private void marchaActual(int marcha){
        this.marcha = marcha;
    }


    private int velocidadActual(){
        return getVelocidad();
    }

    /**
     * Devuelve las marcha según la velocidad
     * @param velocidad
     */
    private void subirMarcha(int velocidad){
        if (velocidad > 0 && velocidad < 30){
            marcha = 1;
            marchaActual(marcha);
            setVelocidad(velocidad);
        }else if (velocidad  > 30 && velocidad < 50){
            marcha = 2;
            marchaActual(marcha);
        }else if (velocidad > 50 && velocidad < 70){
            marcha = 3;
            marchaActual(marcha);
        }else if (velocidad > 70 && velocidad < 100){
            marcha = 4;
            marchaActual(marcha);
        }else if (velocidad > 100){
            marcha = 5;
            marchaActual(marcha);
        }
    }


    private void cocheEnReposo(int velocidad) {
        if (velocidad == 0){
            System.out.println("Coche en reposo..");
        }
    }

    /**
     * Aumento de la velocidad
     * @param velocidadInput
     */
    private void aumentarVelocidad(int velocidadInput) {
        do {
            velocidad++;
            System.out.println(velocidad);
            subirMarcha(velocidad);
            marchaActualV();
        }while (velocidad < velocidadInput);
    }


    private void marchaActualV() {
        if (velocidad == 1){
            System.out.println("Marcha actual "+getMarcha());
        }else if (velocidad == 31){
            System.out.println("Marcha actual "+getMarcha());
        }else if (velocidad == 51){
            System.out.println("Marcha actual "+getMarcha());
        }else if (velocidad == 71){
            System.out.println("Marcha actual "+getMarcha());
        }else if (velocidad == 101){
            System.out.println("Marcha actual "+getMarcha());
        }
    }

    private void disminuirVelocidad(int velocidadInput) {
        do{
            velocidad--;
            System.out.println(velocidad);
            if (velocidad == 0){
                puntoMuerto();
                encenderCoche("OFF");
            }
        }while (velocidad != 0);
    }


    private void puntoMuerto(){
        this.velocidad = 0;
        this.marcha = 0;
        System.out.println("Punto muerto velocidad: "+velocidad);
        System.out.println("Punto muerto marcha: "+marcha);
    }


    private void cocheCalado(){
        System.out.println("Se ha cruzado un gato, frenazo.");
        encenderCoche("OFF");
    }


    private boolean randomPorcentaje(){
        return (Math.random()*100) < 10;
    }


    private static void mantenerVelocidad(int tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            System.err.println("Error en temporizador");
        }
    }


    public void funiconamiento(){
        System.out.println("Estado del coche.");
        cocheEnReposo(getVelocidad());

        String encender = lecturaDeEncendido();
        boolean isOK = false;
        do {
            try {
                isOK =  encenderCoche(encender);
            }catch (Exception e){
                sc.readLine();
            }
        }while (!isOK);

        System.out.println("Introduce velocidad crucero.");
        int velocidadInput = sc.readInt();
        System.out.println("Introduce el tiempo que deseas mantener la velocidad");
        int timepoMaximo = sc.readInt();
        System.out.println("Acelerar progresivamente.");
        aumentarVelocidad(velocidadInput);


        boolean hayUnGato = false;
        do {

            System.out.println("Velocidad actual: "+velocidadActual());
            System.out.println("Marcha actual: "+ getMarcha());
            temporizador++;
            mantenerVelocidad(timepoMaximo);
            hayUnGato = randomPorcentaje();

            if (hayUnGato){
                cocheCalado();
            }

        }while (temporizador <= timepoMaximo || !hayUnGato);

        disminuirVelocidad(velocidadInput);
    }




    @Override
    public String toString() {
        return "Coche{" +
                "[Marca: " + this.marca + ']' +
                " - [Modelo: " + this.modelo + ']' +
                " - [Color: " + this.color + ']' +
                " - [Matricula: " + this.matricula + ']' +
                '}';
    }



}
