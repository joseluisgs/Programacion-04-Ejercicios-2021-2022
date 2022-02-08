package org.example;


import org.junit.jupiter.api.*;
import utils.Input;


import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Cuenta Bancaria")

public class AppTest {

    @Test
    @DisplayName("Input isAreAllLetters (PEDIR NOMBRE)")
    @Order(1)
    void testIsAreAllLetters(){
        String ok1="Maria de las Nieves";
        String ok2="Rocio";
        String bad1="Pepe 45876 76 7bebe";
        String bad2="Pepepep83465645666";

        Assertions.assertAll(
                () -> assertTrue(Input.isAllAreLetters(ok1)),
                () -> assertTrue(Input.isAllAreLetters(ok2)),
                () -> assertFalse(Input.isAllAreLetters(bad1)),
                () -> assertFalse(Input.isAllAreLetters(bad2))
        );
    }


    @Test
    @DisplayName("Input isAllCorrect (DNI)")
    @Order(2)
    void testIsAllCorrect(){
        String ok1="02748649B";
        String bad1="123456789";
        String bad2="12345678";
        String bad3="1234567891";

        Assertions.assertAll(
                () -> assertTrue(Input.isAllCorrect(ok1)),
                () -> assertFalse(Input.isAllCorrect(bad1)),
                () -> assertFalse(Input.isAllCorrect(bad2)),
                () -> assertFalse(Input.isAllCorrect(bad3))

        );
    }


    @Test
    @DisplayName("Input isCorrectCharacters (Numero de Cuenta)")
    @Order(3)
    void testIsCorrectCharacters(){
        String ok1="ES1234567891234567891234";
        String bad1="ES123456789123456789123";
        String bad2="ES12345678912345678912345";
        String bad3="111234567891234567891234";

        Assertions.assertAll(
                () -> assertTrue(Input.isCorrectCharacters(ok1)),
                () -> assertFalse(Input.isCorrectCharacters(bad1)),
                () -> assertFalse(Input.isCorrectCharacters(bad2)),
                () -> assertFalse(Input.isCorrectCharacters(bad3))

        );
    }


    @Test
    @DisplayName("Input isAllDigits (Numero de Teléfono)")
    @Order(3)
    void testIsAllDigits(){
        String ok1="213547987";
        String bad1="qweasddfg";
        String bad2="32165498";
        String bad3="3215469787";

        Assertions.assertAll(
                () -> assertTrue(Input.isAllDigits(ok1)),
                () -> assertFalse(Input.isAllDigits(bad1)),
                () -> assertFalse(Input.isAllDigits(bad2)),
                () -> assertFalse(Input.isAllDigits(bad3))

        );
    }










}
