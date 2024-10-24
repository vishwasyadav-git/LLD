package MachineCoding.TicTacToe.strategies.botPlayingstrategy;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Cell;
import MachineCoding.TicTacToe.models.CellState;
import MachineCoding.TicTacToe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements  BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        //Iterate over the board and make a move on first empty cell
        for(List<Cell> row:board.getBoard()){
            for(Cell cell: row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
