package com.azahara;

public class MesaFachada {
    // crear baraja con 4 palos y 2 colores de 1 a 12
    Mazo m = new Mazo("m");

    //creamos los mazosdende guardaremos las cartas colocadas
    Mazo corazonesR = new Mazo("corazonesR");
    Mazo picasR = new Mazo("picasR");
    Mazo trebolesN = new Mazo("trebolesN");
    Mazo rombosN = new Mazo("rombosN");

    //crearemos 2 mazos donde pondremos las cartas inversamente y conbinando cores
    Mazo descolocadas1 = new Mazo("descolocadas1");
    Mazo descolocadas2 = new Mazo("descolocadas2");
    Mazo descartes = new Mazo("descartes");

    public  void iniciarJuego(){

        //las descolocamos y metemos en una pila
        m.crearMazo();
        m.barajear();
    }

    public Mazo elegirMazo() {
        boolean e =false;
        Mazo mazoElegido;
        do {
            String elecion =Utiles.pedirmazo();
            if (elecion.equalsIgnoreCase("descartes")){
                mazoElegido= descartes;
                e=true;
            }else if (elecion.equalsIgnoreCase("descolocadas1")){
                mazoElegido= descolocadas1;
                e=true;
            }else if (elecion.equalsIgnoreCase("descolocadas2")){
                mazoElegido= descolocadas2;
                e=true;
            }else if (elecion.equalsIgnoreCase("corazonesR")){
                mazoElegido= corazonesR;
                e=true;
            }else if (elecion.equalsIgnoreCase("picasR")){
                mazoElegido= picasR;
                e=true;
            }else if (elecion.equalsIgnoreCase("trebolesN")){
                mazoElegido= trebolesN;
                e=true;
            }else if (elecion.equalsIgnoreCase("rombosN")){
                mazoElegido= rombosN;
                e=true;
            }else if (elecion.equalsIgnoreCase("m")){
                mazoElegido= m;
                e=true;
            }else{
                System.out.println("elecion no posible");
                mazoElegido = null;
            }

        }while(!e);
        return mazoElegido;
    }

