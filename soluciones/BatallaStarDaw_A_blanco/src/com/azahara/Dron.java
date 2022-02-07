package com.azahara;

import static com.azahara.Utiles.numeroAleatorio;

public class Dron {
    private String tipo = "";
    private int energia = 0;

    /**
     * creador aleatoria de drones
     */
    public Dron() {
        //tipo
        int numero = numeroAleatorio(100);
        if (numero<=30){
            this.tipo = "SW- 384";
            this.energia = 50;

        }else if (numero<=80){
            this.tipo = "SW- 447";
            this.energia = 100;

        }else{
            this.tipo = "SW-4421";
            int energia = (100+(numeroAleatorio(50)));
            this.energia = energia;

        }


    }

    public String getTipo() {
        return tipo;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }



}
