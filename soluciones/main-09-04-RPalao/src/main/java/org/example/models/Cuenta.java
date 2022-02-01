package org.example.models;

import utils.Input;


public class Cuenta {
    private static Cuenta instance= null;
    private final String numeroCuenta;
    private float saldoCuenta;
    private final Titulares[] titularesCuenta;

    //Instance.
    public static Cuenta getInstance(){
        if (instance==null){
            instance = new Cuenta();
        }
        return instance;
    }

    //Constructor.
    private Cuenta() {
        this.numeroCuenta = Input.pedirNumeroCuenta();
        this.saldoCuenta = Input.pedirSaldoCuenta();
        titularesCuenta = new Titulares[3];
        crearTitulares(Input.pedirNumeroTitularesCuenta());
    }


    /**
     * Creación de titulares de la cuenta.
     * @param numeroTitularesCuenta cuántos titulares hay en la cuenta.
     */
    private void crearTitulares(int numeroTitularesCuenta) {
        for (int i = 0; i < numeroTitularesCuenta; i++){
            System.out.println("Titular " +(i+1));
            titularesCuenta[i] = new Titulares();
        }
    }


    /**
     * Switch con las opciones del menu.
     * @param optionMenu opcion elegida.
     */
    public void switchOptionMenu(int optionMenu) {
        switch(optionMenu){
            case 1: addMoney();
            break;
            case 2: removeMoney();
            break;
            case 3: System.out.println(this);
            break;
            case 4: addTitulares();
            break;
            case 5: removeTitulares();
            break;
            case 6: showTitulares();
            break;
        }
    }

    private void showTitulares() {
        for (Titulares titulares : titularesCuenta) {
            if (titulares != null) {
                System.out.println(titulares);
            }
        }
    }


    /**
     * Elimar titulares en la cuenta
     */
    private void removeTitulares() {
        String nombreTitular;
        int numeroDeTitulares = 0;
        for (Titulares titulares : titularesCuenta) {
            if (titulares != null) {
                numeroDeTitulares++;
            }
        }
            if (numeroDeTitulares==1){
                System.out.println("No se puede eliminar ningún titulares, estás en el mínimo de un titular");
        }else{
               nombreTitular=Input.pedirNombre();
               for (int i=0; i<titularesCuenta.length; i++){
                   if (titularesCuenta[i].getNombre().equalsIgnoreCase(nombreTitular)){
                       titularesCuenta[i]= null;
                       System.out.println("Titular eliminado correctamente");
                   }
               }
                System.out.println("Error: No hay ningún titular con ese nombre");
            }
    }


    /**
     * Añadir titulares en la cuenta
     */
    private void addTitulares() {
        int parar = 0;
        for (int i = 0; i < titularesCuenta.length; i++) {
            if(titularesCuenta[i]==null){
                if (parar == 0) {
                    titularesCuenta[i] = new Titulares();
                    parar ++;
                }
            }
        }
        System.out.println("No se puende añadir más titulares, estás en el máximo de tres");
    }


    /**
     * Retirar dinero de la cuenta.
     */
    private void removeMoney() {
        float removeMoney;
        removeMoney = Input.pedirDinero();
        if(removeMoney>getSaldoCuenta()){
            System.out.println("Error: No puede retirar más dinero del que hay en la cuenta");
        }else{
            removeMoney= getSaldoCuenta() - removeMoney;
            setSaldoCuenta(removeMoney);
            System.out.println("Dinero retirado correctamente");
        }
    }


    /**
     * Añadir dinero a la cuenta.
     */
    private void addMoney() {
         float money;
             money= Input.pedirDinero();
             money += getSaldoCuenta();
             setSaldoCuenta(money);
             System.out.println("Dinero añadido correctamente");
    }


    /**
     * Para saber cuanto titulares (activos) hay en la cuenta.
     * @return el número de titulares
     */
    private int numTitulares() {
        int num = 0;
        for (Titulares titulares : titularesCuenta) {
            if (titulares != null) {
                num++;
            }
        }
        return num;
    }


    //Getters
    public float getSaldoCuenta() {return saldoCuenta;}

    //Setter
    public void setSaldoCuenta(float saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }


    @Override
    public String toString() {
        return "Cuenta{" +
                "Número de Cuenta='" + numeroCuenta + '\'' +
                ", Saldo en Cuenta=" + saldoCuenta +
                ", Número de titulares=" + numTitulares() +
                '}';
    }


}