    public void esPosibleHacer(Mazo mazoASacar, Mazo mazoAPoner) {
        //descartes
        if (mazoAPoner.getNombre().equalsIgnoreCase("descartes")) {
            Carta c = mazoASacar.cojerCarta();
            mazoAPoner.ponerCarta(c);
        }
        //m
        if (mazoAPoner.getNombre().equalsIgnoreCase("m")) {
            System.out.println("no se pueden poner cartas en el mazo m");
        }

        //descolocadas
        if ((mazoAPoner.getNombre().equalsIgnoreCase("descolocadas1") || mazoAPoner.getNombre().equalsIgnoreCase("descolocadas2"))) {
            if (mazoAPoner.verCarta() == null) {
                Carta c = mazoASacar.cojerCarta();
                mazoAPoner.ponerCarta(c);
            } else {

                String a = mazoASacar.verCarta().getColor();
                String s = mazoAPoner.verCarta().getColor();
                int a1 = mazoASacar.verCarta().getNumero();
                int s1 = mazoAPoner.verCarta().getNumero();

                if (a.equalsIgnoreCase(s) && ((a1+1==s1)||(a1-1==s1)) ) {
                    System.out.println("no es posible no son del mismo color o consecutivas");
                } else {
                    Carta c = mazoASacar.cojerCarta();
                    mazoAPoner.ponerCarta(c);
                }

            }
        }
        if (mazoAPoner.getNombre().equalsIgnoreCase("rombosN") && mazoASacar.verCarta().getPalo().equalsIgnoreCase("♦")){
            if (mazoAPoner.size() == 0) {
                if (mazoASacar.verCarta().getNumero() == 12) {
                    Carta c = mazoASacar.cojerCarta();
                    mazoAPoner.ponerCarta(c);
                }
            } else {
                String a = mazoASacar.verCarta().getColor();
                String s = mazoAPoner.verCarta().getColor();
                int a1 = mazoASacar.verCarta().getNumero();
                int s1 = mazoAPoner.verCarta().getNumero();

                if (a.equalsIgnoreCase(s) && a1 == (s1 + 1)) {
                    Carta c = mazoASacar.cojerCarta();
                    mazoAPoner.ponerCarta(c);
                } else {
                    System.out.println("no es del mismo color o no es consecutiva");
                }

            }
        }else if (mazoAPoner.getNombre().equalsIgnoreCase("trebolesN") && mazoASacar.verCarta().getPalo().equalsIgnoreCase("♣")){
            if (mazoAPoner.size() == 0) {
                if (mazoASacar.verCarta().getNumero() == 12) {
                    Carta c = mazoASacar.cojerCarta();
                    mazoAPoner.ponerCarta(c);
                }
            } else {
                String a = mazoASacar.verCarta().getColor();
                String s = mazoAPoner.verCarta().getColor();
                int a1 = mazoASacar.verCarta().getNumero();
                int s1 = mazoAPoner.verCarta().getNumero();

                if (a.equalsIgnoreCase(s) && a1 == (s1 + 1)) {
                    Carta c = mazoASacar.cojerCarta();
                    mazoAPoner.ponerCarta(c);
                } else {
                    System.out.println("no es del mismo color o no es consecutiva");
                }

            }
        }else if (mazoAPoner.getNombre().equalsIgnoreCase("picasR") && mazoASacar.verCarta().getPalo().equalsIgnoreCase("♠")){
            if (mazoAPoner.size() == 0) {
                if (mazoASacar.verCarta().getNumero() == 12) {
                    Carta c = mazoASacar.cojerCarta();
                    mazoAPoner.ponerCarta(c);
                }
            } else {
                String a = mazoASacar.verCarta().getColor();
                String s = mazoAPoner.verCarta().getColor();
                int a1 = mazoASacar.verCarta().getNumero();
                int s1 = mazoAPoner.verCarta().getNumero();

                if (a.equalsIgnoreCase(s) && a1 == (s1 + 1)) {
                    Carta c = mazoASacar.cojerCarta();
                    mazoAPoner.ponerCarta(c);
                } else {
                    System.out.println("no es del mismo color o no es consecutiva");
                }

            }
        }else if (mazoAPoner.getNombre().equalsIgnoreCase("corazonesR") && mazoASacar.verCarta().getPalo().equalsIgnoreCase("♥")){
            if (mazoAPoner.size() == 0) {
                if (mazoASacar.verCarta().getNumero() == 12) {
                    Carta c = mazoASacar.cojerCarta();
                    mazoAPoner.ponerCarta(c);
                }
            } else {
                String a = mazoASacar.verCarta().getColor();
                String s = mazoAPoner.verCarta().getColor();
                int a1 = mazoASacar.verCarta().getNumero();
                int s1 = mazoAPoner.verCarta().getNumero();

                if (a.equalsIgnoreCase(s) && a1 == (s1 + 1)) {
                    Carta c = mazoASacar.cojerCarta();
                    mazoAPoner.ponerCarta(c);
                } else {
                    System.out.println("no es del mismo color o no es consecutiva");
                }

            }
        }






    }

    public  void cargarMazo(Mazo vacio, Mazo lleno){
        int cartas= lleno.size();
        for (int i = 0; i < cartas; i++) {
            vacio.ponerCarta(lleno.cojerCarta());
        }
    }

    public void cambioMazo() {
        if (m.size()==0){
            System.out.println("se te acabaron las cartas, ponemos las cartas de descartes en el mazo");
            cargarMazo(m,descartes);
        }
    }


    public void imprimirMesa() {

        System.out.println("los mazos son :");

        if (m.size() != 0) {
            System.out.println(m.toStringCorta());
        } else {
            System.out.println(m.toStringNombre());
        }

        if (corazonesR.size() != 0) {
            System.out.println(corazonesR.toString());
        } else {
            System.out.println(corazonesR.toStringNombre());
        }

        if (picasR.size() != 0) {
            System.out.println(picasR.toString());
        } else {
            System.out.println(picasR.toStringNombre());
        }

        if (trebolesN.size() != 0) {
            System.out.println(trebolesN.toString());
        } else {
            System.out.println(trebolesN.toStringNombre());
        }

        if (rombosN.size() != 0) {
            System.out.println(rombosN.toString());
        } else {
            System.out.println(rombosN.toStringNombre());
        }

        if (descolocadas1.size() != 0) {
            System.out.println(descolocadas1.toString());
        } else {
            System.out.println(descolocadas1.toStringNombre());
        }

        if (descolocadas2.size() != 0) {
            System.out.println(descolocadas2.toString());
        } else {
            System.out.println(descolocadas2.toStringNombre());
        }

        if (descartes.size() != 0) {
            System.out.println(descartes.toString());
        } else {
            System.out.println(descartes.toStringNombre());
        }
    }


}

