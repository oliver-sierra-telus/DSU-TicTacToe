package com.dsu.tictactoe.controller.player;

import java.util.List;
import java.util.stream.Collectors;

import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.model.player.PlayerError;
import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.player.PlayerManagerView;

public class PlayerManagerController {

    private List<Player> players;
    private PlayerManagerView playerManagerView;

    public PlayerManagerController(List<Player> players) {
        this.players = players;
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
            final Player finalPlayer = newPlayer;
            List<Player> result = players.stream().filter(p -> finalPlayer.equals(p)).collect(Collectors.toList());
            if (result.size() != 0) {
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

        List<Player> selectedPlayers = playerManagerView.getNewGamePlayers(List.copyOf(players));
        //revisar repetidos y que existan
        PlayerController[] playerControllers = new PlayerController[2];
        int index =0;
        for (Player player : selectedPlayers) {
            final Player playerfinal = player;
            playerControllers[index] = PlayerControllerFactory
                    .getController(players.stream()
                                    .filter(p -> p.equals(playerfinal))
                                    .findFirst()
                                    .get());
            index++;
        }

        return playerControllers;
    }

}
