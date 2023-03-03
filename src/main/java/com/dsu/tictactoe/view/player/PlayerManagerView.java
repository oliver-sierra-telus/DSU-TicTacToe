package com.dsu.tictactoe.view.player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.model.player.PlayerError;
import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.utils.Console;

public class PlayerManagerView {

    

    public Player getNewPlayer(PlayerError playerError, Player newPlayer, PlayerType[] playerTypevalues) {
        if (PlayerError.NO_ERROR != playerError) {
            Console.printLine("Error: " + playerError.getDescription());
            if (newPlayer != null) {
                Console.printLine("     " + newPlayer.toString());
                Console.printLine("Create another player.\n");
            }
        }
        PlayerType playerType;
        Console.printTitle("New player");

        do {
            Console.printWhiteLine();
            Console.printLine("Select the player type: ");
            for (int i = 0; i < playerTypevalues.length; i++) {
                Console.printLine(i + ") " + playerTypevalues[i].name().toLowerCase());
            }
            playerType = PlayerType.getPlayerType(Console.readInt("Select the type: "));
        } while (playerType == null);
        PlayerView newPlayerView = PlayerViewFactory.getPlayerView(playerType);
        String name = newPlayerView.getName("Name for the new player: ");

        Player player = new Player(name);
        player.setPlayerType(playerType);
        return player;
    }

    public List<Player> getNewGamePlayers(List<Player> allPlayers, int numbePlayers) {
        ArrayList<Player> allNewGamePlayers = getArrayListPlayers(allPlayers);
        List<Player> selectedPlayers = new LinkedList<>();
        int numberSelected = 0;
        do {
            Console.printTitle("Select the " + (selectedPlayers.size() + 1));
            printAllPlayers(allNewGamePlayers);
            numberSelected = Console.readInt("Select the player you want to use?");
            if (numberSelected >= 0 && numberSelected < allNewGamePlayers.size()) {
                selectedPlayers.add(allNewGamePlayers.get(numberSelected));
                allNewGamePlayers.remove(numberSelected);
            }
        } while (selectedPlayers.size() < numbePlayers);
        return selectedPlayers;
    }
    
    private ArrayList<Player> getArrayListPlayers(List<Player> allPlayers ){
        ArrayList<Player> newListPlayers = new ArrayList<>();
        for (Player player : allPlayers) {
            newListPlayers.add(player);
        }
        return newListPlayers;
    }

    private void printAllPlayers(List<Player> players) {
        if (players.size() == 0) {
            Console.printTitle("You don't have registered players yet.");
            return;
        }
        for (int i = 0; i < players.size(); i++) {
            Console.printLine(i + ") " + players.get(i));
        }
    }

    public void showAllPlayers(List<Player> players) {
        Console.printTitle("Registered players");
        printAllPlayers(players);
        Console.printWhiteLine();
        Console.readString("Enter to continue");
    }

}
