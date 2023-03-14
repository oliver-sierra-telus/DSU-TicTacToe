package com.dsu.tictactoe.view.console.views;

import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.utils.Console;
import com.dsu.tictactoe.view.interfaces.views.TurnView;

public class TurnConsoleView implements TurnView {

    @Override
    public void playerTurn(Mark turnMark, PutMarkError putMarkError, String playerName) {
        Console.printWhiteLine();
        Console.printTitle("Player Turn: "+turnMark.toString()+" - "+playerName);
        if (putMarkError != PutMarkError.NOT_ERROR){
            Console.printLine("Input error: "+putMarkError.getErrorDescription());
        }
    }

    @Override
    public void startTurn(Player[] players) {
        Console.printTitle("Starting the game");
        for (Player player : players) {
            Console.printLine("Player: "+player.getResumeString());
        }
        Console.readString("Enter to start the game");
    }

    @Override
    public void endTurn(Player[] players, Mark winner) {
        Console.printTitle("End of game");
        if (winner == Mark.EMPTY){
            Console.printTitle("Game ended in a tie");
        }
        else{
            Console.printTitle("The "+winner.name()+"'s won");
        }
        
        Console.readString("Enter to continue . . .");
    }

}
