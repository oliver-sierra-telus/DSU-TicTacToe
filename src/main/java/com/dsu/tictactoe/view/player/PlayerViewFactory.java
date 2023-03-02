package com.dsu.tictactoe.view.player;

import com.dsu.tictactoe.model.player.PlayerType;

public class PlayerViewFactory {

    public static PlayerView getPlayerView(PlayerType playerType){
        assert(playerType != null);
        switch (playerType) {
            case HUMAN:
                new HumanPlayerView();
                break;
            case COMPUTER:
                new ComputerPlayerView();
        }
        return null;
    }
    
}
