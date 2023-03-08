package com.dsu.tictactoe.view.console;

import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.console.player.ComputerPlayerConsoleView;
import com.dsu.tictactoe.view.console.player.HumanPlayerConsoleView;
import com.dsu.tictactoe.view.console.player.PlayerManagerConsoleView;
import com.dsu.tictactoe.view.interfaces.ViewFactory;
import com.dsu.tictactoe.view.interfaces.player.PlayerView;

public class ConsoleViewFactory implements ViewFactory {

    @Override
    public PlayerManagerConsoleView getPlayerManagerView() {
       return new PlayerManagerConsoleView();
    }

    @Override
    public BoardConsoleView getBoardView() {
        return new BoardConsoleView();
    }

    @Override
    public TicTacToeConsoleView getTicTacToeView() {
        return new TicTacToeConsoleView();
    }

    @Override
    public TurnConsoleView getTurnView() {
        return new TurnConsoleView();
    }

    @Override
    public PlayerView getPlayerView(PlayerType playerType) {
        assert(playerType != null);
        switch (playerType) {
            case HUMAN:
                return new HumanPlayerConsoleView();
            case COMPUTER:
                return new ComputerPlayerConsoleView();
        } 
        return null;
    }
    
}
