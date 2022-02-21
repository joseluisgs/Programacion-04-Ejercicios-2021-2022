import models.Juego;

/**
 * @author Rocio PF
 * @version 1.0
 * github Rochiio
 * Conquitadores de Catán
 */

public class Main {

    public static void main(String[] args) {
        Juego juego = Juego.getInstance();
        do {
            juego.comienzoJuego();
        }while (!juego.acabarJuego());
    }
}
