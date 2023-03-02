package com.dsu.tictactoe.model;

import com.dsu.tictactoe.model.board.Board;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.player.Player;

public class Turn {

    private Mark actualMark;
    private Player[] players;
    private Board board;
    
     
    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Turn(Player[] players, Board board) {
        this.players = players;
        this.board = board;
    }

    public Mark getActualMark() {
        return actualMark;
    }

    public void setActualMark(Mark actualMark) {
        this.actualMark = actualMark;
    }

}
