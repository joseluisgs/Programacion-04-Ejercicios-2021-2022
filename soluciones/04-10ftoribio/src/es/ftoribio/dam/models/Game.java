package es.ftoribio.dam.models;

import es.ftoribio.dam.players.Pc;
import es.ftoribio.dam.players.Person;
import java.util.ArrayList;

public class Game {

    private static Game instance = null;
    private final int TAM_ROW=3;
    private final int TAM_COL=4;
    private StringBuilder resPerson;
    private StringBuilder resComputer;
    private final ArrayList<ArrayList<Boxes>> gameBoard = new ArrayList<>();
    private final Person character = new Person();
    private final Pc computer = new Pc();

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Game() {
        initBoard();
        showBoxes();
        ocupedBoxes();
    }


    public boolean finishGame() {
            if (character.allPlusTwenty()){
                System.out.println("\n Ha ganado la Persona");
            }else if(computer.allPlusTwenty()){
                System.out.println("\n Ha ganado el Ordenador");}

        return (character.allPlusTwenty() || computer.allPlusTwenty());
    }


    private void ocupedBoxes() {
        int ocuppied =0;
        do {
            askBoxPerson();
            askBoxComputer();
            showBoxes();
                ocuppied += 2;
        }while (ocuppied!=12);

    }


    private void askBoxComputer() {
        int row;
        int col;
        do {
            row = (int) (Math.random()*3);
            col= (int) (Math.random()*4);
        }while (gameBoard.get(row).get(col).getBoxPlayer()!=null);
        gameBoard.get(row).get(col).setBoxPlayer(new Pc());
    }


    private void askBoxPerson() {
        int row;
        int col;
        do {
            row = Input.getRow();
            col= Input.getCol();
        }while (gameBoard.get(row).get(col).getBoxPlayer()!=null);
        gameBoard.get(row).get(col).setBoxPlayer(new Person());
    }


    private void initBoard() {
        for (int i = 0; i < TAM_ROW; i++) {

            ArrayList<Boxes> fila = new ArrayList<>();
            for (int j = 0; j < TAM_COL; j++) {
                fila.add(new Boxes());
            }
            gameBoard.add(fila);
        }
    }


    public void comienzoJuego() {
        int dado = (int) (Math.random()*6+1);
        System.out.println("Ha salido el " +dado);
        showResults(dado);
    }


    private void showResults(int dado) {
    resComputer = new StringBuilder("Ordenador ");
    resPerson = new StringBuilder("Persona ");

        for (ArrayList<Boxes> juego : gameBoard) {
            for (Boxes boxes : juego) {
                if (boxes.getNumber() == dado) {
                    if (boxes.getBoxPlayer() instanceof Person) {
                        character.addValorNumero(boxes.getResource());
                        resPerson.append("1 item de ").append(boxes.getResource()).append(" ");
                    } else {
                        computer.addValorNumero(boxes.getResource());
                        resComputer.append("1 item de ").append(boxes.getResource()).append(" ");
                    }
                }
            }
        }
        mostrar();
    }


    private void mostrar() {
        if (resPerson.toString().equals("Persona ")){
            resPerson = new StringBuilder("Persona 0 items");
        }else if (resComputer.toString().equals("Ordenador ")){
            resComputer= new StringBuilder("Ordenador 0 items");
        }
        System.out.println(resPerson);
        System.out.println(resComputer);
    }


    private void showBoxes() {
        for (ArrayList<Boxes> juego : gameBoard) {
            for (Boxes boxes : juego) {
                System.out.print("[ " + boxes + " ] ");
            }
            System.out.println();
        }
    }
}
