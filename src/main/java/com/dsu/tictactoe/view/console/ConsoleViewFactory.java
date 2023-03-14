package com.dsu.tictactoe.view.console;

import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.console.views.BoardConsoleView;
import com.dsu.tictactoe.view.console.views.TicTacToeConsoleView;
import com.dsu.tictactoe.view.console.views.TurnConsoleView;
import com.dsu.tictactoe.view.console.views.player.ComputerPlayerConsoleView;
import com.dsu.tictactoe.view.console.views.player.HumanPlayerConsoleView;
import com.dsu.tictactoe.view.console.views.player.PlayerManagerConsoleView;
import com.dsu.tictactoe.view.interfaces.ViewsFactory;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerView;

public class ConsoleViewFactory implements ViewsFactory {

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
