package Models;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Butacas {
    private Estado estado;


    //Constructor
    public Butacas(Estado estado) {
        this.estado = estado;
    }

    //Getter estado
    public Estado getEstado() {return estado;}

    //Setter estado
    public void setEstado(Estado estado) {this.estado = estado;}

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (estado==Estado.LIBRE ){
            result.append(colorize("[🛋]", BLACK_TEXT(), GREEN_BACK()));
        }else if (estado==Estado.COMPRADO){
            result.append(colorize("[😎]", BLACK_TEXT(), RED_BACK()));
        }else if (estado==Estado.RESERVADO){
            result.append(colorize("[🛎]", BLACK_TEXT(), BACK_COLOR(202)));
        }
        return result.toString();
    }
}
