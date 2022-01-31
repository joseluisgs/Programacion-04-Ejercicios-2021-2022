import Models.Butacas;
import Models.Estado;

import Models.Sala;
import Models.Ticket;
import org.junit.jupiter.api.*;
import utils.Input;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test SpiderDam")

public class Test {

    private Sala sala;
    private final Butacas[][] butaca = new Butacas[2][2];
    private final Ticket[] tickets = new Ticket[4];


    @BeforeEach
    void butacasAndTickets(){
        sala = Sala.getInstance();
        butaca[0][0]= new Butacas(Estado.COMPRADO);
        butaca[0][1]= new Butacas(Estado.COMPRADO);
        butaca [1][0] = new Butacas(Estado.RESERVADO);
        butaca [1][1]= new Butacas(Estado.LIBRE);
        tickets[0]= new Ticket(0,0,butaca[0][0]);
        tickets[1]= new Ticket(0,1,butaca[0][1]);
        tickets[2]= new Ticket(1,0,butaca[1][0]);
        tickets[3]= new Ticket(1,1,butaca[1][1]);

    }



    @org.junit.jupiter.api.Test
    @Order(1)
    @DisplayName("test get id")
    void testGetId(){
        Ticket tickets = new Ticket(1,1,butaca[0][0]);
        Assertions.assertAll(
                () -> assertEquals(5,tickets.getId())
        );
    }


    @org.junit.jupiter.api.Test
    @Order(2)
    @DisplayName("test get butacas")
    void testGetButacas() {
        Assertions.assertAll(
                () -> assertEquals(45,sala.getButacasLibres()),
                () -> assertEquals(0,sala.getButacasReservadas()),
                () -> assertEquals(0,sala.getButacasCompradas())
        );
    }


    @org.junit.jupiter.api.Test
    @Order(3)
    @DisplayName("test para los porcentajes")
    void testPorcentajesEntradas(){
        int ok= 20;
        int ok2 = 15;
        int ok3 = 32;
        Assertions.assertAll(
                () -> assertEquals(44.44f,sala.porcentajesEntradas(ok)),
                () -> assertEquals(33.33f,sala.porcentajesEntradas(ok2)),
                () -> assertEquals(71.11f,sala.porcentajesEntradas(ok3))
        );
    }


    @org.junit.jupiter.api.Test
    @Order(4)
    @DisplayName("test input char numero")
    void testNumberOfFila(){
        String uno= "A";
        String dos = "B";
        String tres = "C";
        String cuatro = "D";
        String cinco = "E";

        Assertions.assertAll(
                () -> assertEquals(0,Input.numberOfFila(uno)),
                () -> assertEquals(1,Input.numberOfFila(dos)),
                () -> assertEquals(2,Input.numberOfFila(tres)),
                () -> assertEquals(3,Input.numberOfFila(cuatro)),
                () -> assertEquals(4,Input.numberOfFila(cinco))
        );
    }


    @org.junit.jupiter.api.Test
    @Order(5)
    @DisplayName("test get estado de butacas")
    void testGetEstado(){
        Assertions.assertAll(
                () -> assertEquals(Estado.COMPRADO,butaca[0][0].getEstado()),
                () -> assertEquals(Estado.COMPRADO,butaca[0][1].getEstado()),
                () -> assertEquals(Estado.RESERVADO,butaca[1][0].getEstado()),
                () -> assertEquals(Estado.LIBRE,butaca[1][1].getEstado())
        );
    }


    @org.junit.jupiter.api.Test
    @Order(6)
    @DisplayName("test get Ticket")
    void testGetTickets() {
        Assertions.assertAll(
                () -> assertEquals(0,tickets[0].getFilaButaca()),
                () -> assertEquals(0,tickets[0].getColumnaButaca()),
                () -> assertEquals(0,tickets[1].getFilaButaca()),
                () -> assertEquals(1,tickets[1].getColumnaButaca()),
                () -> assertEquals(1,tickets[2].getFilaButaca()),
                () -> assertEquals(0,tickets[2].getColumnaButaca()),
                () -> assertEquals(1,tickets[3].getFilaButaca()),
                () -> assertEquals(1,tickets[3].getColumnaButaca())
        );
    }







}
