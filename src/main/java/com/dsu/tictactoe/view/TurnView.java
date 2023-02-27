package com.dsu.tictactoe.view;

import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.utils.Console;

public class TurnView {

    public void playerTurn(Mark turnMark, PutMarkError putMarkError) {
        Console.printWhiteLine();
        Console.printTitle("Player Turn: "+turnMark.toString());
        if (putMarkError != PutMarkError.NOT_ERROR){
            Console.printLine("Input error: "+putMarkError.getErrorDescription());
        }
    }

}
