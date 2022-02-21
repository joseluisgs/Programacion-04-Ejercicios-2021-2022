package com.azahara;
import java.util.ArrayList;

public class Clase {
    ArrayList<Persona> personas;

    public Clase() {
        this.personas = new ArrayList<Persona>();
        for (int i = 0; i < 15; i++) {
            personas.add(AlumnCreator.alumnCreator());
        }

    }

    @Override
    public String toString() {
        return "Clase{" +
                "Matriculados=" + personas +
                '}';
    }

    public int obtenerAlumnos(){
        int alumnos = 0;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i) instanceof Alumno) {
                alumnos++;
            }
        }
        return alumnos;
    }

    public int obtenerAlumnas(){
        int alumnas = 0;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i) instanceof Alumna) {
                alumnas++;
            }
        }
        return alumnas;
    }

    public void ordenarClase() {
        //ordenamos por edad

        Persona i;
        for (int j = 0; j < personas.size()-1; j++) {
            for (int k = j+1; k < personas.size(); k++) {
                if ((personas.get(j).getEdad())<(personas.get(k).getEdad())){
                    i = personas.get(k);
                    personas.set(k,personas.get(j));
                    personas.set(j,i);
                }
            }
        }

    }

    public void imprimirla() {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i));
        }
    }
}
