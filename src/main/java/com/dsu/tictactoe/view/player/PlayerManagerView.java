package com.dsu.tictactoe.view.player;

import java.util.List;

import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.model.player.PlayerError;
import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.utils.Console;

public class PlayerManagerView {

    public Player getNewPlayer(PlayerError playerError, Player newPlayer, PlayerType[] playerTypevalues) {
        if (PlayerError.NO_ERROR != playerError){
            Console.printLine("Error: "+ playerError.getDescription());
            if (newPlayer!=null){
                Console.printLine("     "+newPlayer.toString());
                Console.printLine("End error.\n");
            }
        }
        Console.printTitle("New player");
        String name = Console.readString("Name for the new player: ");
        int selectedType = 0;
        do {
            Console.printWhiteLine();
            Console.printLine("Select the player type: ");
            for (int i = 0; i < playerTypevalues.length; i++) {
                Console.printLine(i+") "+playerTypevalues[i].name().toLowerCase());
            }
            Console.printWhiteLine();
            selectedType = Console.readInt("Select the type:");
        } while (selectedType>=0 && selectedType<playerTypevalues.length);
        Player player = new Player(name);
        player.setPlayerType(playerTypevalues[selectedType]);
        return player;
    }

    public List<Player> getNewGamePlayers(List<Player> copyOf) {
        return null;
    }

}
