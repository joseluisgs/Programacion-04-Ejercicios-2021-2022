package es.ftoribio.dam;

import es.ftoribio.dam.models.Game;



public class Main {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        do {
            game.comienzoJuego();
        }while (!game.finishGame());
    }
}
