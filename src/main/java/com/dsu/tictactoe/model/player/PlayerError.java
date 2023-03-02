package com.dsu.tictactoe.model.player;

public enum PlayerError {
    REPEATED("The player already exists."),
    WRONG_NAME("The player's name is incorrect."),
    WRONG_TYPE("The player's type is incorrect."),
    NO_ERROR("No error. ");

    private String description;

    PlayerError(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString(){
        return getDescription();
    }
}
