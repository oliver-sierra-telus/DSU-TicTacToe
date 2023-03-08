package com.dsu.tictactoe.view.interfaces;

import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.console.TicTacToeConsoleView;
import com.dsu.tictactoe.view.console.TurnConsoleView;
import com.dsu.tictactoe.view.console.player.PlayerManagerConsoleView;
import com.dsu.tictactoe.view.interfaces.player.PlayerView;

public interface ViewFactory {
    PlayerView getPlayerView(PlayerType playerType);
    PlayerManagerConsoleView getPlayerManagerView();
    BoardView getBoardView();
    TicTacToeConsoleView getTicTacToeView();
    TurnConsoleView getTurnView();
}
