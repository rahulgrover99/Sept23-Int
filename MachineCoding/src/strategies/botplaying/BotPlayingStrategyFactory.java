package strategies.botplaying;

import models.DifficultyLevel;

public class BotPlayingStrategyFactory {
    private static final EasyBotPlayingStrategy easyStrategy = new EasyBotPlayingStrategy();

    public static BotPlayingStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY -> {
                return easyStrategy;
            }
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
        }
        return null;
    }

    private BotPlayingStrategyFactory() {}


}
