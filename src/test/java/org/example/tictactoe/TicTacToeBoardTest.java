package org.example.tictactoe;

import org.example.tictactoe.model.TicTacToeCell;
import org.junit.jupiter.api.Test;

import static org.example.tictactoe.model.GameState.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.example.tictactoe.model.TicTacToeCell.*;

class TicTacToeBoardTest {

    @Test
    void checkOngoingGame() {
        var board = new TicTacToeBoard(new TicTacToeCell[][]{
            {   X  ,   O  ,   X   },
            { EMPTY, EMPTY, EMPTY },
            { EMPTY, EMPTY, EMPTY }
        });

        assertEquals(ONGOING, board.checkGameState());
    }

    @Test
    void checkPlayerWins() {
        var board = new TicTacToeBoard(new TicTacToeCell[][]{
            {   X  ,   O  ,   X   },
            { EMPTY,   X  , EMPTY },
            { EMPTY,   O  ,   X   }
        });
        assertEquals(X_WINS, board.checkGameState());
    }

    @Test
    void checkDraw() {
        var board = new TicTacToeBoard(new TicTacToeCell[][]{
            {   X  ,   O  ,   X   },
            {   X  ,   X  ,   O   },
            {   O  ,   X  ,   O   }
        });
        assertEquals(TIE, board.checkGameState());
    }
}