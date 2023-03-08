package com.dsu.tictactoe.view.console.player;

import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.PlayerViewFactory;



//singleton
public class PlayerViewConsoleFactory implements PlayerViewFactory {



    @Override
    public PlayerView getPlayerView(PlayerType playerType) {
        assert(playerType != null);
        switch (playerType) {
            case HUMAN:
                return new HumanPlayerView();
            case COMPUTER:
                return new ComputerPlayerView();
        }
        return null;
    }
}
