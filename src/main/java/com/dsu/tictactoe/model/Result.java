package com.dsu.tictactoe.model;

public class Result {
    private Player[] players;
    private boolean isATie;
    private Player winner;

    public Result(Player[] players, boolean isATie, Player winner) {
        this.players = players;
        this.isATie = isATie;
        this.winner = winner;
    }

    public Player[] getPlayers() {
        return players;
    }

    public boolean isATie() {
        return isATie;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser(){
        if (winner==null)
            return null;
        return (winner==players[0])?players[1]:players[0];
    }
    
    
}
