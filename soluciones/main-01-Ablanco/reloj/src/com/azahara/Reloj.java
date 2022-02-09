package com.azahara;

public class Reloj {
    public static int hora= 0;
    public static int minutos = 0;
    public static int segundos = 0;



    /**
     *
     * @param formato un int con el cual devolveremos el formato de nuestra hora
     * @return hora en formato 12 o 24 o si no es correcto el formato -1
     */
    public  void getHora(int formato) {
        if (formato==12){
            System.out.println("tu hora en formato 12 es: "+Reloj.hora%12);
            System.out.println(" Minutos: " + Reloj.minutos );
            System.out.println(" Segundo: "+Reloj.segundos);

        } else if (formato==24){
            System.out.println(" Tu hora en formato 24 es: "+Reloj.hora );
            System.out.println(" Minutos: " + Reloj.minutos );
            System.out.println(" Segundo: "+Reloj.segundos);
        }else{
            System.out.println("tu formato de hora no es correcto 12/24");
        }

    }

    /**
     *
     * @param formato el formato que queremos guardar la hora a 12 o 24 h
     * @param hora que hora queremos guardar
     */
    public  void setHora(int formato , int hora, int minutos, int segundos) {
        boolean ok = Utiles.comprobarHoraCorrecta(formato, hora);
        if (ok){
           Reloj.hora =hora;
           Reloj.minutos =minutos;
           Reloj.segundos =segundos;

            System.out.println("tu hora se ha guardado correctamente");
        }else{
            System.out.println("tu hora no es correcta ");
        }

    }

    /**
     * @Description metodo que dice que carga pila pero no hace na =)
     */
    public void cargarPila() {
        System.out.println(" Reloj Cargando ....");
    }
}

