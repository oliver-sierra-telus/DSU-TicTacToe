package com.dsu.tictactoe.model.player;

public enum PlayerType {
    HUMAN,
    COMPUTER;

    public static PlayerType getPlayerType(int index) {
        if (!(index>=0 && index<PlayerType.values().length)){
            return null;
        }
        return PlayerType.values()[index];
    }
}
