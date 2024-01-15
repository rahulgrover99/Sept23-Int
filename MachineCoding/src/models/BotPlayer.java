package models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import strategies.botplaying.BotPlayingStrategy;
import strategies.botplaying.EasyBotPlayingStrategy;

@Getter
@Setter
@SuperBuilder
public class BotPlayer extends  Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Cell nextMove(Board board) {
        // TODO: Have a simple factory here based on difficulty level
        // TODO: Don't initialize this everytime.
        botPlayingStrategy = new EasyBotPlayingStrategy();
        Cell cell = botPlayingStrategy.suggestMove(board);

        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);
        return cell;
    }
}
