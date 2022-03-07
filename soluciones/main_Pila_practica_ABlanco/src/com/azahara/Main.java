package com.azahara;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        //la pila se llama stack y ya está implementada parece
         Stack<Integer> pila = new Stack();

         //teret numero en la pila
        System.out.println("apilamos :");
        for (int i = 0; i <10 ; i++) {
            pila.push(i);
            System.out.println(pila.peek());
        }

        // ver el numero que sacariamos primero
        System.out.println("miramos uno :");
        System.out.println(pila.peek());

        //sacar numeros de la pila
        System.out.println("desapilamos :");
         int tamanioPila =pila.size();
        for (int i = 0; i <tamanioPila ; i++) {
            //no ponem
            System.out.println(pila.peek());
            pila.pop();

        }

    }
}
