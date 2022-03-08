package models;
import creators.JuegoCreator;
import utils.TextEdition;

public class Tienda {
    //Estado
    private static final int MAX_JUEGOS = 50;
    private int numJuegos = 0;

    private String nombre = "";
    private Juego[] juegos;

    //Constructores
    public Tienda() {
    }

    public Tienda(String nombre) {
        juegos = new Juego[MAX_JUEGOS];
        setNombre(nombre);
    }

    //CRUD
    public void initRandom() {
        numJuegos = 0;
        JuegoCreator creator = new JuegoCreator();
        for (int i = 0; i < MAX_JUEGOS; i++) {
            juegos[i] = creator.createRandom();
            numJuegos++;
        }
    }

    public void createJuego(Juego juego) {
        for (int i = 0; i < MAX_JUEGOS; i++) {
            if (juegos[i] == null) {
                juegos[i] = juego;
                numJuegos++;
                return;
            }
        }
        System.err.println("El juego no se pudo añadir porque supera el almacenamiento de la tienda. ");
    }

    public void update(Juego juego, int posicion) {
        if (posicion < MAX_JUEGOS && posicion >= 0) {
            if (juegos[posicion] != null) {
                juegos[posicion] = juego;
            } else {
                System.err.println("No hay juego en la posición " + posicion);
            }
        } else {
            System.err.println("No se puede actualizar el juego en la posición " + posicion + " porque excede el tamaño de la tienda");
        }
    }

    public void delete(int posicion) {
        if (posicion < MAX_JUEGOS && posicion >= 0) {
            if (juegos[posicion] != null) {
                juegos[posicion] = null;
            } else {
                System.err.println("No hay juego en la posición " + posicion);
            }
        } else {
            System.err.println("No se puede borrar el juego en la posición " + posicion + " porque excede el tamaño de la tienda");
        }
    }

    //Ordenación por precio
    public void orderByPrecioDesc() {
        Juego aux;
        // Utilizamos el método de ordenación burbuja
        for (int i = 0; i < MAX_JUEGOS; i++) {
            for (int j = i + 1; j < MAX_JUEGOS; j++) {
                if (juegos[i] != null && juegos[j] != null &&
                        juegos[i].getPrecio() < juegos[j].getPrecio()) {
                    aux = juegos[i];
                    juegos[i] = juegos[j];
                    juegos[j] = aux;
                }
            }
        }
    }

    public void orderByPrecioAsc() {
        Juego aux;
        // Utilizamos el método de ordenación burbuja
        for (int i = 0; i < MAX_JUEGOS; i++) {
            for (int j = i + 1; j < MAX_JUEGOS; j++) {
                if (juegos[i] != null && juegos[j] != null &&
                        juegos[i].getPrecio() > juegos[j].getPrecio()) {
                    aux = juegos[i];
                    juegos[i] = juegos[j];
                    juegos[j] = aux;
                }
            }
        }
    }

    //Ordenación por título
    public void orderByTituloAsc() {
        Juego aux;
        // Utilizamos el método de ordenación burbuja
        for (int i = 0; i < MAX_JUEGOS; i++) {
            for (int j = i + 1; j < MAX_JUEGOS; j++) {
                if (juegos[i] != null && juegos[j] != null &&
                        juegos[i].getTitulo().toLowerCase().compareTo(juegos[j].getTitulo().toLowerCase()) > 0) {
                    aux = juegos[i];
                    juegos[i] = juegos[j];
                    juegos[j] = aux;
                }
            }
        }
    }

    public void orderByTituloDesc() {
        Juego aux;
        // Utilizamos el método de ordenación burbuja
        for (int i = 0; i < MAX_JUEGOS; i++) {
            for (int j = i + 1; j < MAX_JUEGOS; j++) {
                if (juegos[i] != null && juegos[j] != null &&
                        juegos[i].getTitulo().toLowerCase().compareTo(juegos[j].getTitulo().toLowerCase()) < 0) {
                    aux = juegos[i];
                    juegos[i] = juegos[j];
                    juegos[j] = aux;
                }
            }
        }
    }

    //Ordenación por plataforma
    public void orderByPlataformaAsc() {
        Juego aux;
        // Utilizamos el método de ordenación burbuja
        for (int i = 0; i < MAX_JUEGOS; i++) {
            for (int j = i + 1; j < MAX_JUEGOS; j++) {
                if (juegos[i] != null && juegos[j] != null &&
                        juegos[i].getPlataforma().toLowerCase().compareTo(juegos[j].getPlataforma().toLowerCase()) > 0) {
                    aux = juegos[i];
                    juegos[i] = juegos[j];
                    juegos[j] = aux;
                }
            }
        }
    }

    public void orderByPlataformaDesc() {
        Juego aux;
        // Utilizamos el método de ordenación burbuja
        for (int i = 0; i < MAX_JUEGOS; i++) {
            for (int j = i + 1; j < MAX_JUEGOS; j++) {
                if (juegos[i] != null && juegos[j] != null &&
                        juegos[i].getPlataforma().toLowerCase().compareTo(juegos[j].getPlataforma().toLowerCase()) < 0) {
                    aux = juegos[i];
                    juegos[i] = juegos[j];
                    juegos[j] = aux;
                }
            }
        }
    }

