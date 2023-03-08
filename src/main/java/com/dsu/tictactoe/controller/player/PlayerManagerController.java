package com.dsu.tictactoe.controller.player;

import java.util.List;

import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.model.player.PlayerError;
import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.ViewSingleton;
import com.dsu.tictactoe.view.interfaces.player.PlayerManagerView;

public class PlayerManagerController {

    private List<Player> players;
    private PlayerManagerView playerManagerView;

    public PlayerManagerController(List<Player> players) {
        playerManagerView = ViewSingleton.getInstance().getPlayerManagerView();
        this.players = players;
    }

    public void showAllPlayers(){
        playerManagerView.showAllPlayers(getPlayers());
    }

    public void createPlayer() {
        PlayerError playerError = PlayerError.NO_ERROR;
        Player newPlayer = null;
        do {
            newPlayer = playerManagerView.getNewPlayer(playerError, newPlayer, PlayerType.values());
            if (newPlayer.getPlayerType() == null) {
                playerError = PlayerError.WRONG_TYPE;
                continue;
            }
            if (newPlayer.getName().trim().length() < 3) {
                playerError = PlayerError.WRONG_NAME;
                continue;
            }
            if (getPlayer(newPlayer.getName()) != null) {
                playerError = PlayerError.REPEATED;
                continue;
            }
            playerError = PlayerError.NO_ERROR;
        } while (playerError != PlayerError.NO_ERROR);
        players.add(newPlayer);
    }

    public PlayerController[] getNewGamePlayers() {
        int playersNeeded = 2 - players.size();
        for (int i = 0; i < playersNeeded; i++) {
            createPlayer();
        }

        List<Player> selectedPlayers = playerManagerView.getNewGamePlayers(getPlayers(), 2);
        // revisar repetidos y que existan
        PlayerController[] playerControllers = new PlayerController[2];
        int index = 0;
        for (Player player : selectedPlayers) {
            System.out.println("entroi");
            playerControllers[index] = PlayerControllerFactory
                    .getController(getPlayer(player.getName()));
            index++;
            System.out.println("salio");
        }
        return playerControllers;
    }

    private Player getPlayer(String name) {
        return players.stream()
                .filter(p -> name.equals(p.getName()))
                .findFirst()
                .orElse(null);
    }

    public List<Player> getPlayers(){
        return List.copyOf(players);
    }

}
