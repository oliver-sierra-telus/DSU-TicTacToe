package com.dsu.tictactoe.model;

import java.util.LinkedList;
import java.util.List;

import com.dsu.tictactoe.model.board.Board;
import com.dsu.tictactoe.model.player.Player;

public class Tictactoe {

    private Board board;
    private Turn turn; 
    private List<Player> players;

    public Tictactoe(){
        players = new LinkedList<>();
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Turn getTurn() {
        return turn;
    }

}
