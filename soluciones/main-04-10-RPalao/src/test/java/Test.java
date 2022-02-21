import jugadores.Jugador;
import jugadores.Persona;
import models.Recurso;
import org.junit.jupiter.api.*;

public class Test {
    Jugador persona = new Persona();
    @BeforeEach
    void setup() {
        persona.setCarbon(10);
        persona.setMadera(15);
        persona.setTrigo(8);
    }


    @org.junit.jupiter.api.Test
    @DisplayName("Getter y Setter Jugadores")
    void testGetter(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(10, persona.getCarbon()),
                () -> Assertions.assertEquals(15, persona.getMadera()),
                () -> Assertions.assertEquals(8, persona.getTrigo())
        );
    }


    @org.junit.jupiter.api.Test
    @DisplayName("Jugadores addValor")
    void testAddValor(){
        persona.addValorNumero(Recurso.CARBON);

        Assertions.assertAll(
                () -> Assertions.assertEquals(11, persona.getCarbon())
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Jugadores todoMasVeinte")
    void testTodoMasVeinte(){
        persona.setCarbon(20);
        persona.setMadera(22);
        persona.setTrigo(25);

        Assertions.assertAll(
                () -> Assertions.assertTrue(persona.todoMasVeinte())
        );
    }


}
