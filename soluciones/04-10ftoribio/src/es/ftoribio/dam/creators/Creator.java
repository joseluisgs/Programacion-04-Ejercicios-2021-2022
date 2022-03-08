package es.ftoribio.dam.creators;

import es.ftoribio.dam.models.Resource;


public class Creator {
    public static int aleatoryNum(){

        return (int) (Math.random()*6+1);
    }

    public static Resource aleatoryResource(){
        Resource aux = null;
        int num = (int) (Math.random()*3+1);
        switch (num){
            case 1: aux = Resource.CARBON;
                break;
            case 2: aux = Resource.WOOD;
                break;
            case 3: aux = Resource.WHEAT;
                break;
        }
        return aux;
    }

}
