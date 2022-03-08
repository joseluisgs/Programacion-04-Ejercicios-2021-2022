package models;
import org.testng.annotations.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Case Juego Class")
public class JuegoTest {
    private Juego juego = new Juego("Zelda", "Switch", 34.56f);

    @BeforeEach
    void testJuego() {
        juego = new Juego("Zelda", "Switch", 34.56f);
    }

    @Test
    @Order(1)
    @DisplayName("Test Case Juego Constructor")
    void testConstructor() {
        Juego juego = new Juego("Mario Bros", "Switch", 25.2f);
        Assertions.assertAll(
                () -> assertEquals("Mario Bros", juego.getTitulo()),
                () -> assertEquals("Switch", juego.getPlataforma()),
                () -> assertEquals(25.2f, juego.getPrecio())
        );
    }

    @Test

    void testGetTitulo() {
        assertEquals("Zelda", juego.getTitulo());
    }

    @Test
    void testSetTitulo() {
        juego.setTitulo("Mario Bros");
        assertEquals("Mario Bros", juego.getTitulo());
    }

    @Test
    void testGetPlataforma() {
        assertEquals("Switch", juego.getPlataforma());
    }

    @Test
    void testSetPlataforma() {
        juego.setTitulo("Switch");
        assertEquals("PC", juego.getPlataforma());
        assertEquals("XBOX", juego.getPlataforma());
        assertEquals("Play", juego.getPlataforma());
        assertEquals("Switch", juego.getPlataforma());
        assertNotEquals("Hola", juego.getPlataforma());
    }

    @Test
    void testGetPrecio() {
        assertEquals(81.25f, juego.getPrecio());
    }

    @Test
    void testSetPrecio() {
        Assertions.assertAll(
                () -> {
                    juego.setPrecio(51.2f);
                    assertEquals(51.20f, juego.getPrecio());
                },
                () -> {
                    // Todos los redondeos son a dos decimales
                    juego.setPrecio(51.256f);
                    assertEquals(51.26f, juego.getPrecio());
                },
                () -> {
                    juego.setPrecio(51.255f);
                    assertEquals(51.26f, juego.getPrecio());
                },
                () -> {
                    juego.setPrecio(51.254f);
                    assertEquals(51.25, juego.getPrecio());
                }
        );
    }
    @Test
    void setExceptions() {
        // Excepcion 0
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            juego.setPrecio(-1);
        }, "IllegalArgumentException expected");

        assertTrue(thrown.getMessage().contains("0"));

        // Excepcion mayor de 200
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Codigo que puede lanzarlo
            juego.setPrecio(201);
        }, "IllegalArgumentException expected");

        assertTrue(thrown.getMessage().contains("200"));
    }

    @Test
    void testToString() {
        Assertions.assertAll(
                () -> assertTrue(juego.toString().contains(juego.getTitulo())),
                () -> assertTrue(juego.toString().contains(juego.getPlataforma())),
                () -> assertTrue(juego.toString().contains(String.valueOf(juego.getPrecio())))
        );
    }
}
