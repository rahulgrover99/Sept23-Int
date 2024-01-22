package controllers;

import models.Game;
import models.GameState;
import models.Player;
import services.GameService;
import strategies.winning.WinningStrategy;

import java.util.List;

public class GameController {

    Game game;
    GameService gameService;

    public GameController(Game game) {
        this.game = game;
        this.gameService = new GameService(game);

    }

    public static Game initiateGame(int dimension, List<Player> players,
                                    List<WinningStrategy> winningStrategies) {
        return new Game(dimension, players, winningStrategies);

    }

    public void startGame() {
        game.setGameState(GameState.IN_PROGRESS);
        gameService.executeNextMoves();
    }





}
