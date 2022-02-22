package com.azahara;

import java.util.ArrayList;
import java.util.Stack;

public class Mazo{
    private Stack<Carta> mazo = new Stack();
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Mazo -> " + nombre + mazo;
    }

    public String toStringCorta(){return "Mazo -> "+ nombre+ mazo.peek();}

    public String toStringNombre(){return "Mazo -> " + nombre;}

    public Mazo(String nombre) {
        this.nombre = nombre;
    }

    public void crearMazo(){

        System.out.println("creamos un mazo : ");
            //color negro
            for (int j = 0; j <2 ; j++) {
                //numeros

                for (int k = 1; k < 13; k++) {
                    String color = "negro";
                    String palo;
                    int numero = k;
                    if (j==0){
                        palo="♦";
                    }else{
                        palo="♣";
                    }
                    mazo.push(new Carta(numero, color , palo));
                    System.out.println(mazo.peek());
                }
            }
        //color Rojo
        for (int j = 0; j <2 ; j++) {
            //numeros

            for (int k = 1; k < 13; k++) {
                String color = "rojo";
                String palo;
                int numero = k;
                if (j==0){
                    palo="♠";
                }else{
                    palo="♥";
                }
                mazo.push(new Carta(numero, color , palo));
                System.out.println(mazo.peek());
            }
        }


    }



    public void barajear(){
        System.out.println("barajeamos mazo");

        ArrayList<Carta> mazoSupletorio = new ArrayList<Carta>();
        int largo = mazo.size();
        for (int i = 0; i < largo; i++) {
            mazoSupletorio.add(mazo.peek());
            mazo.pop();
        }
        for (int i = 0; i < largo; i++) {
            int numeroAleatorio = (int)(Math.random()*mazoSupletorio.size());
            this.ponerCarta(mazoSupletorio.get(numeroAleatorio));
            mazoSupletorio.remove(numeroAleatorio);
        }
    }

    public Carta cojerCarta(){
        Carta c =mazo.peek();
        mazo.pop();
        return c;
    }

    public void ponerCarta(Carta c){
        int finalMazo = mazo.size();
        mazo.add(finalMazo, c);
    }

    public Carta verCarta(){
        if(mazo.size()!=0){
            return mazo.peek();
        }
        return null;
    }

    public int size(){
        return mazo.size();
    }

}
