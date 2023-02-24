package com.dsu.tictactoe.model;

public enum Mark {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String STRING_REPRESENT;

    Mark(String stringRepresent){
        this.STRING_REPRESENT = stringRepresent;
    }

    @Override
    public String toString() {
        return this.STRING_REPRESENT;
    }
}
