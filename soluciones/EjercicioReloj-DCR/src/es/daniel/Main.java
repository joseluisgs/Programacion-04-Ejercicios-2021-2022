package es.daniel;

import es.daniel.models.Reloj;
import es.daniel.utils.Input;

public class Main {

    public static void main(String[] args) {
        int hour= setHour();
        int min= setMin();
        int second= setSeconds();
        String version= setVersion();

        Reloj reloj= new Reloj(min,hour,second,version);
        System.out.println(reloj);


    }
    public static int setMin(){
        int min=-1;
        System.out.println("Introduce los minutos:");
        do {
            min= Input.readInt();
            if(min<0 || min>=60) System.out.println("Los minutos deben estar entre [0-59]");
        }while(min <0 || min >=60);
        return min;
    }

    public static int setSeconds(){
        int second=-1;
        System.out.println("Introduce los segundos:");
        do {
            second= Input.readInt();
            if(second<0 || second>=60) System.out.println("Los segundos deben estar entre [0-59]");
        }while(second <0 || second >=60);
        return second;
    }
    public static int setHour(){
        int hour=-1;
        System.out.println("Introduce la hora:");
        do {
            hour= Input.readInt();
            if(hour<0 || hour>24) System.out.println("La hora debe estar entre [0-24]");
        }while(hour <0 || hour >24);
        return hour;
    }
    public static String setVersion(){
        String version;
        System.out.println("¿Que version es? [12-24]");
        do {
            version= Input.readString();
        }while (!version.equals("12") && !version.equals("24"));
        return version;
    }
}
