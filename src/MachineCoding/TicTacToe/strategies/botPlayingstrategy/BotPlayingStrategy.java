package MachineCoding.TicTacToe.strategies.botPlayingstrategy;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
