package MachineCoding.TicTacToe.models;

import MachineCoding.TicTacToe.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private static Board board;
    private List<Player> players;
    private  List<Move> moves;
    private  Player winner;
    private  GameState gameState;
    private int nextPlayerIndex;
    private  List<WinningStrategy> winningStrategies;

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
