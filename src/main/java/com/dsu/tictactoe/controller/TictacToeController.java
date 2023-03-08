package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.controller.player.PlayerController;
import com.dsu.tictactoe.controller.player.PlayerManagerController;
import com.dsu.tictactoe.model.Tictactoe;
import com.dsu.tictactoe.model.Turn;
import com.dsu.tictactoe.model.board.Board;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.view.ViewSingleton;
import com.dsu.tictactoe.view.interfaces.TicTacToeView;

public class TictacToeController {
    private Tictactoe tictactoe;
    private TicTacToeView ticTacToeView;
    private PlayerManagerController playerManagerController;
    private BoardController boardController;
    private TurnController turnController;

    public TictacToeController(Tictactoe tictactoe) {
        this.tictactoe = tictactoe;
        this.ticTacToeView = ViewSingleton.getInstance().getTicTacToeView();
        boardController = new BoardController();
        turnController = new TurnController();
        playerManagerController = new PlayerManagerController(this.tictactoe.getPlayers());        
    }

    public void mainMenu(){
        int optionSelected = 0;
        do {
            optionSelected = ticTacToeView.mainMenu();
            switch (optionSelected) {
                case 1:
                    playerManagerController.showAllPlayers();
                    break;
                case 2:
                    playerManagerController.createPlayer();
                    break;
                case 3:
                    setupGame();
                    initGame();
                    statistics();
                    clearGame();
                    break;
            }
        } while (optionSelected!=0);

    }

    public void setupGame() {
        ticTacToeView.showInstruccions();
        PlayerController[] playersController = playerManagerController.getNewGamePlayers();
        for (PlayerController playerController : playersController) {
            System.out.println(playerController.getPlayer().toString());
        }
        Player[] players = new Player[]{playersController[0].getPlayer(),playersController[1].getPlayer()};
        Board newBoard = new Board();
        boardController.setBoard(newBoard);
        Turn newTurn = new Turn(players, newBoard);
        turnController.setTurn(newTurn, Mark.X);
        turnController.setPlayerController(playersController);
        turnController.setBoardController(boardController);
    }

    public void initGame() {
        turnController.initGame();
    }

    public void clearGame(){
        PlayerController[] playersController = turnController.getPlayersController();
        for (PlayerController playerController : playersController) {
            playerController.setMark(Mark.EMPTY);
        }
    }

    public void statistics() {
        ticTacToeView.showStatistics(turnController.getResult());
    }

}
