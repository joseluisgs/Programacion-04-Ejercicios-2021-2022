package com.azahara;

import java.util.Arrays;

import static com.azahara.Utiles.numeroAleatorio;

public class Tablero {
    private int tamaño=0;
    private Dron [][] tablero = new Dron[tamaño][tamaño];
    private Dron[] drones = new Dron [30];
    private int dronesMuertos=0;
    private int disparosRealizados=0;
    private int contador=0;
    private int contadorParaMoverDrones=0;

    @Override
    public String toString() {
        return "Tablero{" +
                "tamaño=" + tamaño +
                ", dronesMuertos=" + dronesMuertos +
                ", disparosRealizados=" + disparosRealizados +
                ", contador=" + contador +
                '}';
    }

    /**
     *
     * @param tamaño tamaño que le queremos dar a nuetro tablero y matriz de drones
     */
    public Tablero( int tamaño) {
        this.tamaño = tamaño;
        Dron [][] tablero =new Dron[tamaño][tamaño];
        this.tablero = tablero;
    }

    /**
     *
     *   donde queremos introducir los drones "crear"
     * @return tablero con un numero aleatorio de drones entre 0 y 30
     */
    public int crearDronesEnElTablero() {

        //elegir numero de drones aleatorio
        int droidesIniciales = ( 5+numeroAleatorio(25));
        int droidesInicioados =0;

        //crear drones en la matriz para pasarlos al tablero

        for (int i = 0; i < droidesIniciales; i++) {
            drones[i]=new Dron();
            System.out.println("/"+ drones[i].getTipo() + drones[i].getEnergia());
        }



        //elegir posicion del tablero aleatoria y si es null cramos dron

        int columna=-1;
        int fila = -1;

        //esto no lo necesitamos porque lo usamos en mover drones por el tablero

        /**
        do {

            columna = numeroAleatorio(tamaño-1);
            fila = numeroAleatorio(tamaño-1);

            System.out.println("largo del tablero  "+ tablero.length);


            if (tablero[fila][columna]==null){

                //pasamos dron3

                tablero[fila][columna] = new Dron();
                droidesIniciales++;
            }

        }while (droidesInicioados==droidesIniciales);
         */

        System.out.println("todos los droides están iniciados");

        return droidesIniciales;
    }

    /**
     *
     * @returnposicion devuelve un dron encontrado de forma aleatoria
     */
    public Dron encontrarDron() {
        boolean dron = false;
        int columna = -1;
        int fila =-1;
        do {
            columna = numeroAleatorio(tamaño-1);
            fila = numeroAleatorio(tamaño-1);
            if (tablero[fila][columna]==null){
                //no encontrado
            }else{
                System.out.println("dron encontrado");
                dron=true;
            }
        }while (!dron);
        return tablero[fila][columna];
    }

    /**
     *
     * @param disparo fuerza de el disparo, o un numero entero a restar a la energía de un dron
     * @param dron objeto DRON al que queremos disparar y al que restaremos la energía
     */
    public void disparoAlDron(int disparo, Dron dron) {

        dron.setEnergia((dron.getEnergia()-disparo));

        if (dron.getEnergia()<=0){
            dronesMuertos++;
            System.out.println("has matado un Dron");
        }else {
            System.out.println("has disparado un Dron");
        }
        disparosRealizados++;
    }


    /**
     *
     * @param disparo la furza que queremos imprimir por pantalla
     * @return si es hora de colocar de nuevo los aviones, true tenemos que recolocarlos
     */
    public boolean esperamos(int disparo) {
        contador= contador+100;
        contadorParaMoverDrones = contadorParaMoverDrones+100;
        System.out.println("disparo realizado al dron encontrado de una fuerza: " + disparo);

            //que duerma un rato
            try
            {
                Thread.sleep(100);
            }catch(InterruptedException ignored){}


        System.out.println("el tiempo total que llebamos en el juego es de: "+ contador );
        if (contadorParaMoverDrones>=300){
            contadorParaMoverDrones=0;
            return true;
        }else {
            return false;
        }

    }

