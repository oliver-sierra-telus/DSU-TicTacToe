package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.controller.player.ComputerPlayerController;
import com.dsu.tictactoe.controller.player.HumanPlayerController;
import com.dsu.tictactoe.controller.player.PlayerController;
import com.dsu.tictactoe.controller.player.PlayerManagerController;
import com.dsu.tictactoe.model.Tictactoe;
import com.dsu.tictactoe.model.Turn;
import com.dsu.tictactoe.model.board.Board;
import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.view.TicTacToeView;

public class TictacToeController {
    private Tictactoe tictactoe;
    private TicTacToeView ticTacToeView;
    private PlayerManagerController playerManagerController;
    //private PlayerController[] playersController;
    private BoardController boardController;
    private TurnController turnController;
    //private HistoryController historyController;

    public TictacToeController(Tictactoe tictactoe) {
        this.tictactoe = tictactoe;
        this.ticTacToeView = new TicTacToeView();
        boardController = new BoardController();
        turnController = new TurnController();
        playerManagerController = new PlayerManagerController(tictactoe.getPlayers());

        //playersController = new PlayerController[2];
        //playersController[0] = new HumanPlayerController();
        //playersController[1] = new ComputerPlayerController();
        
    }

    public void setupGame() {
        ticTacToeView.showInstruccions();
        //playersController[0].getNewGamePlayer(null, "first");
        //playersController[1].getNewGamePlayer(playersController[0].getPlayer(), "second");
        //tictactoe.newGame(new Player[]{playersController[0].getPlayer(),playersController[1].getPlayer()});
        //boardController.setBoard(tictactoe.getBoard());
        PlayerController[] playersController = playerManagerController.getNewGamePlayers();
        Player[] players = new Player[]{playersController[0].getPlayer(),playersController[1].getPlayer()};
        Board newBoard = new Board();
        Turn newTurn = new Turn(players, newBoard);
        boardController.setBoard(newBoard);
        turnController.setTurn(newTurn);
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
