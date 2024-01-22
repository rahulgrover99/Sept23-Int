package services;

import exceptions.InvalidCellException;
import models.*;
import strategies.winning.WinningStrategy;

import java.util.List;
import java.util.Scanner;

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

            Cell cell = null;
            try {
                cell = currentPlayer.nextMove(game.getBoard());
            } catch (InvalidCellException e) {
                System.out.println("Please re-check the cell you entered!");
                continue;
            }

            game.getMoves().add(new Move(cell, currentPlayer));
            game.getBoard().print();

            for (WinningStrategy winningStrategy: game.getWinningStrategies()) {
                if (winningStrategy.checkWin(cell, game.getBoard())) {
                    game.setGameState(GameState.SUCCESS);
                    System.out.printf("Player %s won!!!", currentPlayer.getName());
                    return;
                }
            }

            if (currentPlayer.getPlayerType().equals(PlayerType.HUMAN)) {
                askIfPlayerWantsToUndo();
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

    private void askIfPlayerWantsToUndo() {
        System.out.println("Would you like to undo the last move?");
        Scanner sc = new Scanner(System.in);
        String response = sc.next();

        if (response.equals("Y")) {
            undoLastMove();
            game.board.print();
        }
    }

    private void undoLastMove() {
        System.out.println("Removing the last move");
        List<Move> moves = game.getMoves();
        System.out.println(moves.get(moves.size() - 1));
        Cell cell = moves.get(moves.size() - 1).getCell();

        moves.remove(moves.size() - 1);
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        game.setNextPlayerIndex(game.getNextPlayerIndex() - 1);

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
