package models;

public class Juego {
    //Estado
    private String titulo = "";
    private String plataforma = "";
    private float precio;

    //Constructores
    public Juego(){
    }

    public Juego(String titulo, String plataforma, float precio) {
        setTitulo(titulo);
        setPlataforma(plataforma);
        setPrecio(precio);
    }

    //Getters & Setters
    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getPlataforma() {

        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        if(plataforma.equalsIgnoreCase("PC") || plataforma.equalsIgnoreCase("XBOX") || plataforma.equalsIgnoreCase("Play")|| plataforma.equalsIgnoreCase("Switch")) {
            this.plataforma = plataforma;
        }else{
            System.err.println("Error. La plataforma debe ser: PC, XBOX, Play o Switch. ");
        }

    }


    public float getPrecio() {

        return precio;
    }

    public void setPrecio(float precio) {
        if( precio >= 0.0f && precio <= 200.0f) {
            this.precio = (float)Math.round(precio*100)/100;
        }else{
            System.err.println("Error. El precio debe de estar comprendido entre 0.00€ y 200.00€.");
        }
    }

    //Comportamiento
    public String toString() {
        return "Título: " + getTitulo() + "\n" +
                "Plataforma: " + getPlataforma() + "\n" +
                "Precio: " + getPrecio() + " €" + "\n";
    }
}


