package models;

import exceptions.InvalidCellException;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@SuperBuilder
public class HumanPlayer extends Player {
    private int rank;
    private int age;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Cell nextMove(Board board) throws InvalidCellException {
        // 1. Check if there is empty cell in the board.
        // 2. Taking input from the user - which row and col they want to place
        // 3. The cell should be empty.
        // 4. Place the symbol on the allocated cell - update the state of the board.

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the row:");
        int row = sc.nextInt();
        System.out.println("Please enter the column:");
        int col = sc.nextInt();

        if (row < 0 || row >= board.getSize()
            && col < 0 || col >= board.getSize() ||
                !board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            throw new InvalidCellException();
        }


        Cell cell =  board.getBoard().get(row).get(col);
        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);

        return cell;
    }
}
