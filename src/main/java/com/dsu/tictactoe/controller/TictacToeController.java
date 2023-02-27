package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.controller.player.HumanPlayerController;
import com.dsu.tictactoe.controller.player.PlayerController;
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
        playerController = new HumanPlayerController();
        turnController = new TurnController();
    }

    public void setupGame() {
        ticTacToeView.showInstruccions();
        playerController.setNewGamePlayers();
        tictactoe.newGame(playerController.getPlayers());
        boardController.setBoard(tictactoe.getBoard());
        turnController.setTurn(tictactoe.getTurn());
        turnController.setPlayerController(playerController);
        turnController.setBoardController(boardController);
    }

    public void initGame() {
        turnController.initGame();
    }

    public void statistics() {
        ticTacToeView.showStatistics(turnController.getResult());
    }

}
