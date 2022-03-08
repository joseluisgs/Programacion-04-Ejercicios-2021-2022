package models;
import creators.ControlarEntrada;
import utils.Colors;

import java.time.Instant;

public class Sala {
    //Estado
    private static final int MAX_BUTACAS = 45;
    private Butaca[][] butacas = new Butaca[5][9];
    private int[] ultimaReserva = new int[2];
    private boolean devolverDinero;
    private ControlarEntrada entrada = new ControlarEntrada();
    private int numeroTickets = 0;

    private Ticket[] factura = new Ticket[MAX_BUTACAS];
    private int totalRecaudacion;

    //Constructores

    //Setters & Getters

    //Comportamiento
    public void inicializarSalaButacasLibres(){
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++) {
                butacas[i][j].setEstado(Estado.LIBRE);
            }
        }
    }
    public void crearButaca(){
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++) {
                butacas[i][j] = new Butaca();
            }
        }
    }

    public void compra() {
        int fila = entrada.leerFila();
        int columna = entrada.leerColumna();
        datosUltimaCompra(fila, columna);
        if (butacas[fila][columna].getEstado() == Estado.LIBRE) {
            butacas[fila][columna] = entrada.createButacaOcupada(fila,columna);
            darInformacionCliente("abonar");
            recaudacion("abonar");
            darInformacionCliente("confirmacion");
            darInformacionCliente("exito");
            inicializarTicket(fila, columna);
        } else if (butacas[fila][columna].getEstado() == Estado.RESERVADA){
            darInformacionCliente("reservada");
        }else if (butacas[fila][columna].getEstado() == Estado.OCUPADA){
            darInformacionCliente("ocupada");
        }
    }

    public void almacenarTicket(Ticket ticket) {
        for (int i = 0; i < MAX_BUTACAS; i++) {
            if (factura[i] == null) {
                factura[i] = ticket;
                numeroTickets++;
                return;
            }
        }
    }

    private void inicializarTicket(int fila, int columna) {
        System.out.println("\n" + Colors.BLUE + "Su ticket:" + Colors.RESET);
        Ticket ticket = new Ticket(6.0f, fila, columna);
        System.out.println(ticket.toString());
        almacenarTicket(ticket);
    }

    public void reserva() {
        int fila = entrada.leerFila();
        int columna = entrada.leerColumna();
        datosUltimaReserva(fila,columna);
        if (butacas[fila][columna].getEstado() == Estado.LIBRE) {
            butacas[fila][columna] = entrada.createButacaReservada(fila,columna);
            darInformacionCliente("exito");
        } else if (butacas[fila][columna].getEstado() == Estado.RESERVADA){
            darInformacionCliente("reservada");
        }else if (butacas[fila][columna].getEstado() == Estado.OCUPADA){
            darInformacionCliente("ocupada");
        }
    }

    public void confirmar() {
        butacas[ultimaReserva[0]][ultimaReserva[1]]= entrada.createButacaOcupada(ultimaReserva[0],ultimaReserva[1]);
        if(!devolverDinero){
            darInformacionCliente("abonar");
            recaudacion("abonar");
            darInformacionCliente("confirmacion");
            devolverDinero = true;
            inicializarTicket(ultimaReserva[0] ,ultimaReserva[1]);
        }
        darInformacionCliente("exito");

    }

    public void anular() {
        butacas[ultimaReserva[0]][ultimaReserva[1]]= entrada.createButacaLibre(ultimaReserva[0], ultimaReserva[1]);
        darInformacionCliente("exito");
        if(devolverDinero){
            darInformacionCliente("reembolso");
            recaudacion("devolver");
            eliminarTicket(numeroTickets-1);
        }
    }

    private void recaudacion(String operacion) {
        if(operacion.equals("devolver")){
            totalRecaudacion -= 6;
        }else if(operacion.equals("abonar")){
            totalRecaudacion += 6;
        }
    }

    public void resumen() {
        System.out.println(Colors.BLUE + "Actualmente el cine tiene: " + totalRecaudacion + "€." + Colors.RESET + "\n" +
                        Colors.BLUE + "Hay: \n" +
                        Colors.BLUE + "> " + butacasLibres() + " butacas libres, el " + calcularPorcentaje(butacasLibres()) + "% de la sala. \n" + Colors.RESET +
                        Colors.BLUE + "> " + butacasReservadas() + " butacas reservadas, el " + calcularPorcentaje(butacasReservadas()) + "% de la sala. \n" + Colors.RESET +
                        Colors.BLUE + "> " + butacasOcupadas() + " butacas ocupadas, el " + calcularPorcentaje(butacasOcupadas()) + "% de la sala. \n" + Colors.RESET);
    }

    private int butacasLibres(){
        int contador = 0;
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++){
                if (butacas[i][j] != null && butacas[i][j].getEstado() == Estado.LIBRE){
                    contador++;
                }
            }
        }
        return contador;
    }
    private int butacasReservadas(){
        int contador = 0;
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++){
                if (butacas[i][j] != null && butacas[i][j].getEstado() == Estado.RESERVADA){
                    contador++;
                }
            }
        }

        return contador;
    }
    private int butacasOcupadas(){
        int contador = 0;
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++){
                if (butacas[i][j] != null && butacas[i][j].getEstado() == Estado.OCUPADA){
                    contador++;
                }
            }
        }
        return contador;
    }

    private float calcularPorcentaje(int cantidad){
        float porcentaje = (float)cantidad / (float)MAX_BUTACAS * 100.0f;
        return Math.round(porcentaje * 100.0f) / 100.0f;
    }

    public int filasOcupadas(){
        int contador = 0;
        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++){
                if (butacas[i][j] != null && butacas[i][j].getEstado() == Estado.OCUPADA){

                }
            }
        }
        return contador;
    }
    public void grafico(){
        System.out.println( Colors.WHITE_BACKGROUND + "          PANTALLA           " + Colors.RESET + "\n");

        String[] numeroColumna = {"   ","1  ","2  ","3  ","4  ","5  ","6  ","7  ","8  ","9  "};
        for(int i=0; i< numeroColumna.length; i++){
            System.out.print( numeroColumna[i]);
        }
        System.out.println();

        for(int i=0; i< butacas.length; i++){
            char[] letraFila = {'A','B','C','D','E'};
            System.out.print(letraFila[i]+ " ");
            for(int j=0; j< butacas[i].length; j++){
                manejoColorButaca(i, j);
            }
            System.out.println();
        }
    }

    private void manejoColorButaca(int i, int j) {
        if(butacas[i][j].getEstado() == Estado.LIBRE){
             System.out.print(Colors.WHITE_BACKGROUND + Colors.GREEN + "[_]" + Colors.RESET);
        }else if(butacas[i][j].getEstado() == Estado.RESERVADA){
             System.out.print (Colors.WHITE_BACKGROUND + Colors.YELLOW + "[_]" + Colors.RESET);
        }else if(butacas[i][j].getEstado() == Estado.OCUPADA){
            System.out.print(Colors.WHITE_BACKGROUND + Colors.RED + "[_]" + Colors.RESET);
        }
    }

    public String leerFactura() {
        StringBuilder result = new StringBuilder();
        if (numeroTickets != 0) {
            for (int i = 0; i < factura.length; i++) {
                if (factura[i] != null) {
                    result.append(i + 1).append("- ").append(factura[i].toString()).append("\n");
                }
            }
        } else {
            result = new StringBuilder(Colors.BLUE + "No hay ninguna entrada vendida aún." + Colors.RESET);
        }
        return result.toString();
    }

    public void eliminarTicket(int posicion) {
        if (posicion < MAX_BUTACAS && posicion >= 0) {
            if (factura[posicion] != null) {
                factura[posicion] = null;
                numeroTickets++;
            }
        } else {
            System.out.println("No se pueden vender más entradas, la sala está completa");
        }
    }
    public StringBuilder buscarPorFecha(Instant instante) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < MAX_BUTACAS; i++) {
            if (factura[i] != null && factura[i].getInstante() == instante) {
                result.append(i + 1).append("- ").append(factura[i].toString()).append("\n");
            }
        }
        return result;
    }
    public StringBuilder buscarPorButaca(int fila, int columna) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < MAX_BUTACAS; i++) {
            if (factura[i] != null && factura[i].getFila() == fila && factura[i].getColumna() == columna) {
                result.append(i + 1).append("- ").append(factura[i].toString()).append("\n");
            }
        }
        return result;
    }


    public void ordenarAntiguoAReciente() {
        Ticket aux;
        // Utilizamos el método de ordenación burbuja
        for (int i = 0; i < MAX_BUTACAS; i++) {
            for (int j = i + 1; j < MAX_BUTACAS; j++) {
                if (factura[i] != null && factura[j] != null && factura[i].getInstante().isBefore(factura[j].getInstante())) {
                    aux = factura[i];
                    factura[i] = factura[j];
                    factura[j] = aux;
                }
            }
        }
        System.out.println(leerFactura());
    }
    private void darInformacionCliente(String operacion) {
        if(operacion.equalsIgnoreCase("abonar")){
            System.out.println(Colors.PURPLE + "Debe abonar 6€ de la entrada." +  Colors.RESET);
        }else if(operacion.equalsIgnoreCase("exito")){
            System.out.println(Colors.GREEN + "Su operación ha sido realizada con éxito." +  Colors.RESET);
        }else if(operacion.equalsIgnoreCase("reservada")){
            System.out.println( Colors.RED + "Fallo al realizar la operación. Esta butaca está reservada." + Colors.RESET);
        }else if(operacion.equalsIgnoreCase("ocupada")){
            System.out.println( Colors.RED + "Fallo al realizar la operación. Esta butaca está comprada." + Colors.RESET);
        }else if(operacion.equalsIgnoreCase("confirmacion")){
            System.out.println( Colors.YELLOW + "Confirmando el pago..." + Colors.RESET);
        }else if(operacion.equalsIgnoreCase("reembolso")) {
            System.out.println(Colors.PURPLE + "En unos segundos recibirá el reembolso de la entrada." + Colors.RESET);
        }
    }

    private void datosUltimaCompra(int fila, int columna) {
        ultimaReserva[0] = fila;
        ultimaReserva[1] = columna;
        devolverDinero = true;
    }
    private void datosUltimaReserva(int fila, int columna) {
        ultimaReserva[0] = fila;
        ultimaReserva[1] = columna;
        devolverDinero = false;
    }



}
