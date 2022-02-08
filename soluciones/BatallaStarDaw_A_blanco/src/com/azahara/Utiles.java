package com.azahara;

import java.util.Scanner;

public class Utiles {


    /**
     *
     * @param numeroMaximo del numero aleatorio
     * @return un numero aleatorio entre 0 y max
     */
    public static int numeroAleatorio(int numeroMaximo) {
        return ((int)(Math.random()*(numeroMaximo+1)));
    }

    /**
     * Descripcion buscamos por teclado un numero entre 1 y 3
     * @return int entre 1 y 3
     */
     public static int getMinutos() {

        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        int tamaño = 0;

        do {
            System.out.println("Dime cuantos minutos quieres Guerrear entre 1 y 3");
            try {
                tamaño = sc.nextInt();
                if (tamaño>=1 && tamaño<=3){
                    ok=true;
                }
            }catch ( Exception e){
                System.out.println("los minutos no son correctos tiene que ser entre 1 y 3");
                sc.next();
            }

        }while(!ok);
        return tamaño;

    }

    /**
     * Descripction pide un numero por teclado rentre 5 y 9
     * @return entero pedido por teclado entre 5 y 9
     */
     public static int getTamañoTablero() {
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        int tamaño = 0;

        do {
            System.out.println("Dime el espacio del tablero de 6 a 9 ");
            try {
                tamaño = sc.nextInt();
                if (tamaño>=6 && tamaño<=9){
                    ok=true;
                }
            }catch ( Exception e){
                System.out.println("El tamañono es correcto tiene que estar entre 6 y 9");
                sc.next();
            }

        }while(!ok);
        return tamaño;
    }

    /**
     * Descripction metodo que devuelve la ponencia de un disparo
     * @return un 5 el 15% de las veces y un 1 el resto
     */
    public static int getTipoDeDisparo() {

        //un 15% de las veces hacemos un disparo critico y restamos al enemigo 5 de energia
        int numero = numeroAleatorio(100);
        if(numero<= 15){
            return 5;
        }else{
            return 1;
        }


    }

    /**
     *
     * @param arreglo que quereos ordenar de drones
     * @return el arreglo ordenado de nemor vida a mayor
     */
    public static Dron[] metodoBurbuja( Dron [] arreglo) {


            Dron auxiliar;
            Dron [] arregloOrdenado;
            for(int i = 2; i < arreglo.length; i++)
            {
                for(int j = 0;j < arreglo.length-i;j++)
                {
                    if (arreglo[j]!=null && arreglo[j+1]!=null){
                        if((arreglo[j].getEnergia()) > (arreglo[j+1].getEnergia())) {
                            auxiliar = arreglo[j];
                            arreglo[j] = arreglo[j+1];
                            arreglo[j+1] = auxiliar;
                        }
                    }

                }
            }

            arregloOrdenado = arreglo;
            return arregloOrdenado;


    }
}
