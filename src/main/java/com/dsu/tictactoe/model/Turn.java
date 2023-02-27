package com.dsu.tictactoe.model;

import com.dsu.tictactoe.model.board.Mark;

public class Turn {

    private Mark actualMark;
     
    public Mark getActualMark() {
        return actualMark;
    }

    public void setActualMark(Mark actualMark) {
        this.actualMark = actualMark;
    }

}
