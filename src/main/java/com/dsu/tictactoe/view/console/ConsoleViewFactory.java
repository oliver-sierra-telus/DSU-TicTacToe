package com.dsu.tictactoe.view.console;

import com.dsu.tictactoe.view.PlayerViewFactory;
import com.dsu.tictactoe.view.PlayerViewSingleton;
import com.dsu.tictactoe.view.ViewFactory;
import com.dsu.tictactoe.view.console.player.PlayerManagerView;

public class ConsoleViewFactory implements ViewFactory {

    @Override
    public PlayerManagerView getPlayerManagerView() {
       return new PlayerManagerView();
    }

    @Override
    public BoardView getBoardView() {
        return new BoardView();
    }

    @Override
    public TicTacToeView getTicTacToeView() {
        return new TicTacToeView();
    }

    @Override
    public TurnView getTurnView() {
        return new TurnView();
    }

    @Override
    public PlayerViewFactory getPlayerViewFactory() {
        return PlayerViewSingleton.getInstance();
    }
    
}
