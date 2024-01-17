package strategies.winning;

import models.Board;
import models.Cell;

// TODO: Implement diagnol winning strategy!
public interface WinningStrategy {
    boolean checkWin(Cell cell, Board board);
}
