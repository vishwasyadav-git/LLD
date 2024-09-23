package MachineCoding.TicTacToe.factory;

import MachineCoding.TicTacToe.models.BotDifficultyLevel;
import MachineCoding.TicTacToe.strategies.botPlayingstrategy.BotPlayingStrategy;
import MachineCoding.TicTacToe.strategies.botPlayingstrategy.EasyBotPlayingStrategy;
import MachineCoding.TicTacToe.strategies.botPlayingstrategy.HardBotPlayingStrategy;
import MachineCoding.TicTacToe.strategies.botPlayingstrategy.MediumBotPlayingStrategy;

public class BotPlayingFactory {
    public static BotPlayingStrategy getBotPlayingStrategyFactory(BotDifficultyLevel botDifficultyLevel) {
    if(botDifficultyLevel.equals(botDifficultyLevel.EASY)){
        return new EasyBotPlayingStrategy();
    }else if(botDifficultyLevel.equals(botDifficultyLevel.MEDIUM)){
        return new MediumBotPlayingStrategy();
    }else{
        return new HardBotPlayingStrategy();
    }

    }
}
