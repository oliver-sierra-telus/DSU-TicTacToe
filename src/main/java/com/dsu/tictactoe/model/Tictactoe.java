package com.dsu.tictactoe.model;

import com.dsu.tictactoe.model.board.Board;
import com.dsu.tictactoe.model.player.Player;

public class Tictactoe {

    private Board board;
    private Turn turn; 
    private Player[] players;

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void newGame(Player[] players) {
        this.players = players;
        this.board = new Board();
        this.turn = new Turn();
    }

    public Board getBoard() {
        return board;
    }

    public Turn getTurn() {
        return turn;
    }

}
