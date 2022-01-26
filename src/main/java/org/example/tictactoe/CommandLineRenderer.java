package org.example.tictactoe;

import java.io.PrintStream;

public class CommandLineRenderer {

    private final PrintStream output;
    static final String BOARD_BORDER = "============";
    public CommandLineRenderer(PrintStream output) {
        this.output = output;
    }

    public void renderBoard(TicTacToeBoard board) {
        /*
        * TODO - This function should use the "output" PrintStream to print a command line representation of the board.
        *        Check out how the BoardRendererTest JUnit test expects it to be rendered. This method should not call
        *        renderMessage or renderError. Just directly print to this.output
        * */
    }

    public void renderMessage(String message) {
        this.output.println(message);
    }

    public void renderError(String message) {
        this.output.println(message);
    }

}
