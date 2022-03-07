package main.java.es.ftoribio.dam;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.Objects;

public class Ticket {
    private int id=1;
    private int contadorId=id++;
    private String descripcion;
    private DateTimeAtCreation horaFecha;

    public Ticket(int id, int contadorId, String descripcion, DateTimeAtCreation horaFecha) {
        this.id = id;
        this.contadorId = contadorId;
        this.descripcion = descripcion;
        this.horaFecha = horaFecha;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContadorId() {
        return contadorId;
    }

    public void setContadorId(int contadorId) {
        this.contadorId = contadorId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DateTimeAtCreation getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(DateTimeAtCreation horaFecha) {
        this.horaFecha = horaFecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId() && getContadorId() == ticket.getContadorId() && getDescripcion().equals(ticket.getDescripcion()) && getHoraFecha().equals(ticket.getHoraFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContadorId(), getDescripcion(), getHoraFecha());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", contadorId=" + contadorId +
                ", descripcion='" + descripcion + '\'' +
                ", horaFecha=" + horaFecha +
                '}';
    }
}
