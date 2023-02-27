package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.Result;
import com.dsu.tictactoe.model.Turn;
import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.controller.player.PlayerController;
import com.dsu.tictactoe.model.Player;
import com.dsu.tictactoe.view.TurnView;

public class TurnController implements ReadyToPlay {

    private BoardController boardController;
    private PlayerController playerController;
    private TurnView turnView;
    private Turn turn;

    public TurnController(){
        turnView = new TurnView();
    }

    public  void setTurn(Turn turn){
        this.turn = turn;
        this.turn.setActualMark(Mark.O);
    }

    public void setBoardController(BoardController boardController) {
        this.boardController = boardController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public void initGame() {
        assert isReady();
        playerController.setPlayersMarks(new Mark[]{Mark.O,Mark.X});
        PutMarkError putMarkError = PutMarkError.NOT_ERROR;
        Coordinate playerCoordinate;
        Mark playerMark;
        Mark[][] markMatrix;
        do {
            playerMark = turn.getActualMark();// turn
            markMatrix = boardController.getMarkMatrix();
            putMarkError = PutMarkError.NOT_ERROR;
            do {
                turnView.playerTurn(playerMark, putMarkError);
                boardController.showBoard();
                playerCoordinate = playerController.getPutCoordinate(markMatrix,playerMark,putMarkError);
                putMarkError = boardController.putMark(playerCoordinate, playerMark);
            } while (putMarkError.isError());
            this.setNextMark();
        } while (!boardController.isTicTacToe() && !boardController.isFull());
    }

    public Result getResult() {
        assert isReady(); //throws exception
        Player winner = (boardController.isATie())?null:playerController.getAccordingMark(boardController.getWinner());
        return new Result(playerController.getPlayers(), boardController.isATie() , winner);
    }

    private boolean checkIsReady( ReadyToPlay controllerReady){
        return ((controllerReady != null) && (controllerReady.isReady()));
    }

    public boolean isReady() {
        return turn!=null && checkIsReady(boardController) && checkIsReady(playerController);
    }

    private void setNextMark() {
        turn.setActualMark((turn.getActualMark() == Mark.O) ? Mark.X : Mark.O);
    }

}
