package com.azahara;

import java.util.Scanner;

import static com.azahara.Utiles.getTipoDeDisparo;
import static com.azahara.Utiles.numeroAleatorio;

/**
 * @Author Azahara Blanco Rodríguez
 *
 *
 * @Description Examen de Programacion Batalla de Star daw
 * Simulación de una batalla de drones en el espacio:
 *
 * - tenemos drones de distintos tipos
 * - tenemos disparos de distintos tipos
 * - los drones se colocan de forma aleatoria
 * - patron fachada
 * - Acabamos la simulacion tras un cierto tiempo
 * - sacamos por teclado informe
 */
public class Main {

    public static void main(String[] args) {

            int dronesIniciales;
            boolean finGuerra = false;
            boolean todosMuertos= false;

            //pedir el tiempo de ejecicion en minutos

            Utiles u = new Utiles();


            int minutos = u.getMinutos();
            int TIEMPO_DE_GUERRA = minutos*6000;


            // Crear tablero espacial pidiendo numero etre 5 y 9

            int tamañoTablero = u.getTamañoTablero();
            Tablero t =new Tablero(tamañoTablero);

            //creamos drones y colocarlos

            dronesIniciales = t.crearDronesEnElTablero();
            t.moverDronesPorElTablero();

            // iniciamos la guerra hasta matar o acabar tiempo

            do {
                //imprimir espacio

                    t.verTablero();

                //escaneamos casilla aleatoria y buscamos donde disparar hasta que encontremos algo

                    Dron dron = t.encontrarDron();
                    int disparo= getTipoDeDisparo();
                    dron.setEnergia(dron.getEnergia()-disparo);

                //si la energia del dron es 0 matamos al dron

                    t.disparoAlDron(disparo, dron);


                //nos esperamos 100 milisegundos hasta el siguiente disparo

                    boolean esHoraDeMoverDrones = t.esperamos(disparo);
                    t.moverDronesPorElTablero(esHoraDeMoverDrones);

                //opciones de salida

                    finGuerra = t.isFinGuerra(TIEMPO_DE_GUERRA);
                    todosMuertos = t.mirarDronesMuertos();


            }while(finGuerra || todosMuertos);

            //sacar informe

                System.out.println(TIEMPO_DE_GUERRA);

                t.sacarInfrome(dronesIniciales);






    }

















}
