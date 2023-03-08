package com.dsu.tictactoe.view;

import com.dsu.tictactoe.view.console.BoardView;
import com.dsu.tictactoe.view.console.TicTacToeView;
import com.dsu.tictactoe.view.console.TurnView;
import com.dsu.tictactoe.view.console.player.PlayerManagerView;

public interface ViewFactory {
    PlayerViewFactory getPlayerViewFactory();
    PlayerManagerView getPlayerManagerView();
    BoardView getBoardView();
    TicTacToeView getTicTacToeView();
    TurnView getTurnView();
}
