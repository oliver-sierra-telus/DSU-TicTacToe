package com.dsu.tictactoe;

import com.dsu.tictactoe.board.Board;

public class Round {
    private Board board;
    private Player player1;
    private Player player2;
    private Statistic statistic;
    
    public Round(Board board, Player player1, Player player2, Statistic statistic) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.statistic = statistic;
    }

    public void executeRounds(){
        //TODO
    }
    
}
