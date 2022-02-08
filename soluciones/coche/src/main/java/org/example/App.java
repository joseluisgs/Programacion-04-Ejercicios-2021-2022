package org.example;

import org.example.Models.Coche;
import org.example.Utils.IotHK;

import java.util.Locale;

// STOPSHIP: 01/02/2022  
public class App {

    public static void main( String[] args )    {
        IotHK sc =new IotHK();
        Coche coche = new Coche("0616cnd");


        System.out.println(coche);
        coche.funiconamiento();




    }
}
