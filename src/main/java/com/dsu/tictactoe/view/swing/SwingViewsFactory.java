package com.dsu.tictactoe.view.swing;

import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.interfaces.ViewsFactory;
import com.dsu.tictactoe.view.interfaces.views.BoardView;
import com.dsu.tictactoe.view.interfaces.views.TicTacToeView;
import com.dsu.tictactoe.view.interfaces.views.TurnView;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerManagerView;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerView;
import com.dsu.tictactoe.view.swing.views.BoardSwingView;
import com.dsu.tictactoe.view.swing.views.TicTacToeSwingView;
import com.dsu.tictactoe.view.swing.views.TurnSwingView;
import com.dsu.tictactoe.view.swing.views.player.ComputerPlayerSwingview;
import com.dsu.tictactoe.view.swing.views.player.HumanPlayerSwingView;
import com.dsu.tictactoe.view.swing.views.player.PlayerManagerSwingView;

public class SwingViewsFactory implements ViewsFactory {

    @Override
    public PlayerView getPlayerView(PlayerType playerType) {
        if (playerType == PlayerType.HUMAN){
            return new HumanPlayerSwingView();
        }
        if (playerType == PlayerType.COMPUTER){
            return new ComputerPlayerSwingview();
        }
        return null;
    }

    @Override
    public PlayerManagerView getPlayerManagerView() {
        return new PlayerManagerSwingView();
    }

    @Override
    public BoardView getBoardView() {
        return new BoardSwingView();
    }

    @Override
    public TicTacToeView getTicTacToeView() {
        return new TicTacToeSwingView();
    }

    @Override
    public TurnView getTurnView() {
        return new TurnSwingView();
    }
    
}
