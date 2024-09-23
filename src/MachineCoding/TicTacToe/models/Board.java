package MachineCoding.TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private  int dimension;
    private List<List<Cell>> board;
    public Board(int dimension){
        this.dimension=dimension;
        board=new ArrayList<>();

        for(int i=0;i<dimension;i++){
        board.add(new ArrayList<>());
        for(int j=0;j<dimension;j++){
            board.get(i).add(new Cell(i,j));
        }
        }
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
