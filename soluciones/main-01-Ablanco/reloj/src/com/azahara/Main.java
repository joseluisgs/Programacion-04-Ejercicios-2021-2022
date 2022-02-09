package com.azahara;

public class Main {

    /**
     * 1.- Ejercicio del reloj.
     * Realiza una clase reloj que sea capaz de almacenar la hora de un reloj (hora, minuto y segundo) OK
     * y el modo en el que se mostrará la hora (versión 12 24 horas). OK
     * Realiza los métodos habitualeS y alguno especial que permita recargar pila. OK
     */

    public static void main(String[] args) {
        Reloj r = new Reloj();
        boolean salir = false;

        do {

            //cargar pila
            r.cargarPila();

            //pedir la hora a guardar
            introducirHora(r);

            // pedir que devuleva la hora en 24 o en 12
            obtenerHora(r);

            //pedir salir
            salir = Utiles.preguntarSalir();


        }while(!salir);

    }

    /**
     * @Description  llama a los metodos necesarios para pedir la hora
     * @param r del reloj que queremos obtener la hora
     */
    private static void obtenerHora(Reloj r) {
        System.out.println("Vamos a obtener la hora guardada");
        int formato = Utiles.pedirFormato();
        r.getHora(formato);
    }

    /**
     * @Description  llama a los metodos necesarios para introducir la hora
     * @param r del reloj que queremos obtener la hora
     */
    private static void introducirHora(Reloj r) {
        System.out.println("Vamos a introducir una hora");
        int formato = Utiles.pedirFormato();
        int hora = Utiles.pedirHoras();
        int minutos = Utiles.pedirMinutos();
        int segundos = Utiles.pedirSegundos();
        r.setHora(formato, hora, minutos, segundos);
    }
}
