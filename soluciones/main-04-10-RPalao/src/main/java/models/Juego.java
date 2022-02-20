package models;

import com.diogonunes.jcolor.Attribute;
import jugadores.Ordenador;
import jugadores.Persona;

import java.util.ArrayList;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Juego {
    //Instancia
    private static Juego instace = null;
    //Constantes
    private final int TAM_FILA=3;
    private final int TAM_COL=4;
    //Variables
    private StringBuilder resPersona;
    private StringBuilder resOrdenador;
    //Clases
    private final ArrayList<ArrayList<Casillas>> tableroJuego = new ArrayList<>();
    private final Persona personaje= new Persona();
    private final Ordenador ordenador = new Ordenador();




    /**
     * Instancia
     * @return siempre el mismo juego.
     */
    public static Juego getInstance() {
        if (instace == null) {
            instace = new Juego();
        }
        return instace;
    }


    /**
     * Constructor
     */
    public Juego() {
        iniciarTablero();
        mostrarCasillas();
        ocuparCasillas();
    }


    /**
     * Nos dice si ya se puede acabar el juego o no
     * @return boolean
     */
    public boolean acabarJuego() {
            if (personaje.todoMasVeinte()){
                System.out.println("\n Ha ganado la Persona");
            }else if(ordenador.todoMasVeinte()){
                System.out.println("\n Ha ganado el Ordenador");}

        return (personaje.todoMasVeinte() || ordenador.todoMasVeinte());
    }


    /**
     * Ocupar con jugadores las casillas.
     */
    private void ocuparCasillas() {
        int ocupadas =0;
        do {
            pedirCasillaPersona();
            pedirCasillaOrdenador();
            mostrarCasillas();
                ocupadas += 2;
        }while (ocupadas!=12);
    }


    /**
     * Añadir a casilla Ordenador.
     */
    private void pedirCasillaOrdenador() {
        int fila;
        int col;
        do {
            fila = (int) (Math.random()*3);
            col= (int) (Math.random()*4);
        }while (tableroJuego.get(fila).get(col).getJugadorCasilla()!=null);
        tableroJuego.get(fila).get(col).setJugadorCasilla(new Ordenador());
    }


    /**
     * Añadir a casilla Persona.
     */
    private void pedirCasillaPersona() {
        int fila;
        int col;
        do {
            fila = Input.pedirFila();
            col= Input.pedirCol();
        }while (tableroJuego.get(fila).get(col).getJugadorCasilla()!=null);
        tableroJuego.get(fila).get(col).setJugadorCasilla(new Persona());
    }


    /**
     * Inicializamos cada casilla con su número y su recurso.
     */
    private void iniciarTablero() {
        for (int i = 0; i < TAM_FILA; i++) {
            // Creamos cada columna, que es un nuevo arrayList
            ArrayList<Casillas> fila = new ArrayList<>();
            for (int j = 0; j < TAM_COL; j++) {
                fila.add(new Casillas());
            }
            tableroJuego.add(fila);
        }
    }


    /**
     * Comienzo del juego
     */
    public void comienzoJuego() {
        int dado = (int) (Math.random()*6+1);
        System.out.println(colorize("\nHa salido el " +dado+ " 🎲\n", Attribute.BRIGHT_MAGENTA_TEXT()));
        verResultados(dado);
    }


    /**
     * Mostrar los resultados de cada ronda.
     * @param dado para saber que dado ha salido.
     */
    private void verResultados(int dado) {
    resOrdenador = new StringBuilder("Ordenador ");
    resPersona = new StringBuilder("Persona ");

        for (ArrayList<Casillas> juego : tableroJuego) {
            for (Casillas casillas : juego) {
                if (casillas.getNumero() == dado) {
                    if (casillas.getJugadorCasilla() instanceof Persona) {
                        personaje.addValorNumero(casillas.getRecurso());
                        resPersona.append("1 item de ").append(casillas.getRecurso()).append(" ");
                    } else {
                        ordenador.addValorNumero(casillas.getRecurso());
                        resOrdenador.append("1 item de ").append(casillas.getRecurso()).append(" ");
                    }
                }
            }
        }
        mostrar();
    }


    /**
     * Saber que resultados de ordenador y persona mostramos.
     */
    private void mostrar() {
        if (resPersona.toString().equals("Persona ")){
            resPersona = new StringBuilder("Persona 0 items");
        }else if (resOrdenador.toString().equals("Ordenador ")){
            resOrdenador= new StringBuilder("Ordenador 0 items");
        }
        System.out.println(resPersona);
        System.out.println(resOrdenador);
    }


    /**
     * Enseñar las casillas.
     */
    private void mostrarCasillas() {
        for (ArrayList<Casillas> juego : tableroJuego) {
            for (Casillas casillas : juego) {
                System.out.print("[ " + casillas + " ] ");
            }
            System.out.println();
        }
    }

}
