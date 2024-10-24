package MachineCoding.TicTacToe.models;

import MachineCoding.TicTacToe.exceptions.InvalidMoveExceptions;
import MachineCoding.TicTacToe.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private static Board board;
    private static List<Player> players;
    private static List<Move> moves;
    private static Player winner;
    private static GameState gameState;
    private static int nextPlayerIndex;
    private static List<WinningStrategy> winningStrategies;

    public static  Builder getBuilder(){
        return new Builder();
    }
    private  Game(int dimension, List<Player> players,List<WinningStrategy>winningStrategies){
        this.board=new Board(dimension);
        this.players=players;
        this.nextPlayerIndex=0;
        this.gameState=GameState.IN_PROGRESS;
        this.moves=new ArrayList<>();
        this.winningStrategies=winningStrategies;
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void printBoard() {
        board.printBoard();
    }
    private static  boolean validateMove(Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getColumn();
        if(row<0 || row>board.getDimension() || col<0 || col> board.getDimension()){
            return false;
        }

        //cell is empty or not
        if(!board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            return false;
        }
        return true;
    }
    public static void makeMove() throws InvalidMoveExceptions {
        Player currentPlayer=players.get(nextPlayerIndex);
        System.out.println("This is"+currentPlayer.getName() +"'s move");

        //Player will choose the move that they want to do
        Move move=currentPlayer.makeMove(board);

        //Game will validate the move
        if(!validateMove(move)){
            //throw some exception
            throw new InvalidMoveExceptions("Invalid move please try again");
        }

        //Move is valid so apply this move to board
        int row=move.getCell().getRow();
        int col=move.getCell().getColumn();
        Cell cell=board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);
        Move finalMove=new Move(currentPlayer,cell);
        moves.add(finalMove);
        nextPlayerIndex=(nextPlayerIndex+1)% players.size();

        if(checkWinner(finalMove)){
            winner=currentPlayer;
            gameState=GameState.ENDED;
        }else if(moves.size()== board.getDimension()* board.getDimension()){
            gameState=GameState.DRAW;
        }

    }
    private static boolean checkWinner(Move move){
        for (WinningStrategy winningStrategy: winningStrategies){
            if (winningStrategy.checkWinner(board,move)){
                return true;
            }
        }
        return  false;
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private  List<WinningStrategy> winningStrategies;
        //        private  List<Move> moves;
//        private  Player winner;
//        private  GameState gameState;
//        private int nextPlayerIndex;
        public void printBoard() {
            board.printBoard();
        }
        public Move makeMove(){
            //TODO
            return null;
        }
    private Builder(){
        this.players=new ArrayList<>();
        this.dimension=0;
        this.winningStrategies=new ArrayList<>();
    }

    private void validationdimension(){
        if(dimension<0){
            throw new RuntimeException("Dimension can't be negative");
        }
    }
    private void validateBotCount(){
        int count=0;
        for(Player player:players){
            if(player.getPlayerType().equals(PlayerType.BOT)){
                count+=1;
                if(count>1){
                    throw new RuntimeException("Only one bot is allowed per game");
                }
            }
        }
    }
    private void validateUniqueSymbol(){
        Set<Character> symbolSet=new HashSet<>();
        for(Player player:players){
            if(!symbolSet.contains(player.getSymbol().getaChar())){
                symbolSet.add(player.getSymbol().getaChar());
            }else{
                throw new RuntimeException("Symbols should be unique");
            }
        }
    }
    private void validate(){
        validateBotCount();
        validationdimension();
        validateUniqueSymbol();
    }
    public  Game build(){
        //validation starts
        return new Game(dimension,players,winningStrategies);
    }
        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

    }
}
