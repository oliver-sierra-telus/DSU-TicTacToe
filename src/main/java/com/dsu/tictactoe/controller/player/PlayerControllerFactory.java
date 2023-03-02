package com.dsu.tictactoe.controller.player;

import com.dsu.tictactoe.model.player.Player;

public class PlayerControllerFactory {
    
    public static PlayerController getController(Player player) {
        assert(player!=null && player.getPlayerType()!=null);
        PlayerController controller = null;
        switch (player.getPlayerType()) {
            case HUMAN:
                controller = new HumanPlayerController();
                controller.setPlayer(player);
                return controller;
            case COMPUTER:
                controller = new ComputerPlayerController();
                controller.setPlayer(player);
                return controller;
        }
        return controller;
    }
}
