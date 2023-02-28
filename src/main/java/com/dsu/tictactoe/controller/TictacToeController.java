package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.controller.player.ComputerPlayerController;
import com.dsu.tictactoe.controller.player.HumanPlayerController;
import com.dsu.tictactoe.controller.player.PlayerController;
import com.dsu.tictactoe.model.Tictactoe;
import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.view.TicTacToeView;

public class TictacToeController {
    private Tictactoe tictactoe;
    private TicTacToeView ticTacToeView;
    private PlayerController[] playersController;
    private BoardController boardController;
    private TurnController turnController;
    //private HistoryController historyController;

    public TictacToeController(Tictactoe tictactoe) {
        this.tictactoe = tictactoe;
        this.ticTacToeView = new TicTacToeView();
        boardController = new BoardController();
        playersController = new PlayerController[2];
        playersController[0] = new HumanPlayerController();
        playersController[1] = new ComputerPlayerController();
        turnController = new TurnController();
    }

    public void setupGame() {
        ticTacToeView.showInstruccions();
        playersController[0].getNewGamePlayer(null, "first");
        playersController[1].getNewGamePlayer(playersController[0].getPlayer(), "second");
        tictactoe.newGame(new Player[]{playersController[0].getPlayer(),playersController[1].getPlayer()});
        boardController.setBoard(tictactoe.getBoard());
        turnController.setTurn(tictactoe.getTurn());
        turnController.setPlayerController(playersController);
        turnController.setBoardController(boardController);
    }

    public void initGame() {
        turnController.initGame();
    }

    public void statistics() {
        ticTacToeView.showStatistics(turnController.getResult());
    }

}
