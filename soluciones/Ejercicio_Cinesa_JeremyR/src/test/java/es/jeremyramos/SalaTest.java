package es.jeremyramos;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class SalaTest {
        Butaca[][] butacas = new Butaca[5][9];
        Sala salaCine = new Sala(60, 30, 10, 5);


        @BeforeEach
        void restSalaCine(){
            Sala salaCine = new Sala(60, 30, 10, 5);
        }



        @Test
        @Order(1)
        void testGetLibres(){
            assertEquals(30, salaCine.getLibres());
            assertNotEquals(31,salaCine.getLibres());
        }

        @Test
        @Order(2)
        void testSetLibres(){
            salaCine.setLibres(30);
            assertEquals(30, salaCine.getLibres());
            assertNotEquals(31,salaCine.getLibres());
        }

        @Test
        @Order(3)
        void testGetRecaudacion(){
            assertEquals(60, salaCine.getRecaudacion());
            assertNotEquals(64,salaCine.getRecaudacion());
        }

        @Test
        @Order(4)
        void testGetOcupadas(){
            assertEquals(10,salaCine.getOcupadas());
            assertNotEquals(11,salaCine.getOcupadas());
        }

        @Test
        @Order(5)
        void testSetOcupadas(){
            salaCine.setOcupadas(37);
            assertEquals(37,salaCine.getOcupadas());
            assertNotEquals(45,salaCine.getOcupadas());
        }

        @Test
        @Order(6)
        void testGetReservadas(){
            assertEquals(5,salaCine.getReservadas());
            assertNotEquals(17,salaCine.getReservadas());
        }

        @Test
        @Order(7)
        void testSetReservadas(){
            salaCine.setReservadas(8);
            assertEquals(8,salaCine.getReservadas());
            assertNotEquals(6,salaCine.getReservadas());
        }

        @Test
        @Order(8)
        void testSacarColumna(){

            Assertions.assertAll(
                    () ->{ String opcion = "A2";
                            assertEquals(1, salaCine.sacarColumna(opcion));
                    },
                    () ->{ String opcion = "A9";
                        assertEquals(8, salaCine.sacarColumna(opcion));
                    },

                    () ->{ String opcion = "A3";
                        assertNotEquals(7, salaCine.sacarColumna(opcion));
                    }
            );

        }

        @Test
        @Order(9)
        void testSacarFila(){

            Assertions.assertAll(
                    () ->{ String opcion = "A2";
                        assertEquals(0, salaCine.sacarFila(opcion));
                    },
                    () ->{ String opcion = "C9";
                        assertEquals(2, salaCine.sacarFila(opcion));
                    },

                    () ->{ String opcion = "E3";
                        assertNotEquals(3, salaCine.sacarFila(opcion));
                    }
            );

    }


            @Test
            @Order(10)
            void testComprobarFila(){
                    String opcion = "C2";
                    assertTrue(salaCine.comprobarFila(opcion));

            }

            @Test
            @Order(11)
            void testComprobarColumna(){
                String opcion = "A2";
                assertTrue(salaCine.comprbarColumna(opcion));

            }









}