package com.dsu.tictactoe.view.console.views.player;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.utils.Console;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerView;

public class HumanPlayerConsoleView implements PlayerView{

    @Override
    public String getName( String message) {
        return Console.readString(message);
    }

    @Override
    public Coordinate getCoordinate(PutMarkError putMarkError, Coordinate possiblCoordinate) {
        return new Coordinate(Console.readInt("Input coordinate x:"), Console.readInt("Input coordinate y:"));
    }
    
}