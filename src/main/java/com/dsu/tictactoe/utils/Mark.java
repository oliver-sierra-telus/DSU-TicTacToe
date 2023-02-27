package com.dsu.tictactoe.utils;

public enum Mark {
    ZERO("0"),
    X("X"),
    EMPTY("-");

    private String value;
 
    Mark(String value) {
        this.value = value;
    }
 
    public String getValue() {
        return value;
    }

    public boolean isAvailable(Mark mark) {
        //If the given mark is type EMPTY it means that the space is available
        if(mark.equals(Mark.EMPTY)){
            return true;
        }else{
            return false;
        }
    }
}
