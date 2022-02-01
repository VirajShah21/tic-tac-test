package org.example.tictactoe;

import org.example.tictactoe.model.CellSelection;
import org.example.tictactoe.model.GameState;
import org.example.tictactoe.model.TicTacToeCell;

import static org.example.tictactoe.model.TicTacToeCell.EMPTY;

public class TicTacToeBoard {

    private final TicTacToeCell[][] cells;

    public TicTacToeBoard() {
        this.cells = new TicTacToeCell[][] { { EMPTY, EMPTY, EMPTY }, { EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY } };
    }

    TicTacToeBoard(TicTacToeCell[][] cells) {
        this.cells = cells;
    }

    public void setCell(CellSelection cell, TicTacToeCell value) {
        this.cells[cell.row()][cell.col()] = value;
    }

    public TicTacToeCell[][] getCells() {
        return this.cells;
    }

    public GameState checkGameState() {
        for (TicTacToeCell[] row : cells) {
            if (row[0] == row[1] && row[1] == row[2] && row[0] != EMPTY) {
                return row[0] == TicTacToeCell.X ? GameState.X_WINS : GameState.O_WINS;
            }
        }

        for (int c = 0; c < 3; c++) {
            if (cells[0][c] == cells[1][c] && cells[1][c] == cells[2][c] && cells[0][c] != EMPTY) {
                return cells[0][c] == TicTacToeCell.X ? GameState.X_WINS : GameState.O_WINS;
            }
        }

        if (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] && cells[0][0] != EMPTY) {
            return cells[0][0] == TicTacToeCell.X ? GameState.X_WINS : GameState.O_WINS;
        }

        if (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0] && cells[0][2] != EMPTY) {
            return cells[0][2] == TicTacToeCell.X ? GameState.X_WINS : GameState.O_WINS;
        }

        return GameState.ONGOING;
    }

    public boolean isLegalMove(CellSelection selection) {
        /*
         * TODO - Based on the current state of the board, is the input selection
         * allowed? Note that this method does not need to check that the row and column
         * are in the right range. The InputParser is already doing that
         */
        return false;
    }

}
