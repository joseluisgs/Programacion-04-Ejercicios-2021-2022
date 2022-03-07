package Ordenador;

import Ordenador.models.Aula;
import Ordenador.models.Ordenador;

public class Main {
    public static void main(String[] args) {
        Aula a = new Aula("DAM", 1, 20);
        System.out.println(a);

        System.out.println();

        Ordenador o1 = new Ordenador("i7", 8, 500);
        Ordenador o2 = new Ordenador("i5", 4, 250);
        System.out.println(o1);
        System.out.println(o2);
    }
}