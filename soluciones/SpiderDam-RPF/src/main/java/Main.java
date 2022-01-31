import Models.Sala;
import utils.Input;

/**
 * @author Rocio Palao
 * @version 1.0
 * github: Rochiio
 */

public class Main {

    public static void main(String[] args) {
        int opcion=10;
        Sala sala;

        //Creación de la sala
        sala = Sala.getInstance();

        //Menu
        while (opcion!=0) {
         sala.switchOptionMenu(Input.optionMenu());
         opcion=Input.getOption();
        }
    }

}
