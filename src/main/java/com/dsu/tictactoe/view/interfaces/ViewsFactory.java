package com.dsu.tictactoe.view.interfaces;

import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.interfaces.views.BoardView;
import com.dsu.tictactoe.view.interfaces.views.TicTacToeView;
import com.dsu.tictactoe.view.interfaces.views.TurnView;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerManagerView;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerView;


public interface ViewsFactory {
    PlayerView getPlayerView(PlayerType playerType);
    PlayerManagerView getPlayerManagerView();
    BoardView getBoardView();
    TicTacToeView getTicTacToeView();
    TurnView getTurnView();
}