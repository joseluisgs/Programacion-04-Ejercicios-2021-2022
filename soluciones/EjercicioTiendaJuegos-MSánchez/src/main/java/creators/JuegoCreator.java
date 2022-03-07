package creators;
import utils.Input;
import models.Juego;

public class JuegoCreator {
    /**
     * Crea un alumno leyendo los datos por consola
     */
    public static Juego createFromTerminal() {
        String titulo = leerTitulo();
        String plataforma = leerPlataforma();
        float precio = leerPrecio();

        Juego juego = new Juego(titulo, plataforma, precio);

        return juego;
    }

    /**
     * Crea alumnos con datos aleatorios para automatizar
     */
    public static Juego createRandom() {
        String titulo = randomTitulo();
        String plataforma = randomPlataforma();
        float precio = randomPrecio();

        Juego juego = new Juego(titulo, plataforma, precio);

        return juego;
    }

    /**
     * Genera un título aleatorio
     *
     * @return título aleatorio
     */
    private static String randomTitulo() {
        String[] lista = {"Mario Bros", "Zelda", "Pokemon", "Mario Kart", "Hot Wheels", "Fortnite"};
        int pos = (int) (Math.random() * lista.length);
        return lista[pos];
    }

    /**
     * Genera una plataforma aleatoria
     *
     * @return plataforma aleatoria
     */
    private static String randomPlataforma() {
        int numeroAleatorio = (int) (Math.random() * 100) + 1;
        String plataforma = "";

        if(numeroAleatorio <= 20){
            plataforma = "XBOX";
        }else if(numeroAleatorio > 20 && numeroAleatorio <= 60){
            plataforma = "Play";
        }else if(numeroAleatorio > 60 && numeroAleatorio <= 90){
            plataforma = "PC";
        }else if(numeroAleatorio > 90 && numeroAleatorio <= 100){
            plataforma = "Switch";
        }
        return plataforma;
    }

    /**
     * Genera un precio aleatoria
     *
     * @return precio aleatoria
     */
    private static float randomPrecio() {
        int numeroAleatorio = (int) (Math.random() * 100) + 1;
        float precio = 0f;

        if(numeroAleatorio <= 10){
            precio = 0f;
        }else if(numeroAleatorio > 10 && numeroAleatorio <= 50){
            precio = (float) (Math.random()* (40-20+1) + 20);
        }else if(numeroAleatorio > 50 && numeroAleatorio <= 100){
            precio = (float) (Math.random()* (100-50+1) + 50);
        }
        return precio;

    }

    /**
     * Lee un titulo por consola
     */
    private static String leerTitulo() {
        Input input = new Input();
        boolean ok = false;
        String titulo = "";
        do {
            System.out.println("Introduce el titulo del juego: ");
            titulo = input.readLine();
            if (titulo.length() == 0 || titulo.length() >= 100) {
                System.out.println("El título debe tener entre 1 y 99 caracteres.");
            } else {
                ok = true;
            }
        } while (!ok);
        return titulo;
    }

    /**
     * Lee una plataforma. Puede ser PX, XBOX, Play o Switch.
     */
    private static String leerPlataforma() {
        Input input = new Input();
        boolean ok = false;
        String plataforma = "";
        do {
            System.out.println("Introduce la plataforma del juego: ");
            plataforma = input.readLine();
            if (!plataforma.equalsIgnoreCase("PC") && !plataforma.equalsIgnoreCase("XBOX") && !plataforma.equalsIgnoreCase("Play") && !plataforma.equalsIgnoreCase("Switch")) {
                System.out.println("Error. La plataforma debe ser: PC, XBOX, Play o Switch. ");
            } else {
                ok = true;
            }
        } while (!ok);
        return plataforma;
    }

    /**
     * Lee un precio por consola entre 0 y 200
     */
    private static float leerPrecio() {
        Input input = new Input();
        boolean ok = false;
        float precio = 0;
        do {
            System.out.println("Introduce el precio del juego: ");
            precio = input.readFloat();
            if (precio < 0.0f || precio > 200.0f) {
                System.out.println("Error. El precio debe de estar comprendido entre 0.00€ y 200.00€.");
            } else {
                ok = true;
            }
        } while (!ok);
        return precio;
    }

}
