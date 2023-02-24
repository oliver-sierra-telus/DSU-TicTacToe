package com.dsu.tictactoe;

import com.dsu.tictactoe.controller.TictacToeController;
import com.dsu.tictactoe.model.Tictactoe;

public class TictactoeApp {
    private Tictactoe tictactoe;
    private TictacToeController tictacToeController;
    
    public TictactoeApp(){
        tictactoe = new Tictactoe();
        tictacToeController = new TictacToeController(tictactoe);
    }

    public void runGame(){
        tictacToeController.setupGame();
        tictacToeController.initGame();
        tictacToeController.statistics();

    }
}
