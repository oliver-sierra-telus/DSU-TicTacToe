package com.dsu.tictactoe.view.interfaces.views.player;

import java.util.List;

import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.model.player.PlayerError;
import com.dsu.tictactoe.model.player.PlayerType;

public interface PlayerManagerView {
    public Player getNewPlayer(PlayerError playerError, Player newPlayer, PlayerType[] playerTypevalues);
    public List<Player> getNewGamePlayers(List<Player> allPlayers, int numbePlayers);
    public void showAllPlayers(List<Player> players);
}