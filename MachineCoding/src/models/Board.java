package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        createBoard();
    }

    private void createBoard() {
        this.board = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < this.size; j++) {
                board.get(i).add((new Cell(i, j)));
            }
        }
    }


    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print("|\t");
            for (int j = 0; j < this.size; j++) {

                if (this.board.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    System.out.print("\t|\t");
                } else {
                    System.out.print(this.board.get(i).get(j).getPlayer().getSymbol() + "\t|\t");
                }
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
