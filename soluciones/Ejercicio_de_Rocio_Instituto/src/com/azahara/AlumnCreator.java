package com.azahara;

public class AlumnCreator {
    //responsabilidad unica

    public static  Persona alumnCreator(){
        int aleatorio = ((int)(Math.random()*101));
        if (aleatorio>=60){
            return new Alumna();
        }else{
            return new Alumno();
        }
    }
}
