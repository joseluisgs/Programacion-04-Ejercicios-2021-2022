import models.Tienda;

public class App {
    public static void main(String[] args) {
        /*
        Juego juegoConsola = new Juego();
        juegoConsola = JuegoCreator.createFromTerminal();
        System.out.println("------------------ Juego por consola ------------------");
        System.out.println(juegoConsola.toString());

        System.out.println("------------------ Juego random ------------------");
        Juego juegoRandom = new Juego();
        juegoRandom = JuegoCreator.createRandom();
        System.out.println(juegoRandom.toString());
        */

        Tienda tienda = new Tienda("GAME");
        tienda.initRandom();
        System.out.println("------------------ STOCK DE LA TIENDA ------------------");
        System.out.println(tienda.stock());
        System.out.println("------------------ LISTA DE JUEGOS DE LA TIENDA ------------------");
        System.out.println(tienda.listado());
        System.out.println("------------------ PORCENTAJE DE CADA JUEGO QUE HAY LA TIENDA ------------------");
        System.out.println(tienda.porcentaje());
        System.out.println("------------------ UNIDADES DEL JUEGO INTRODUCIDO EN LA TIENDA ------------------");
        System.out.println(tienda.cantidadJuego("Mario Bros"));
        System.out.println("------------------ JUEGOS ORDENADOS POR PRECIO ASCENDENTE ------------------");
        tienda.orderByPrecioAsc();
        System.out.println(tienda.listado());
        System.out.println("------------------ JUEGOS ORDENADOS POR PRECIO DESCENDENTE ------------------");
        tienda.orderByPrecioDesc();
        System.out.println(tienda.listado());
        System.out.println("------------------ JUEGOS ORDENADOS POR TÍTULO ASCENDENTE ------------------");
        tienda.orderByTituloAsc();
        System.out.println(tienda.listado());
        System.out.println("------------------ JUEGOS ORDENADOS POR TÍTULO DESCENDENTE ------------------");
        tienda.orderByTituloDesc();
        System.out.println(tienda.listado());
        System.out.println("------------------ JUEGOS ORDENADOS POR PLATAFORMA ASCENDENTE ------------------");
        tienda.orderByPlataformaAsc();
        System.out.println(tienda.listado());
        System.out.println("------------------ JUEGOS ORDENADOS POR PLATAFORMA DESCENDENTE ------------------");
        tienda.orderByPlataformaDesc();
        System.out.println(tienda.listado());
        System.out.println("------------------ BÚSQUEDA POR TÍTULO ------------------");
        System.out.println(tienda.findByTitulo("Zelda"));
        System.out.println("------------------ BÚSQUEDA POR PLATAFORMA ------------------");
        System.out.println(tienda.findByPlataforma("XBOX"));
        System.out.println(tienda.juegosMasCarosQue(50));
        System.out.println(tienda.juegosMasBaratosQue(50));
        System.out.println(tienda.juegosGratis());

    }
}
