package com.azahara;

public abstract class Persona {
    protected String apellido;
    protected int edad;



    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';


    }

    public Persona(String nombre, String apellido, int edad, String sexo) {
        this.apellido = apellido;
        this.edad = edad;

    }

    public Persona(){
        //random edad
        this.edad = Utiles.edadRandom();
        //random apellido
        this.apellido = Utiles.apellidoRandom();
    }
}
