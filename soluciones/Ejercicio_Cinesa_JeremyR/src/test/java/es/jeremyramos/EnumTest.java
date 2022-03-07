package es.jeremyramos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnumTest  {

    @Test
    void testEstados(){
        Enum estado = Enum.LIBRE;
        Assertions.assertAll(
                () ->{
                    assertEquals(estado, Enum.LIBRE);
                },
                () ->{
                    assertNotEquals(estado, Enum.OCUPADO);
                },

                () ->{
                    assertNotEquals(estado, Enum.RESERVADO);
                }
        );

    }



}