    //Buscar por el título del juego
    public String findByTitulo(String titulo) {
        String result = "";
        for (int i = 0; i < MAX_JUEGOS; i++) {
            if (juegos[i] != null &&
                    juegos[i].getTitulo().equalsIgnoreCase(titulo.trim())) {
                result += (i + 1) + "- " + juegos[i].toString() + "\n";
            }
        }
        return result;
    }

    //Buscar por la plataforma del juego
    public String findByPlataforma(String plataforma) {
        String result = "";
        for (int i = 0; i < MAX_JUEGOS; i++) {
            if (juegos[i] != null &&
                    juegos[i].getPlataforma().equalsIgnoreCase(plataforma.trim())) {
                result += (i + 1) + "- " + juegos[i].toString() + "\n";
            }
        }
        return result;
    }

    //Setter & Getters
    public int getNumJuegos() {
        return numJuegos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Comportamiento
    public String stock() {
        String stock = "";
        if (numJuegos != 0) {
            for (int i = 0; i < juegos.length; i++) {
                if (juegos[i] != null) {
                    stock = ("Unidades de " + TextEdition.RED_BOLD_BRIGHT +"Mario Bro: " + TextEdition.RESET + contadorJuegos("Mario Bros") + "\n" +
                            "Unidades de " + TextEdition.GREEN_BOLD_BRIGHT + "Zelda: " + TextEdition.RESET + contadorJuegos("Zelda") + "\n" +
                            "Unidades de " + TextEdition.YELLOW_BOLD_BRIGHT + "Pokemon: " + TextEdition.RESET + contadorJuegos("Pokemon") + "\n" +
                            "Unidades de " + TextEdition.PURPLE_BOLD_BRIGHT + "Mario Kart: " + TextEdition.RESET + contadorJuegos("Mario Kart") + "\n" +
                            "Unidades de " + TextEdition.CYAN_BOLD_BRIGHT + "Hot Wheels: " + TextEdition.RESET + contadorJuegos("Hot Wheels") + "\n" +
                            "Unidades de Fortnite: " + contadorJuegos("Fortnite") + "\n");
                    }
            }
        }else {
            stock = "No hay juegos en la tienda";
        }
        return stock;
    }

    public String listado() {
        String listado = "";
        if (numJuegos != 0) {
            for (int i = 0; i < juegos.length; i++) {
                if (juegos[i] != null) {
                    listado += (i + 1) + "- " + juegos[i].toString() + "\n";
                }
            }
        } else {
            listado = "No hay juegos en la tienda";
        }
        return listado;
    }

    public String cantidadJuego(String titulo) {
        return "Unidades de " + titulo + ": " + contadorJuegos(titulo);
    }

    public String cantidadPlataforma(String plataforma) {
        return "Hay: " + contadorJuegos(plataforma)+ " juegos cuya plataforma ees " + plataforma + "." ;
    }

    public String porcentaje() {
        return ("Mario Bros: " + (calcularPorcentaje(contadorJuegos("Mario Bros"))+ " %\n" +
                "Zelda: " + calcularPorcentaje(contadorJuegos("Zelda")) + " %\n" +
                "Pokemon: " + calcularPorcentaje(contadorJuegos("Pokemon")) + " %\n" +
                "Mario Kart: " + calcularPorcentaje(contadorJuegos("Mario Kart")) + " %\n" +
                "Hot Wheels: " + calcularPorcentaje(contadorJuegos("Hot Wheels")) + " %\n" +
                "Fortnite: " + calcularPorcentaje(contadorJuegos("Fortnite")) + " %\n"));
    }

    private int contadorJuegos(String titulo){
        int contador = 0;
        for (int i = 0; i < MAX_JUEGOS; i++) {
            if (juegos[i] != null && juegos[i].getTitulo().equalsIgnoreCase(titulo.trim())){
                contador++;
            }
        }
        return contador;
    }

    private int contadorPlataformas(String plataforma){
        int contador = 0;
        for (int i = 0; i < MAX_JUEGOS; i++) {
            if (juegos[i] != null && juegos[i].getPlataforma().equalsIgnoreCase(plataforma.trim())){
                contador++;
            }
        }
        return contador;
    }
    public String juegosGratis(){
        int contador = 0;
        for (int i = 0; i < MAX_JUEGOS; i++) {
            if (juegos[i] != null && juegos[i].getPrecio() == 0.0f){
                contador++;
            }
        }
        return "Hay " + contador + " juegos gratis.";
    }

    public String juegosMasCarosQue(float precio){
        String result = "";
        System.out.print("Los juegos que hay en la tienda más caros de " + precio + "€ son: \n" );
        for (int i = 0; i < MAX_JUEGOS; i++) {
            if (juegos[i] != null && juegos[i].getPrecio() > precio){
                result += juegos[i].getTitulo() + ", " + juegos[i].getPrecio() + "€. \n";
            }
        }
        return result;
    }

    public String juegosMasBaratosQue(float precio){
        String result = "";
        System.out.print("Los juegos que hay en la tienda más barato de " + precio + "€ son: \n" );
        for (int i = 0; i < MAX_JUEGOS; i++) {
            if (juegos[i] != null && juegos[i].getPrecio() < precio){
                result += juegos[i].getTitulo() + ", " + juegos[i].getPrecio() + "€. \n";
            }
        }
        return result;
    }

    private float calcularPorcentaje(int cantidad){
        float porcentaje = (float)cantidad / (float)MAX_JUEGOS * 100.0f;
        return Math.round(porcentaje * 100.0f) / 100.0f;
    }
}
