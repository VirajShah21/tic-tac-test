package org.example.tictactoe;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.example.tictactoe.input.InputParser;
import org.example.tictactoe.input.InputMoveException;
import org.example.tictactoe.model.CellSelection;
import org.example.tictactoe.model.TicTacToeCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserTest {
    /*
     * TODO - Write some tests in this file. You should test the InputParser class.
     * Please test the following behaviors
     * 
     * 1. When a user inputs a valid coordinate string (in the form 2,1 where 2 is
     * the row and 1 is the column) the InputParser returns a CellSelection with
     * what they entered
     * 
     * 2. If the user tries to use a coordinate with an out of bounds row or column,
     * the InputParser throws an InputMoveException
     * 
     * 3. If the user tries to use a coordinate that has too many components, the
     * InputParser throws an InputMoveException
     * 
     * 4. If the user tries to use a coordinate with invalid integer numbers, the
     * InputParser throws an InputMoveException
     * 
     * 5. If the user tries to choose a coordinate in a square that is already
     * filled with another value, the InputParser throws an InputMoveException
     */

    private TicTacToeBoard emptyBoard;
    private TicTacToeBoard filledBoard;

    private InputParser parser;

    @BeforeEach
    void setUp() {
        emptyBoard = new TicTacToeBoard();
        filledBoard = new TicTacToeBoard(new TicTacToeCell[][] { { TicTacToeCell.X, TicTacToeCell.O, TicTacToeCell.X },
                { TicTacToeCell.X, TicTacToeCell.O, TicTacToeCell.X },
                { TicTacToeCell.O, TicTacToeCell.X, TicTacToeCell.O } });

        parser = new InputParser();
    }

    @Test
    public void testValidInput() {
        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String input = String.format("%d,%d", i, j);
                    parser.parseInput(input, emptyBoard);
                }
            }
        } catch (InputMoveException e) {
            fail("Parser threw an exception");
        }
    }

    @Test
    public void testOutOfBoundsInput() {
        assertThrows(InputMoveException.class, () -> {
            parser.parseInput("-1,-1", emptyBoard);
        });
        assertThrows(InputMoveException.class, () -> {
            parser.parseInput("-1,0", emptyBoard);
        });
        assertThrows(InputMoveException.class, () -> {
            parser.parseInput("0,-1", emptyBoard);
        });
        assertThrows(InputMoveException.class, () -> {
            parser.parseInput("3,0", emptyBoard);
        });
        assertThrows(InputMoveException.class, () -> {
            parser.parseInput("0,3", emptyBoard);
        });
        assertThrows(InputMoveException.class, () -> {
            parser.parseInput("3,3", emptyBoard);
        });
    }

    @Test
    public void testTooManyInputs() {
        assertThrows(InputMoveException.class, () -> {
            parser.parseInput("1,1,1", emptyBoard);
        });
    }

    @Test
    public void testInvalidInts() {
        assertThrows(InputMoveException.class, () -> {
            parser.parseInput("a,1", emptyBoard);
        });

        assertThrows(InputMoveException.class, () -> {
            parser.parseInput("1,2.0", emptyBoard);
        });
    }

    @Test
    public void testFilledSquare() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String input = String.format("%d,%d", i, j);
                try {
                    parser.parseInput(input, filledBoard);
                    fail("Parser did not throw an exception");
                } catch (InputMoveException e) {
                    // expected
                }
            }
        }
    }
}