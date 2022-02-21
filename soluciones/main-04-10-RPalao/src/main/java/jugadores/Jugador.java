package jugadores;

import models.Recurso;

public abstract class Jugador {
    private int madera =0;
    private int carbon =0;
    private int trigo =0;


    /**
     * Para saber si tiene todos sus recursos a 20 o mas
     * @return boolean
     */
    public boolean todoMasVeinte(){
        return (this.madera>=20 && this.carbon>=20 && this.trigo>=20);
    }


    /**
     * Para añadir 1 en el recurso.
     * @param recurso saber que recurso hay en esa casilla.
     */
    public void addValorNumero(Recurso recurso){
        if(recurso == Recurso.CARBON){
            carbon ++;
        }else if(recurso == Recurso.TRIGO){
            trigo ++;
        }else if(recurso == Recurso.MADERA){
            madera ++;
        }
    }

    /**
     * Getters & Setters
     */
    public int getMadera() {return madera;}

    public void setMadera(int madera) {this.madera = madera;}

    public int getCarbon() {return carbon;}

    public void setCarbon(int carbon) {this.carbon = carbon;}

    public int getTrigo() {return trigo;}

    public void setTrigo(int trigo) {this.trigo = trigo;}


}
