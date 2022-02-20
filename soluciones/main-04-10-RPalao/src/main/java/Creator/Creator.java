package Creator;

import models.Recurso;

public class Creator {
    public static int numeroAleatorio(){
        return (int) (Math.random()*6+1);
    }

    public static Recurso recursoAleatorio(){
        Recurso aux = null;
        int num = (int) (Math.random()*3+1);
        switch (num){
            case 1: aux = Recurso.CARBON;
                break;
            case 2: aux = Recurso.MADERA;
                break;
            case 3: aux = Recurso.TRIGO;
                break;
        }
        return aux;
    }

}
