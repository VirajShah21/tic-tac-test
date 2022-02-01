package org.example.tictactoe;

import java.io.PrintStream;

import org.example.tictactoe.model.TicTacToeCell;

public class CommandLineRenderer {

    private final PrintStream output;
    static final String BOARD_BORDER = "============";

    public CommandLineRenderer(PrintStream output) {
        this.output = output;
    }

    public void renderBoard(TicTacToeBoard board) {
        output.println(BOARD_BORDER);
        TicTacToeCell[][] cells = board.getCells();
        for (TicTacToeCell[] row : cells) {
            for (int cellIndex = 0; cellIndex < row.length; cellIndex++) {
                switch (row[cellIndex]) {
                    case X:
                        output.print(" X ");
                        break;
                    case O:
                        output.print(" O ");
                        break;
                    case EMPTY:
                        output.print("   ");
                        break;
                }
                if (cellIndex < 2)
                    output.print("|");
            }
            output.println();
        }
        output.println(BOARD_BORDER);

    }

    public void renderMessage(String message) {
        this.output.println(message);
    }

    public void renderError(String message) {
        this.output.println(message);
    }

}
