package creators;

import models.Estado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlarEntradaTest {
    private ControlarEntrada test = new ControlarEntrada();

    @Test
    void createButacaLibre() {
        assertAll(
                () -> assertEquals(test.createButacaLibre(1,1), Estado.LIBRE),
                () -> assertNotEquals(test.createButacaLibre(1,1), Estado.RESERVADA)
        );
    }

    @Test
    void createButacaReservada() {
        assertAll(
                () -> assertEquals(test.createButacaLibre(1,1), Estado.RESERVADA),
                () -> assertNotEquals(test.createButacaLibre(1,1), Estado.LIBRE)
        );
    }

    @Test
    void createButacaOcupada() {
        assertAll(
                () -> assertEquals(test.createButacaLibre(1,1), Estado.OCUPADA),
                () -> assertNotEquals(test.createButacaLibre(1,1), Estado.RESERVADA)
        );
    }

    @Test
    void leerColumna() {
        assertAll(
                () -> assertEquals(test.leerColumna(), 4),
                () -> assertNotEquals(test.leerColumna(), 0),
                () -> assertNotEquals(test.leerColumna(),10)
        );
    }

    @Test
    void leerFila() {
        assertAll(
                () -> assertEquals(test.leerFila(), "a"),
                () -> assertNotEquals(test.leerFila(), "y"),
                () -> assertNotEquals(test.leerFila(),1)
        );
    }

    @Test
    void reasignarFila() {
        assertAll(
                () -> assertEquals(test.reasignarFila("A"),0),
                () -> assertEquals(test.reasignarFila(1),"A"),
                () -> assertNotEquals(test.reasignarFila("B"),0),
                () -> assertNotEquals(test.reasignarFila(2),"Y"),
                () -> assertEquals(test.reasignarFila(10),"-"),
                () -> assertEquals(test.reasignarFila("Y"),-1)
        );
    }
}