package com.dsu.tictactoe.model;

public enum TTTLine {
    ROW(1,0),
    COLUMN(0,1),
    DIAGONAL(1,1),
    INVERTED_DIAGONAL(1,-1);

    private int moventX;
    private int moventY;

    private TTTLine(int moventX, int moventY) {
        this.moventX = moventX;
        this.moventY = moventY;
    }

    public int getMoventX() {
        return moventX;
    }

    public int getMoventY() {
        return moventY;
    }
}
