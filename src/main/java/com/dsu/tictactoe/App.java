package com.dsu.tictactoe;

public class App {
    public static void main(String[] args) {
        TTTGame game = new TTTGame();
        game.setup();
        game.execute();
        game.statistics();
    }
}
