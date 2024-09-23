package MachineCoding.TicTacToe.controllers;

import MachineCoding.TicTacToe.models.Game;
import MachineCoding.TicTacToe.models.GameState;
import MachineCoding.TicTacToe.models.Player;
import MachineCoding.TicTacToe.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {
    //makeMove
    //undo
    //checkwinner
    //gameState

    public static Game startGame(int dimension, List<Player> players,List<WinningStrategy> winningStrategies){
        return Game.getBuilder().setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }
    public static  void makeMove(Game game){

    }
    public static GameState checkGameState(Game game){
        return game.getGameState();
    }
    public static Player getWinner(Game game){
        return game.getWinner();
    }
    public static void printBoard(Game game) {
        game.printBoard();
    }
    public static void undo(Game game){

    }
}
