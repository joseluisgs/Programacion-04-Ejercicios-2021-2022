package es.ftoribio.dam.models;


import es.ftoribio.dam.creators.Creator;
import es.ftoribio.dam.players.Player;

public class Boxes {
    private final int number;
    private final Resource resource;
    private Player boxPlayer;

    public Boxes() {
        number = Creator.aleatoryNum();
        resource = Creator.aleatoryResource();
        boxPlayer = null;
    }

    public int getNumber() {
        return number;
    }

    public Resource getResource() {
        return resource;
    }

    public Player getBoxPlayer() {
        return boxPlayer;
    }

    public void setBoxPlayer(Player boxPlayer) {
        this.boxPlayer = boxPlayer;
    }

    @Override
    public String toString() {
        return "Boxes{" +
                "number=" + number +
                ", resource=" + resource +
                ", boxPlayer=" + boxPlayer +
                '}';
    }
}
