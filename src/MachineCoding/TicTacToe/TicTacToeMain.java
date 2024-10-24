package MachineCoding.TicTacToe;

import MachineCoding.TicTacToe.controllers.GameController;
import MachineCoding.TicTacToe.exceptions.InvalidMoveExceptions;
import MachineCoding.TicTacToe.models.*;
import MachineCoding.TicTacToe.strategies.winningstrategies.ColumnWinningStrategy;
import MachineCoding.TicTacToe.strategies.winningstrategies.DiagonalWinningStrategy;
import MachineCoding.TicTacToe.strategies.winningstrategies.RowWinningStrategy;
import MachineCoding.TicTacToe.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) throws InvalidMoveExceptions {
        System.out.println("Game Starts");
        Scanner scanner=new Scanner(System.in);
        //int dimension= scanner.nextInt();
        int dimension=3;
        //Take player input
        List<Player> players=new ArrayList<>();
        players.add(new Player(new Symbol('X')," Vish", PlayerType.HUMAN));
        players.add(new Bot(new Symbol('O')," Scal", PlayerType.BOT,BotDifficultyLevel.HARD));
        List<WinningStrategy> winningStrategies=List.of(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        Game game= GameController.startGame(dimension,players,winningStrategies);
        //game.printBoard();
        //let's start playing the game
        while(GameController.checkGameState(game).equals(GameState.IN_PROGRESS)){
            //show the board
            //make a move

            GameController.printBoard(game);
            System.out.println("Do you want to do UNDO ?y/n");
            String isUndo=scanner.next();
            if(isUndo.equalsIgnoreCase("y")){
                //make an undo operation
                GameController.undo(game);
                continue;
            }
                GameController.makeMove(game);

        }
        System.out.println("DEBUG");
    }
}
