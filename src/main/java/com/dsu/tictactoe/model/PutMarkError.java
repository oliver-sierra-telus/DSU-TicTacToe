package com.dsu.tictactoe.model;

public enum PutMarkError {
    NOT_EMPTY("Space is occupied"), 
    WRONG_COORDINATES("Coordinates are not valid"),
    NOT_ERROR("NO ERROR");
    
    private  String DESCRIPTION;

    PutMarkError(String description){
        this.DESCRIPTION = description;
    }

    public String getErrorDescription(){
        return DESCRIPTION;
    }
}
