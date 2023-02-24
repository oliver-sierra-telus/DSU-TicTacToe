package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.Player;
import com.dsu.tictactoe.model.Tictactoe;
import com.dsu.tictactoe.view.TicTacToeView;

public class TictacToeController {
    private Tictactoe tictactoe;
    private TicTacToeView ticTacToeView;
    private PlayerController playerController;
    private BoardController boardController;
    private TurnController turnController;
    //private HistoryController historyController;

    public TictacToeController(Tictactoe tictactoe) {
        this.tictactoe = tictactoe;
        this.ticTacToeView = new TicTacToeView();
        boardController = new BoardController();
        playerController = new PlayerController();
        turnController = new TurnController();
    }

    public void setupGame() {
        ticTacToeView.showInstruccions();
        Player[] players = playerController.getPlayersNewGame();
        tictactoe.newGame(players);
        boardController.setBoard(tictactoe.getBoard());
        turnController.setTurn(tictactoe.getTurn());
    }

    public void initGame() {
        turnController.initGame();
    }

    public void statistics() {
        ticTacToeView.showStatistics(turnController.getResult());
    }

}
