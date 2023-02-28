package com.dsu.tictactoe.controller;

@FunctionalInterface
public interface ReadyToPlay {
    boolean isReady();

    public static boolean checkIsReady( ReadyToPlay controllerReady){
        return ((controllerReady != null) && (controllerReady.isReady()));
    }
}
