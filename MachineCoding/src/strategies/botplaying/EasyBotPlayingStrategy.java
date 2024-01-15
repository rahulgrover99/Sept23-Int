package strategies.botplaying;

import models.Board;
import models.Cell;
import models.CellState;
import models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell suggestMove(Board board) {
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    return board.getBoard().get(i).get(j);
                }
            }
        }
        return null;
    }
}
