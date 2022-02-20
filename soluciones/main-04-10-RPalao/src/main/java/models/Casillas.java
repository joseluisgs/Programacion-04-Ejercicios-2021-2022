package models;

import Creator.Creator;
import com.diogonunes.jcolor.Attribute;
import jugadores.Jugador;
import jugadores.Ordenador;
import jugadores.Persona;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Casillas {
    private final int numero;
    private final Recurso recurso;
    private Jugador jugadorCasilla;


    /**
     * Constructor
     */
    public Casillas() {
        numero = Creator.numeroAleatorio();
        recurso = Creator.recursoAleatorio();
        jugadorCasilla = null;
    }


    /**
     * Getter & Setter Jugador
     */
    public void setJugadorCasilla(Jugador jugadorCasilla) {this.jugadorCasilla = jugadorCasilla;}

    public Jugador getJugadorCasilla() {return jugadorCasilla;}

    public int getNumero() {
        return numero;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (jugadorCasilla == null) {
            result.append(recurso).append(" ").append(numero);
        }else if (jugadorCasilla instanceof Persona){
            result.append(recurso).append(" ").append(colorize("Persona", Attribute.BRIGHT_CYAN_TEXT())).append(" ").append(numero);
        }else if (jugadorCasilla instanceof Ordenador){
            result.append(recurso).append(" ").append(colorize("Ordenador", Attribute.BRIGHT_GREEN_TEXT())).append(" ").append(numero);
        }
        return result.toString();
    }
}
