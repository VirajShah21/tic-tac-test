package org.example.tictactoe.input;

import org.example.tictactoe.CommandLineRenderer;
import org.example.tictactoe.TicTacToeBoard;
import org.example.tictactoe.model.CellSelection;

import java.io.BufferedReader;
import java.io.IOException;

public class CommandLineInputManager {

    private final BufferedReader reader;
    private final InputParser inputParser;
    private final CommandLineRenderer renderer;

    public CommandLineInputManager(BufferedReader reader, InputParser inputParser, CommandLineRenderer renderer) {
        this.reader = reader;
        this.inputParser = inputParser;
        this.renderer = renderer;
    }

    public CellSelection acquireCellSelection(TicTacToeBoard board) throws IOException {
        while(true) {
            String inputStr = reader.readLine();
            try {
                return inputParser.parseInput(inputStr, board);
            } catch (InputMoveException e) {
                this.renderer.renderError(e.getMessage());
            }
        }

    }

}
