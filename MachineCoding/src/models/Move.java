package models;

import java.util.List;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    @Override
    public String toString() {
        return "Move{" +
                "cell=" + cell +
                ", player=" + player +
                '}';
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
