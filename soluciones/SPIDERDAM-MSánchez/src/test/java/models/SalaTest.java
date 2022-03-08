package models;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class SalaTest {
    private Butaca[][] butacas = new Butaca[5][9];
    private Sala sala = new Sala();
    private Butaca butaca = new Butaca();
    private Ticket[] factura = new Ticket[45];
    private Ticket ticket = new Ticket();
    @Test
    void inicializarSalaButacasLibres() {
        assertAll(
                //() -> assertEquals(sala.inicializarSalaButacasLibres(), butacas[0][0] = butaca.setEstado(Estado.LIBRE)),
                //() -> assertNotEquals(sala.inicializarSalaButacasLibres(), butacas[0][0] = butaca.setEstado(Estado.OCUPADA),
                //() -> assertNotEquals(sala.inicializarSalaButacasLibres(), butacas[0][0] = butaca.setEstado(Estado.RESERVADA))
        );
        //assertEquals(butacas, inicializarSalaButacasLibres());
    }

    @Test
    void crearButaca() {
        assertAll(
                //() -> assertEquals(sala.crearButaca(), butacas[0][0] = butaca),
                //() -> assertNotEquals(sala.crearButaca(), butacas[0][0] = null)
        );
    }

    @Test
    void compra() {
        assertAll(
                //() -> assertEquals(sala.compra(), butaca.setEstado(Estado.OCUPADA)),
                //() -> assertNotEquals(sala.compra(), butaca.setEstado(Estado.LIBRE)),
                //() -> assertNotEquals(sala.compra(), butaca.setEstado(Estado.RESERVADA))
        );
    }

    @Test
    void reserva() {
        assertAll(
            //() -> assertEquals(sala.reserva(), butaca.setEstado(Estado.RESERVADA)),
            //() -> assertNotEquals(sala.reserva(), butaca.setEstado(Estado.LIBRE)),
            //() -> assertNotEquals(sala.reserva(), butaca.setEstado(Estado.OCUPADA))
        );
    }

    @Test
    void confirmar() {
        butaca.setEstado(Estado.RESERVADA);
        Butaca butaca1 = new Butaca();
        butaca1.setEstado(Estado.OCUPADA);
        assertAll(
                //() -> assertEquals(sala.confirmar(), butaca.setEstado(Estado.OCUPADA)),
                //() -> assertEquals(sala.confirmar(), butaca1.setEstado(Estado.OCUPADA)),
                //() -> assertNotEquals(sala.confirmar(), butaca.setEstado(Estado.LIBRE)),
                //() -> assertNotEquals(sala.confirmar(), butaca.setEstado(Estado.RESERVADA)),
                //() -> assertNotEquals(sala.confirmar(), butaca1.setEstado(Estado.LIBRE))
                //() -> assertNotEquals(sala.confirmar(), butaca1.setEstado(Estado.RESERVADA))
        );
    }

    @Test
    void anular() {
        butaca.setEstado(Estado.RESERVADA);
        Butaca butaca1 = new Butaca();
        butaca1.setEstado(Estado.OCUPADA);
        assertAll(
                //() -> assertEquals(sala.confirmar(), butaca.setEstado(Estado.LIBRE)),
                //() -> assertEquals(sala.confirmar(), butaca1.setEstado(Estado.LIBRE)),
                //() -> assertNotEquals(sala.confirmar(), butaca.setEstado(Estado.OCUPADA)),
                //() -> assertNotEquals(sala.confirmar(), butaca.setEstado(Estado.RESERVADA)),
                //() -> assertNotEquals(sala.confirmar(), butaca1.setEstado(Estado.OCUPADA))
                //() -> assertNotEquals(sala.confirmar(), butaca1.setEstado(Estado.RESERVADA))
        );
    }

    @Test
    void crearTicket() {
        sala.crearButaca();
        sala.inicializarSalaButacasLibres();
        sala.compra();
        assertAll(
                //() -> assertEquals(sala.crearTicket(), factura[0] == ticket),
                //() -> assertNotEquals(sala.crearTicket(), factura[0] == null)
        );
    }

    @Test
    void inicializarTicket() {
        sala.crearButaca();
        sala.inicializarSalaButacasLibres();
        sala.compra();
        sala.almacenarTicket();
        assertAll(
                //() -> assertEquals(sala.inicializarTicket(0,0), factura[0].getFila() == 0 ),
                //() -> assertNotEquals(sala.inicializarTicket(0,0), factura[0].getFila() == 1 ),
                //() -> assertNotEquals(sala.inicializarTicket(0,0), factura[0].getFila() == null)
        );
    }

    @Test
    void eliminarTicket() {
        sala.almacenarTicket();
        assertAll(
                //() -> assertEquals(sala.eliminarTicket(0), factura[0] == null),
                //() -> assertNotEquals(sala.eliminarTicket(0), factura[0] == ticket)
        );
    }

    @Test
    void buscarPorFecha() {
        Instant instante = Instant.now();
        Instant instante1 = Instant.now();
        assertAll(
                //() -> assertEquals(sala.buscarPorFecha(instante), ticket.getInstante()== instante),
                //() -> assertNotEquals(sala.buscarPorFecha(instante), ticket.getInstante()== instante1)
        );
    }

    @Test
    void buscarPorButaca() {
        assertAll(
                //() -> assertEquals(sala.buscarPorButaca(1,1), ticket.getFila == 1 && ticket.getColumna == 1),
                //() -> assertNotEquals(sala.buscarPorButaca(1,1), ticket.getFila == 2 && ticket.getColumna == 3)
        );
    }

    @Test
    void ordenarAntiguoAReciente() {
        assertAll(
                () -> assertEquals(factura[1].getInstante().isBefore(factura[2].getInstante()), factura[2].getInstante()),
                () -> assertNotEquals(factura[1].getInstante().isBefore(factura[2].getInstante()), factura[2].getInstante())
        );
    }
}