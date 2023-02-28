package com.dsu.tictactoe.view.player;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.utils.Console;

public class HumanPlayerView extends PlayerView {

    @Override
    public String getName(String error, String message) {
        if (error!=null ){
            Console.printLine("Error: "+error);
        }
        return Console.readString(message);
    }

    @Override
    public Coordinate getCoordinate(PutMarkError putMarkError) {
        return new Coordinate(Console.readInt("Input coordinate x:"), Console.readInt("Input coordinate y:"));
    }
    
}
/*
 * 
 * 
 *  String getName(String error);

    public Coordinate getCoordinate(PutMarkError putMarkError) {
        
        return new Coordinate(Console.readInt("Input coordinate x:"), Console.readInt("Input coordinate y:"));
    }
 */