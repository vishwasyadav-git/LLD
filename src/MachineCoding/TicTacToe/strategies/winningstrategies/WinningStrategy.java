package MachineCoding.TicTacToe.strategies.winningstrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Cell;
import MachineCoding.TicTacToe.models.Move;
import MachineCoding.TicTacToe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
