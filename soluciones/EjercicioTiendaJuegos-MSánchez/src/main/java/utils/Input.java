package utils;

import java.util.Scanner;

public class Input {
    Scanner input = new Scanner(System.in);

    /**
     * Lee una línea entrada por teclado, Devuelve el String
     * @return La entrada.
     */
    public String readLine() {
        String line = "";
        do {
            line = input.nextLine();
        } while (line.length() == 0);
        return line;
    }

    /**
     * Lee un entero (entrada por teclado).
     * @return El entero.
     */
    public int readInt() {
        int i = 0;
        boolean ok = false;
        do {
            try {
                i = input.nextInt();
                ok = true;
            } catch (Exception e) {
                System.out.println("Error: no es un entero.");
                input.next();
            }
        } while (!ok);
        return i;
    }

    /**
     * Lee un número float (entrada por teclado).
     * @return El float.
     */
    public float readFloat() {
        float f = 0f;
        boolean ok = false;
        do {
            try {
                f = input.nextFloat();
                ok = true;
            } catch (Exception e) {
                System.out.println("Error: no es un float.");
                input.next();
            }
        } while (!ok);
        return f;
    }

    /**
     * Lee un número double (entrada por teclado).
     * @return El double.
     */
    public double readDouble() {
        double d = 0;
        boolean ok = false;
        do {
            try {
                d = input.nextDouble();
                ok = true;
            } catch (Exception e) {
                System.out.println("Error: no es un double.");
                input.next();
            }
        } while (!ok);
        return d;
    }

    /**
     * Lee un boolean por teclado
     */
    public boolean readBoolean() {
        boolean b = false;
        boolean ok = false;
        do {
            try {
                b = input.nextBoolean();
                ok = true;
            } catch (Exception e) {
                System.err.println("Error: no es un boolean.");
                input.next();
            }
        } while (!ok);
        return b;
    }
}
