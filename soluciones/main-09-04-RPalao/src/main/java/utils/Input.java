package utils;

import java.util.Scanner;

/**
 *
 */
public class Input {
    private static final Scanner sc = new Scanner(System.in);
    private static int option;


    /**
     * Input para pedir la opción.
     * @return número de opción elegida.
     */
    public static int optionMenu(){
        do {
            try {
                System.out.println("\n" +
                        "Qué opción quieres?:" + "\n" +
                        ">1: Ingresar dinero " + "\n" +
                        ">2: Retirar dinero " + "\n" +
                        ">3: Ver cuenta " + "\n" +
                        ">4: Añadir titular a la cuenta " + "\n" +
                        ">5: Eliminar titular de la cuenta " + "\n" +
                        ">6: Ver titulares " + "\n" +
                        ">0: Salir " + "\n");
                option = sc.nextInt();
            }catch (Exception e){
                option = -1;
                sc.next();
            }
        }while(option<0 || option>6);
        sc.nextLine();   //Limpieza de scanner
        return option;
    }

    //Getter opcion
    public static int getOption() {return option;}



    /**
     * Pedir nombre de titular
     * @return el nombre
     */
    public static String pedirNombre() {
        boolean allAreLetters;
        String name;
        do {
            System.out.println("Dime el nombre del titular");
            name = sc.nextLine();
            allAreLetters = isAllAreLetters(name);
        }while (!allAreLetters);
        return name;
    }


    /**
     * Método para saber si el nombre completo son letras.
     * @param name nombre a ver si es correcto.
     * @return si es correcto o no
     */
    public static boolean isAllAreLetters(String name) {
        int numero=0;
        for (int i = 0; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i)) || name.charAt(i)==' ') {
                numero ++;
            }
        }
        return numero == name.length();
    }


    /**
     * Pedir dni.
     * @return string del dni
     */
    public static String pedirDni(){
        String dni;
        boolean length;
        boolean allCorrect = false;
        do {
            System.out.println("Dime el dni del titular: ");
            dni = sc.nextLine();

            length = dni.length() == 9;

            if (length){
                allCorrect = isAllCorrect(dni);}

        }while (!length || !allCorrect);
        return dni;
    }


    /**
     * Método para saber si está bien escrito el dni.
     * @param dni a mirar si está bien.
     * @return si es correcto o no.
     */
    public static boolean isAllCorrect(String dni) {
        int numero=0;
        for (int i = 0; i < dni.length()-1; i++) {
            if (Character.isDigit(dni.charAt(i))){
                numero++;
            }
        }
        if (Character.isLetter(dni.charAt(dni.length()-1))){
            numero ++;
        }
        return numero==dni.length();
    }


    /**
     * Pedir el número de titulares que va a haber en la cuenta.
     * @return el número de titulares
     */
    public static int pedirNumeroTitularesCuenta(){
        int numero;
        do {
            try {
                System.out.println("Dime cuántos titulares de cuenta hay: min 1 max 3");
                numero = sc.nextInt();
            }catch (Exception e){
                System.out.println("Número de titulares incorrecto");
                numero = -1;
                sc.next();
            }
        }while (numero<1 || numero > 3);
        sc.nextLine();
        return numero;
    }


    /**
     * Pedir el saldo de la cuenta.
     * @return el saldo
     */
    public static float pedirSaldoCuenta(){
        float saldo;
        do {
            try {
                System.out.println("Dime el saldo que hay en la cuenta: ");
                saldo = sc.nextFloat();
            }catch (NumberFormatException e){
                System.out.println("Saldo inválido, vuelva a escribirlo");
                saldo = -1.00f;
                sc.next();
            }
        }while (saldo<=0);
        sc.nextLine();
        return saldo;
    }


    /**
     * Pedir el número de cuenta con sus filtrados.
     * @return el número de cuenta correcto.
     */
    public static String pedirNumeroCuenta(){
        boolean length ;
        boolean twoLetterAndNumbers = false;
        String numero;
        do {
            System.out.println("Dime tu número de cuenta: ");
            numero = sc.nextLine();
            length = numero.length() == 24;

            if (length){
            twoLetterAndNumbers = isCorrectCharacters(numero);}

            if (!length || ! twoLetterAndNumbers){System.out.println("Número de cuenta inválido, porfavor vuelva a escribirlo, formato: ES1234567891234567891234");}
        }while (!length || ! twoLetterAndNumbers);
        return numero;
    }


    /**
     * Para saber si es correcto la cuenta que nos han metido.
     * @param numero cuenta a mirar.
     * @return si es correcto o no.
     */
    public static boolean isCorrectCharacters(String numero) {
        int correcto = 0;
        for (int i = 0; i < numero.length(); i++) {
            if (i < 2 && Character.isLetter(numero.charAt(i))) {
                correcto ++;
            }
            if (i >=2 && Character.isDigit(numero.charAt(i))) {
                correcto ++;
            }
        }
        return correcto == 24;
    }

    /**
     * Pedir telefono del titular
     * @return el numero de telefono
     */
    public static String pedirTelefono() {
        String telefono ;
        boolean correcto = false;
        boolean length;
        do {
            System.out.println("Dime el télefono del titular");
            telefono = sc.nextLine();
            length = telefono.length() == 9;

            if (length){
            correcto = isAllDigits(telefono);}

        }while (!length || !correcto);
        return telefono;
    }


    /**
     * Método pra saber si el númeor de telefono es correcto.
     * @param telefono telefono a saber si es correcto.
     * @return correcto o no.
     */
    public static boolean isAllDigits(String telefono) {
        int num=0;
        for (int i = 0; i < telefono.length(); i++) {
            if (Character.isDigit(telefono.charAt(i))) {
                num ++;
            }
        }
        return num == 9;
    }


    /**
     * Pedir apellido del titular
     * @return el apellido
     */
    public static String pedirApellido() {
        boolean allAreLetters;
        String name;
        do {
            System.out.println("Dime el apellido del titular");
            name = sc.nextLine();
            allAreLetters = isAllAreLetters(name);
        }while (!allAreLetters);
        return name;
    }


    /**
     * Pedir dinero para añadir o retirar en la cuenta.
     * @return el dinero que se quiere añadir o retirar.
     */
    public static float pedirDinero() {
        float dinero;
        do {
            try {
                System.out.println("Dime el dinero: ");
                dinero = sc.nextFloat();
            }catch (NumberFormatException e){
                System.out.println("Saldo inválido, vuelva a escribirlo");
                dinero = -1.00f;
                sc.next();
            }
        }while (dinero<=0);
        sc.nextLine();
        return dinero;
    }
}
