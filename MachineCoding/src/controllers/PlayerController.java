package controllers;

import models.*;
import strategies.botplaying.BotPlayingStrategyFactory;

public class PlayerController {


    public static Player createHumanPlayer(String name, char symbol) {
        assert(!name.isEmpty());
        return HumanPlayer.builder()
                .age(12)
                .playerType(PlayerType.HUMAN)
                .name(name)
                .symbol(symbol)
                .build();
    }


    public static Player createBot(String name, char symbol, DifficultyLevel difficultyLevel) {
        return BotPlayer.builder()
                .name(name)
                .symbol(symbol)
                .playerType(PlayerType.BOT)
                .difficultyLevel(difficultyLevel)
                .botPlayingStrategy(BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel))
                .build();
    }

    private PlayerController(){}

}
