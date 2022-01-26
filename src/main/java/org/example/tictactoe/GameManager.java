package org.example.tictactoe;

import org.example.tictactoe.input.CommandLineInputManager;
import org.example.tictactoe.model.CellSelection;
import org.example.tictactoe.model.GameState;
import org.example.tictactoe.model.TicTacToeCell;

import java.io.IOException;

public class GameManager {

    private final CommandLineRenderer renderer;
    private final CommandLineInputManager inputManager;

    public GameManager(CommandLineRenderer renderer, CommandLineInputManager inputManager) {
        this.renderer = renderer;
        this.inputManager = inputManager;
    }

    public void runGame() throws IOException {
        var board = new TicTacToeBoard();

        var currPlayer = TicTacToeCell.X;
        var state = GameState.ONGOING;

        while(state == GameState.ONGOING) {
            renderer.renderBoard(board);
            renderer.renderMessage(
                "It is "
                    + (currPlayer == TicTacToeCell.X ? "X's" : "O's")
                    + "turn. Please make a move. Type in a cell selection:"
            );
            CellSelection selection = inputManager.acquireCellSelection(board);
            board.setCell(selection, currPlayer);
            currPlayer = currPlayer == TicTacToeCell.X
                ? TicTacToeCell.O
                : TicTacToeCell.X;
            state = board.checkGameState();
        }

        switch (state) {
            case X_WINS -> renderer.renderMessage("Congrats! X wins");
            case O_WINS -> renderer.renderMessage("Congrats! O wins");
            case TIE -> renderer.renderMessage("Tie game");
            default -> renderer.renderMessage("Something went wrong...");
        }
    }
}
