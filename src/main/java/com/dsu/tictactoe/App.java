package com.dsu.tictactoe;

import com.dsu.tictactoe.board.Board;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        /*TTTGame game = new TTTGame();
        game.setup();
        game.execute();
        game.statistics();*/

        Board board = new Board();
        board.paint();

        /*
         * for (Mark mark : Mark.values()) {
         * System.out.println(mark.name() + " :: " + mark.getValue());
         * }
         */
    }
}
