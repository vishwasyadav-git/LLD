package MachineCoding.TicTacToe.strategies.winningstrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{
    private final Map<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col =move.getCell().getColumn();
        Character achar=move.getPlayer().getSymbol().getaChar();

        if(!colMaps.containsKey(col)){
            colMaps.put(col,new HashMap<>());
        }
        HashMap<Character,Integer> colMap=colMaps.get(col);
        if(!colMap.containsKey(achar)){
            colMap.put(achar,0);
        }
        colMap.put(achar,colMap.get(achar)+1);
        if(colMap.get(achar).equals(board.getSize())){
            return true;
        }
        return false;
    }
}
