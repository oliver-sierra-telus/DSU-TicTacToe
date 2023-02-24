package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.Coordinate;
import com.dsu.tictactoe.model.Player;

public class PlayerController implements ReadyToPlay{

    private Player[] players;

    public Player[] getPlayersNewGame() {
        return null;
    }

    public boolean isReady() {
        return players!=null && players.length==2;
    }

    public Coordinate getCoordinate(Object markMatrix, Object turnMark) {
        return null;
    }

}
