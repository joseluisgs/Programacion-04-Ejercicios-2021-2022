package Utils;

import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner(System.in);

    public int readInt(){
        int num=0;
        boolean ok= true;
        do {
            try {
                System.out.print("-> ");
                num= sc.nextInt();
                ok=true;
            }catch(Exception e){
                sc.next();
                ok= false;
                System.out.println("El número introducido es incorrecto.");
            }
        }while(!ok);
        return num;
    }
    public String readString(){
        String cadena="";
        boolean ok= true;
        do {
            System.out.print("-> ");
            cadena= sc.next();
            if (cadena.trim().length() == 2){
                ok= true;
            } else{
                ok= false;
                System.out.println("Error en la introducion de datos.");
            }
        }while(!ok);
        return cadena;
    }
}
