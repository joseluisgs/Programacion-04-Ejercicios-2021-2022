import models.Coche;
public class Main {
    public static void main(String[]args){
    Coche car1 = new Coche("Nissan","Supra","Amarillo","1111PBC",false,3,3);
    car1.inputAceleracion();
    car1.acelerar();
    car1.frenazoGato();
    car1.inputMantenerVelocidad();
    car1.mantenerVelocidad();
    car1.decelerar();
    car1.deadPoint();
    }
    // TODO: 10/02/2022 Método que haga que corra el programa durante 5 veces y poder implementar las marchas. Game Loop.
}
