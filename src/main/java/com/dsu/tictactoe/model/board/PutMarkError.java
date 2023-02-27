package com.dsu.tictactoe.model.board;

public enum PutMarkError {
    NOT_EMPTY("Space is occupied", true), 
    WRONG_COORDINATES("Coordinates are not valid", true),
    NOT_ERROR("NO ERROR", false);

    private  String DESCRIPTION;
    private boolean IS_ERROR;

    PutMarkError(String description, boolean isError){
        this.DESCRIPTION = description;
        this.IS_ERROR = isError;
    }

    public String getErrorDescription(){
        return DESCRIPTION;
    }
    public boolean isError(){
        return IS_ERROR;
    };
}