    /**
     * Description nos coloca los drones de forma diferente en la matriz y nos oculta los que han muerto
     * @param esHoraDeMoverDrones le pasamos un true si quiere que movamos los drones
     */
    public void moverDronesPorElTablero(boolean esHoraDeMoverDrones) {
        if (esHoraDeMoverDrones){


            Dron [][] tablero2 = new Dron[tamaño][tamaño];

            for (int i = 0; i < drones.length; i++) {

                    if (drones[i]!=null && (drones[i].getEnergia())>0 ){

                        //buscar posicion en el nuevo tablero vacia
                        int columna;
                        int fila;

                        boolean posicionNuevaVacia = false;
                        do {

                             columna = numeroAleatorio(tablero.length-1);
                             fila = numeroAleatorio(tablero.length-1);

                            if (tablero2[fila][columna]==null){
                                posicionNuevaVacia=true;
                            }

                        }while (!posicionNuevaVacia);

                        posicionNuevaVacia=false;

                        //cambiamos posiciones
                        tablero2[fila][columna]=drones[i];

                    }

            }
            System.out.println("Los drones se han movido");
            this.tablero =tablero2;

        }

    }

    /**
     * Description nos coloca los drones de forma diferente en la matriz y nos oculta los que han muerto
     *
     */
    public void moverDronesPorElTablero() {



            Dron [][] tablero2 = new Dron[tamaño][tamaño];

            for (int i = 0; i < drones.length; i++) {

                if (drones[i]!=null && (drones[i].getEnergia())>0 ){

                    //buscar posicion en el nuevo tablero vacia
                    int columna;
                    int fila;

                    boolean posicionNuevaVacia = false;
                    do {

                        columna = numeroAleatorio(tablero.length-1);
                        fila = numeroAleatorio(tablero.length-1);

                        if (tablero2[fila][columna]==null){
                            posicionNuevaVacia=true;
                        }

                    }while (!posicionNuevaVacia);

                    posicionNuevaVacia=false;

                    //cambiamos posiciones
                    tablero2[fila][columna]=drones[i];
                }

            }
            System.out.println("Los drones se han movido");
            this.tablero =tablero2;



    }

    /**
     *
     * @param TIEMPO_DE_GUERRA el contador con el tiempo que llevamos de simulacion
     * @return si ha llegado el momento de finalizar la simulacion por tiempo, true ha de finalizar
     */
    public boolean isFinGuerra( int TIEMPO_DE_GUERRA) {
        if (contador>= TIEMPO_DE_GUERRA){
            return false;
        }
        return true;
    }

    /**
     *
     * @ nos devuelve un boleano de si debemos finalizar el programa proque los drones esten muertos
     */
    public boolean mirarDronesMuertos() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j <tablero.length ; j++) {
                if (tablero[i][j]!=null){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @Description nos saca un informe de la guerra
     * @param droidesIniciales los droides que hemos creado en el inicio un int
     */
    public void sacarInfrome(int droidesIniciales) {
        System.out.println("✈ 🛫 🛬 ✈ 🛫 🛬 ✈ 🛫 🛬   Acabada la simulación ✈ 🛫 🛬 ✈ 🛫 🛬 ✈ 🛫 🛬 ");

        System.out.println(toString());
        System.out.println("los dornes iniciales eran : "+ droidesIniciales);

        ordenarDronesPorVida();
        imprimirDrones();
    }

    /**
     * @Description nos imprime un vector de drones ordenados por vida
     */
    private void imprimirDrones() {
        for (int i = 0; i < drones.length; i++) {
            if(drones[i]!=null){
                System.out.println(i+1 + " : " +drones[i] +" Energia: "+ drones[i].getEnergia() +" Tipo: "+ drones[i].getTipo() );
            }
        }
    }

    /**
     * @Description nos ordena los drones por vida
     */
    private void ordenarDronesPorVida() {
        Utiles.metodoBurbuja(drones);

    }

    /**
     * @Description nos imprime la matriz del tablero de forma visual
     */
    public void verTablero() {
        for (int i = 0; i < tablero.length ; i++) {
            System.out.print("[");
            for (int j = 0; j <tablero.length ; j++) {
                System.out.print("|");
                if (tablero[i][j]==null){
                    System.out.print("          ");
                }else{
                    System.out.print(tablero[i][j].getTipo()+ " " + tablero[i][j].getEnergia());
                }

            }
            System.out.println("|]");
        }
    }
}
