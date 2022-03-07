package es.jeremyramos;

import es.jeremyramos.utils.Colors;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ButacaTest {

    private Butaca butaca = new Butaca(4,2,Enum.LIBRE);


    @BeforeEach
    void restButaca(){
        butaca = new Butaca(4,2,Enum.LIBRE);
    }

    @Test
    @Order(1)
    @DisplayName("Test Butaca NO Random")
    void testConstructor() {
        Butaca butaca = new Butaca(3, 5, Enum.LIBRE);

        Assertions.assertAll(
                () -> assertEquals(3, butaca.getFilas()),
                () -> assertEquals(5, butaca.getColumnas()),
                () -> assertEquals(Enum.LIBRE, butaca.getEstado())
        );


    }

    @Test
    @Order(2)
    void testGetFila(){
        assertEquals(3, butaca.getFilas());
        assertNotEquals(4, butaca.getFilas());
    }

    @Test
    @Order(2)
    void setGetFila(){
        butaca.setFilas(3);
        assertEquals(3, butaca.getFilas());
    }

    @Test
    @Order(3)
    void testGetColumna(){
        assertEquals(2, butaca.getColumnas());
        assertNotEquals(3, butaca.getColumnas());
    }

    @Test
    @Order(4)
    void testsetColumna(){
        butaca.setColumnas(7);
        assertEquals(7, butaca.getColumnas());
        assertNotEquals(8, butaca.getColumnas());
    }


    @Test
    @Order(5)
    void testGetEstado(){
        assertEquals(Enum.LIBRE, butaca.getEstado());
        assertNotEquals(Enum.OCUPADO, butaca.getEstado());

    }

    @Test
    @Order(6)
    void testsetEstado(){
        butaca.setEstado(Enum.OCUPADO);
        assertEquals(Enum.OCUPADO, butaca.getEstado());
        assertNotEquals(Enum.LIBRE, butaca.getEstado());
    }


    @Test
    @Order(7)
    @DisplayName("TestToString")

    void testToString(){
        Assertions.assertAll(

                () ->{
                    butaca.setEstado(Enum.LIBRE);
                    assertTrue(butaca.toString().contains(" " +  Colors.GREEN_BACKGROUND + "[✅]"+ Colors.reset + " "));
                },
                () ->{ butaca.setEstado(Enum.OCUPADO);
                    assertTrue(butaca.toString().contains(" "+ Colors.RED_BACKGROUND + "[\uD83D\uDEB6]" + Colors.reset + " "));
                },
                () ->{butaca.setEstado(Enum.RESERVADO);
                    assertTrue(butaca.toString().contains(" " +Colors.WHITE_BACKGROUND + Colors.YELLOW +"[⌛]" + Colors.reset + " "));
                }

        );
    }























}