package com.azahara;

public class Main {
    /**
     * juego parecido al solitario
     * -m es un mazo dende están todas las cartas descolocadas
     * -descartes es un mazo donde podemos dejar las cartas que no usemos
     * -descolocadas son mazon donde las cartas tienen que ir consecutivas y variando de color
     * -tenemos 4 palos, y tenemos que colocarlos en el color y orden correctos
     * -
     * -el juego acaba si le das a salir
     * @param args
     */

    public static void main(String[] args) {


        MesaFachada mesa = new MesaFachada();
        mesa.iniciarJuego();
        boolean salir=false ;
        do {

            //imprimimos los mazos
           mesa.imprimirMesa();

            //sacamos de una en una y las ponemos en el que queramos
            System.out.println("de que mazo quieres sacar");
            Mazo mazoASacar = mesa.elegirMazo();
            System.out.println("a que mazo quieres poner");
            Mazo mazoAPoner = mesa.elegirMazo();

            mesa.esPosibleHacer(mazoASacar,mazoAPoner);

            Utiles.preguntarSalir();

            mesa.cambioMazo();

        }while(!salir);

        System.out.println("quieres salir");









    }


}

