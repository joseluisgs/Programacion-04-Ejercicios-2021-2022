package utils;

import models.Sala;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Case ControlarMenu Class")
class ControlarMenuTest {
    private Sala sala = new Sala();
    private ControlarMenu controlar = new ControlarMenu();

    @Test
    void controlarEntradas() {
        int entrada = 3;
        assertEquals(false,controlar.controlarEntradas(3,false, sala));
        int entrada1 = 7;
        assertEquals(true,controlar.controlarEntradas(7,true, sala));
    }

}