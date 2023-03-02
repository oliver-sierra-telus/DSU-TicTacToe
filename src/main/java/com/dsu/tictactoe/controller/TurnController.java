package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.Result;
import com.dsu.tictactoe.model.Turn;
import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.controller.player.PlayerController;
import com.dsu.tictactoe.view.TurnView;

public class TurnController implements ReadyToPlay {

    private BoardController boardController;
    private PlayerController[] playersController;
    private TurnView turnView;
    private Turn turn;

    public TurnController(){
        turnView = new TurnView();
    }

    

    public void setBoardController(BoardController boardController) {
        this.boardController = boardController;
    }

    public void setPlayerController(PlayerController[] playerController) {
        this.playersController = playerController;
    }

    public void setPlayerMarks(Mark[] marks){
        playersController[0].setMark(marks[0]);
        playersController[1].setMark(marks[1]);
    }

    public void initGame() {
        assert isReady();
        setPlayerMarks(new Mark[]{Mark.O,Mark.X});
        PutMarkError putMarkError = PutMarkError.NOT_ERROR;
        Coordinate playerCoordinate;
        PlayerController playerController;
        Mark playerMark;
        Mark[][] markMatrix;
        do {
            playerMark = turn.getActualMark();// turn
            playerController = this.getPlayerController(playerMark);
            markMatrix = boardController.getMarkMatrix();
            putMarkError = PutMarkError.NOT_ERROR;
            do {
                turnView.playerTurn(playerMark, putMarkError, playerController.getName());
                boardController.showBoard();
                playerCoordinate = playerController.getPutCoordinate(markMatrix,playerMark,putMarkError);
                putMarkError = boardController.putMark(playerCoordinate, playerMark);
            } while (putMarkError.isError());
            this.setNextMark();
        } while (!boardController.isTicTacToe() && !boardController.isFull());
        boardController.showBoard();
    }

    private PlayerController getPlayerController(Mark playerMark) {
        assert isReady();
        return (playersController[0].getMark()==playerMark)?playersController[0]:playersController[1];
    }

    public Result getResult() {
        assert isReady(); //throws exception
        Player winner = (boardController.isATie())?null:getPlayerController(boardController.getWinner()).getPlayer();
        return new Result(new Player[]{playersController[0].getPlayer(), playersController[1].getPlayer()}, boardController.isATie() , winner);
    }


    public boolean isReady() {
        return turn!=null && ReadyToPlay.checkIsReady(boardController) && ReadyToPlay.checkIsReady(playersController[0]) && ReadyToPlay.checkIsReady(playersController[1]);
    }

    private void setNextMark() {
        turn.setActualMark((turn.getActualMark() == Mark.O) ? Mark.X : Mark.O);
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

}
