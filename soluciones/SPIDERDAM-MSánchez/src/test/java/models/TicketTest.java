package models;

import org.junit.jupiter.api.*;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Case Ticket Class")
class TicketTest {
    private Ticket ticket = new Ticket(6.0f,1,2);

    @BeforeEach
    void restAlumno() {
        ticket = new Ticket(6.0f, 1, 2);
    }

    @Test
    @Order(1)
    @DisplayName("Test Case Ticket Constructor")
    void testConstructor() {
        Ticket ticket = new Ticket(7.0f, 3, 4);
        Assertions.assertAll(
                () -> assertEquals(7.0f, ticket.getPrecio()),
                () -> assertEquals(3, ticket.getFila()),
                () -> assertEquals(4, ticket.getColumna())
        );
    }
    @Test
    void getId() {
        ticket.setId(1);
        ticket.setId(1+1);
        assertEquals(2, ticket.getId());
    }

    @Test
    void getInstante() {
        assertEquals(Instant.now(), ticket.getInstante());
    }

    @Test
    void setInstante() {
        Instant instante = Instant.now();
        ticket.setInstante(instante);
        assertEquals(instante, ticket.getInstante());
    }

    @Test
    void getPrecio() {
        assertEquals(6.0f, ticket.getPrecio());
    }

    @Test
    void setPrecio() {
        ticket.setPrecio(7.0f);
        assertEquals(7.0f, ticket.getPrecio());
    }

    @Test
    void getFila() {
        assertEquals(1, ticket.getFila());
    }

    @Test
    void setFila() {
        ticket.setPrecio(3);
        assertEquals(3, ticket.getFila());
    }

    @Test
    void getColumna() {
        assertEquals(2, ticket.getFila());
    }

    @Test
    void setColumna() {
        ticket.setPrecio(8);
        assertEquals(8, ticket.getFila());
    }

    @Test
    void testToString() {
        Assertions.assertAll(
                () -> assertTrue(ticket.toString().contains(String.valueOf(ticket.getId()))),
                () -> assertTrue(ticket.toString().contains(String.valueOf(ticket.getFila()))),
                () -> assertTrue(ticket.toString().contains(String.valueOf(ticket.getColumna()))),
                () -> assertTrue(ticket.toString().contains(String.valueOf(ticket.getPrecio()))),
                () -> assertTrue(ticket.toString().contains(String.valueOf(ticket.getInstante())))
        );
    }
}