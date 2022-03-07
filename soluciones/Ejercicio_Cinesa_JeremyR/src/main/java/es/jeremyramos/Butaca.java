package es.jeremyramos;


import es.jeremyramos.utils.Colors;

public class Butaca {
    private int filas;
    private int  columnas;
    private Enum estado;

    //Constructor Manual
    public Butaca(int filas, int columnas, Enum estado) {
        this.filas = filas;
        this.columnas = columnas;
        this.estado = estado;
    }

    public int getFilas() {
        return filas;
    }
    //Constructor Random
    public Butaca(){
       this.creatorRandom();
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public Enum getEstado() {
        return estado;
    }

    public void setEstado(Enum estado) {
        this.estado = estado;
    }

    public void setEstadoRandom(Enum estado) {

        int probability = (int) (Math.random() * 100 + 1);

        if (probability < 40) {
            this.estado = Enum.LIBRE;
        } else if (probability < 70) {
            this.estado = Enum.OCUPADO;
        } else {
            this.estado = Enum.RESERVADO;
        }
    }


    public void creatorRandom() {
        int filas = (int) (Math.random() * 5 + 1);
        int columnas = (int) (Math.random() * 9 + 2);
        this.setColumnas(columnas);
        this.setFilas(filas);
        this.setEstadoRandom(estado);


    }
    @Override
    public String toString(){
        String sitio = "  ";
        if (this.estado == Enum.LIBRE){
            sitio = " " +  Colors.GREEN_BACKGROUND + "[✅]"+ Colors.reset + " ";
        } else if(this.estado == Enum.OCUPADO){
            sitio =  " "+ Colors.RED_BACKGROUND + "[❌]" + Colors.reset + " ";
        }else if (this.estado == Enum.RESERVADO){
            sitio =  " " +Colors.WHITE_BACKGROUND + Colors.YELLOW +"[✋\uD83C\uDFFB]" + Colors.reset + " ";
        }

        return sitio ;
    }




}