package utils;

public class CreatorRandom {
    private static final String[] marcas = {"Mercedes","Skoda","BMV","Kia","Peugot","Seat","Porsche"};
    private static final String[] modelos = {"A1/Sportback","Carens","Discovery","AMG GT","Juke","Boxster","Panamera","Macan","Ibiza","Leon","Fabia"};
    private static final String[] color = {"Rojo","Amarillo","Verde","Azul","Negro","Gris","Rosa","Morado","Naranja"};
    private static final String[] numeros = {"1","2","3","4","5","6","7","8","9","0"};
    private static final String[] letra = {"A","B","C","D","E","F","G","H","I"};


    /**
     * Aleatorio de marcas.
     * @return una marca aleatoria.
     */
    public static String randomMarca(){
        int num = (int)(Math.random()*marcas.length);
        return marcas[num];
    }


    /**
     * Aleatorio de modelos.
     * @return un modelo aleatorio.
     */
    public static String randomModelo(){
        int num = (int)(Math.random()*modelos.length);
        return  modelos[num];
    }


    /**
     * Aleatorio de color.
     * @return un color aleatorio.
     */
    public static String randomColor(){
        int num = (int)(Math.random()*color.length);
        return  color[num];
    }


    /**
     * Aleatorios de numeros y letras para crear una matrícula.
     * @return matricula aleatoria.
     */
    public static String randomMatricula(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            result.append(numeros[(int) (Math.random()* numeros.length)]);
        }
        result.append(letra[(int) (Math.random()* letra.length)]);
        result.append(letra[(int) (Math.random()* letra.length)]);
        result.append(letra[(int) (Math.random()* letra.length)]);

        return result.toString();
    }
}
