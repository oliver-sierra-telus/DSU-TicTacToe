package com.dsu.tictactoe.view;

import com.dsu.tictactoe.view.console.player.PlayerViewConsoleFactory;

public class PlayerViewSingleton {
    private static PlayerViewFactory instance;

    public static PlayerViewFactory getInstance(){
        if (instance != null){
            return instance;
        }
        instance = new PlayerViewConsoleFactory();
        return instance;
    }
}
