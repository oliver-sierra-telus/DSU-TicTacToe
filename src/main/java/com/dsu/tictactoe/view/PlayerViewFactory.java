package com.dsu.tictactoe.view;

import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.console.player.PlayerView;

public interface PlayerViewFactory {
    
    PlayerView getPlayerView(PlayerType playerType);
}
