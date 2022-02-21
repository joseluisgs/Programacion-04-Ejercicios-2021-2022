import models.Coche;
import utils.CreatorRandom;

/**
 * @author Rocio PF
 * @version 1.0
 * github: Rochiio
 */

public class Main {

    public static void main(String[] args) {
        Coche coche = new Coche(CreatorRandom.randomMarca(),CreatorRandom.randomModelo(),CreatorRandom.randomColor(),CreatorRandom.randomMatricula());
        coche.cicloCoche();
    }
}
