package services;

import models.*;
import strategies.winning.WinningStrategy;

public class GameService {

    private Game game;

    public GameService(Game game) {
        this.game = game;
    }



    // While there is space on the board.
    // Print out which players move it is.
    // Get the player and call nextMove
    // Display the board.
    // Iterate over all the winning strategies to check if any player has won.
    // Update the next player index.
    public void executeNextMoves() {
        while(checkEmptySpace()) {
            Player currentPlayer = game.getPlayers().get(game.getNextPlayerIndex());
            System.out.printf("It's %s move...\n", currentPlayer.getName());

            Cell cell = currentPlayer.nextMove(game.getBoard());

            game.getBoard().print();

            for (WinningStrategy winningStrategy: game.getWinningStrategies()) {
                if (winningStrategy.checkWin(cell, game.getBoard())) {
                    game.setGameState(GameState.SUCCESS);
                    System.out.printf("Player %s won!!!", currentPlayer.getName());
                    return;
                }
            }

            this.game.setNextPlayerIndex(
                    (game.getNextPlayerIndex() + 1)%game.getPlayers().size()
            );

        }

        if (!game.getGameState().equals(GameState.SUCCESS)) {
            game.setGameState(GameState.DRAW);
            System.out.println("No more cells to play, and hence game draw.");
        }
    }

    private boolean checkEmptySpace() {
        Board board = game.getBoard();

        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    return true;
                }
            }
        }
        return false;
    }


}
