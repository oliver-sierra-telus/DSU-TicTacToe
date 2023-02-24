package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.Board;
import com.dsu.tictactoe.model.Coordinate;
import com.dsu.tictactoe.model.Mark;
import com.dsu.tictactoe.model.PutMarkError;

public class BoardController implements ReadyToPlay {

    private Board board;

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isReady() {
        return board!=null;
    }

    public boolean isTicTacToe() {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public Mark[][] getMarkMatrix() {
        return null;
    }

    public static Mark getTurnMark() {
        return null;
    }

    public PutMarkError putMark(Coordinate playerCoordinate) {
        return null;
    }

}
