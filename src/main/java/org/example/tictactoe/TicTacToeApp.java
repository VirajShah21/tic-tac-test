package org.example.tictactoe;

import org.example.tictactoe.input.InputParser;
import org.example.tictactoe.input.CommandLineInputManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeApp {

    public static void main(String[] args) throws IOException {

        var renderer = new CommandLineRenderer(System.out);
        var inputParser = new InputParser();

        var input = new BufferedReader(new InputStreamReader(System.in));
        var inputManager = new CommandLineInputManager(input, inputParser, renderer);

        var gameManager = new GameManager(renderer, inputManager);

        gameManager.runGame();
    }

}
