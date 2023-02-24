package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.Coordinate;
import com.dsu.tictactoe.model.Mark;
import com.dsu.tictactoe.model.Player;
import com.dsu.tictactoe.model.PutMarkError;

public class PlayerController implements ReadyToPlay{

    private Player[] players;

    public Player[] getPlayersNewGame() {
        return null;
    }

    public boolean isReady() {
        return players!=null && players.length==2;
    }

 

    public Player[] getPlayers() {
        return null;
    }

    public Coordinate getPutCoordinate(Mark[][] markMatrix, Mark playerMark, PutMarkError putMarkError) {
        return null;
    }

}
