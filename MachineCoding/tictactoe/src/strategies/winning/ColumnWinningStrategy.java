package strategies.winning;

import models.Board;
import models.Cell;
import models.CellState;
import models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy {


//    {
//        R: {1: 1},
//        AI : {
//            0: 0, 1: 0, 2: 0
//        }
//    }

    private final HashMap<Player, HashMap<Integer, Integer> > counts = new HashMap<>();
    @Override
    public boolean checkWin(Cell cell, Board board) {
        Player currentPlayer = cell.getPlayer();

        int col = cell.getCol();

//        for (int i = 0; i < board.getSize(); i++) {
//            Cell currentCell = board.getBoard().get(i).get(col);
//            if (currentCell.getCellState().equals(CellState.EMPTY) ||
//                    !currentCell.getPlayer().equals(currentPlayer)) {
//                return false;
//            }
//        }

        if (!counts.containsKey(currentPlayer)) {
            counts.put(currentPlayer, new HashMap<>());
        }
        if (!counts.get(currentPlayer).containsKey(col)) {
            counts.get(currentPlayer).put(col, 0);
        }
        int cnt = counts.get(currentPlayer).get(col);

        counts.get(currentPlayer).put(col, cnt + 1);

        return cnt + 1 == board.getSize();

//        return true;

    }
}