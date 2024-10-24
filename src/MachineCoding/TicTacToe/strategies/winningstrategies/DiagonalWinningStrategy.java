package MachineCoding.TicTacToe.strategies.winningstrategies;

import MachineCoding.TicTacToe.models.Board;
import MachineCoding.TicTacToe.models.Move;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    HashMap<Character,Integer> leftDiagonal=new HashMap<>();//starting from 0,0
    HashMap<Character,Integer> rightDiagonal=new HashMap<>(); // starting from 0,n-1

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row=move.getCell().getRow();
        int col=move.getCell().getColumn();

        Character aChar=move.getPlayer().getSymbol().getaChar();

        //condition for left diagonal roew==col
        if(row == col){
            if(!leftDiagonal.containsKey(aChar)){
                leftDiagonal.put(aChar,0);
            }
            leftDiagonal.put(aChar,leftDiagonal.get(aChar)+1);
        }

        if(row+col== board.getDimension()-1){
            if(!rightDiagonal.containsKey(aChar)){
                rightDiagonal.put(aChar,0);
            }
            rightDiagonal.put(aChar,rightDiagonal.get(aChar)+1);
        }
        if(row==col && leftDiagonal.get(aChar)== board.getDimension()){
            return true;
        }
        if(row+col== board.getDimension()-1 && rightDiagonal.get(aChar)== board.getDimension()){
            return true;
        }
        return false;
    }
}
