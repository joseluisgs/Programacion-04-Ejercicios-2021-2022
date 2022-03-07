import creators.ControlarEntrada;
import models.Sala;
import utils.Colors;
import utils.ControlarMenu;


public class App {
    public static void main(String[] args){
        System.out.println(Colors.BLUE_BOLD_BRIGHT + "¡¡¡ BIENVENIDO/A AL CINE DE SPIDER-DAM !!! \n " + Colors.RESET+
                Colors.BLUE +"A continuación se le mostrará un menú donde podrá realizar la operación que desee si pulsa el número de la opción. " + Colors.RESET);
        System.out.println();
        ControlarEntrada entrada = new ControlarEntrada();
        Sala sala = new Sala();
        sala.crearButaca();
        sala.inicializarSalaButacasLibres();

        boolean salir = false;
        do {
            ControlarMenu controlar = new ControlarMenu();
            controlar.imprimirMenu();

            int input = entrada.leerEntrada();

            salir = controlar.controlarEntradas(input, salir, sala);

        }while(!salir);
    }
}
