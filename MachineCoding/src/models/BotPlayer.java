package models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import strategies.botplaying.BotPlayingStrategy;
import strategies.botplaying.BotPlayingStrategyFactory;
import strategies.botplaying.EasyBotPlayingStrategy;

@Getter
@Setter
@SuperBuilder
public class BotPlayer extends  Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    @Override
    public Cell nextMove(Board board) {
        Cell cell = botPlayingStrategy.suggestMove(board);
        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);
        return cell;
    }
}
