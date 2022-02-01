package org.example;

import org.example.models.Cuenta;
import utils.Input;

/**
 * @author Rocio Palao
 * @version 1.0
 * github: Rochiio
 * Gestionaremos una cuenta bancaria. Dicha cuenta constará de un número de cuenta, un saldo y tres titulares (como máximo, al menos uno).
 * Para cada titular tenemos que almacenar su DNI, nombre, apellidos y teléfono.
 * Crea los métodos necesarios que permitan realizar las operaciones habituales con la pasta: ingresar y retirar.
 * Y añadir/borrar titulares a la misma. Cuando se crea una cuenta debe tener al menos un titular.
 * El programa principal debe tener menús que permitan gestionar todos los aspectos de la cuenta.
 */
public class App {

    public static void main(String[] args) {

        //Crear nueva cuenta
        Cuenta cuenta;
        cuenta = Cuenta.getInstance();
        int opcion=10;

        while (opcion!=0) {
            cuenta.switchOptionMenu(Input.optionMenu());
            opcion=Input.getOption();
        }



    }
}
