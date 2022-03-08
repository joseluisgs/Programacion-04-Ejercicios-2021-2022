package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Case Butaca Class")
class ButacaTest {
    private Butaca butaca = new Butaca(1,2);

    @BeforeEach
    void restAlumno() {
        butaca = new Butaca(1, 2);
    }

    @Test
    @Order(1)
    @DisplayName("Test Case Butaca Constructor")
    void testConstructor() {
        Butaca butaca = new Butaca(3,4);
        Assertions.assertAll(
                () -> assertEquals(3, butaca.getFilaSala()),
                () -> assertEquals(4, butaca.getColumnaSala())
        );
    }
    @Test
    void getFilaSala() {
            assertEquals(1, butaca.getFilaSala());
    }

    @Test
    void setFilaSala() {
        butaca.setFilaSala(3);
        assertEquals(3, butaca.getFilaSala());
    }

    @Test
    void getColumnaSala() {
        assertEquals(2, butaca.getColumnaSala());
    }

    @Test
    void setColumnaSala() {
        butaca.setColumnaSala(4);
        assertEquals(4, butaca.getColumnaSala());
    }

    @Test
    void getEstado() {
        assertEquals(Estado.LIBRE, butaca.getEstado());
        assertEquals(Estado.RESERVADA, butaca.getEstado());
        assertEquals(Estado.OCUPADA, butaca.getEstado());
    }

    @Test
    void setEstado() {
        butaca.setEstado(Estado.LIBRE);
        assertEquals(Estado.LIBRE, butaca.getEstado());
        butaca.setEstado(Estado.RESERVADA);
        assertEquals(Estado.RESERVADA, butaca.getEstado());
        butaca.setEstado(Estado.OCUPADA);
        assertEquals(Estado.OCUPADA, butaca.getEstado());
    }
    @Test
    void testToString() {
        Assertions.assertAll(
                () -> assertTrue(butaca.toString().contains(String.valueOf(butaca.getFilaSala()))),
                () -> assertTrue(butaca.toString().contains(String.valueOf(butaca.getColumnaSala()))),
                () -> assertTrue(butaca.toString().contains(String.valueOf(butaca.getEstado())))
        );
    }
}