package models;

import exceptions.InvalidCellException;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class Player {
    // Generation of code in intellij -> Ctrl/Cmd + N
    // Option + Return -> Installing lombok in class path
    private String name;
    private int id;
    private char symbol;
    private PlayerType playerType;

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", symbol=" + symbol +
                ", playerType=" + playerType +
                '}';
    }

    public abstract Cell nextMove(Board board) throws InvalidCellException;

}
