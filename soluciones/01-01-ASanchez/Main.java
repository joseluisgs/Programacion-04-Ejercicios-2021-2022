package Reloj;

import Reloj.models.Reloj;

public class Main {
    public static void main(String[] args) {
        Reloj r = new Reloj(22, 30, 27);

        System.out.println();
        System.out.println(r);
        System.out.println(r.getHora(true) + " · Formato 24h.");
        System.out.println(r.getHora(false) + " · Formato 12h.");

        r.recargarPila();
    }
}
