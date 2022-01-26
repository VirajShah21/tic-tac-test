package org.example.tictactoe.input;

import org.example.tictactoe.TicTacToeBoard;
import org.example.tictactoe.model.CellSelection;

public class InputParser {

    public CellSelection parseInput(String inputString, TicTacToeBoard board) throws InputMoveException {
        inputString = inputString.trim();
        String[] parts = inputString.split(",");
        try {
            if(parts.length != 2) {
                throw new InputMoveException("Invalid number of coordinates");
            }
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            if(row < 0 || col < 0 || row > 2 || col > 2) {
                throw new InputMoveException("One of your selections was out of bounds");
            }
            var selection = new CellSelection(row, col);
            if (!board.isLegalMove(selection)) {
                throw new InputMoveException("That is not an allowed move");
            }
            return selection;
        } catch (NumberFormatException e) {
            throw new InputMoveException("Inputs must be numbers");
        }
    }
}

