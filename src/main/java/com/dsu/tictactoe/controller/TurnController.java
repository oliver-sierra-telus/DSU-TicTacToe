package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.Coordinate;
import com.dsu.tictactoe.model.Mark;
import com.dsu.tictactoe.model.PutMarkError;
import com.dsu.tictactoe.model.Turn;
import com.dsu.tictactoe.view.TurnView;

public class TurnController {

    private Turn turn;
    private BoardController boardController;
    private PlayerController playerController;
    private TurnView turnView;

    public TurnController(){
        turnView = new TurnView();
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public void setBoardController(BoardController boardController) {
        this.boardController = boardController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public void initGame() {
        assert verifiedAllIsSetUp();
        PutMarkError putMarkError = PutMarkError.NOT_ERROR;
        Coordinate playerCoordinate;
        Mark playerMark;
        Mark[][] markMatrix;
        do {
            markMatrix = boardController.getMarkMatrix();
            putMarkError = PutMarkError.NOT_ERROR;
            do {
                playerMark = BoardController.getTurnMark();
                turnView.playerTurn(playerMark, putMarkError);
                playerCoordinate = playerController.getCoordinate(markMatrix,playerMark);
                putMarkError = boardController.putMark(playerCoordinate);
            } while (putMarkError != PutMarkError.NOT_ERROR);

        } while (!boardController.isTicTacToe() && !boardController.isFull());
    }

    public Object getResult() {
        assert verifiedAllIsSetUp();
        return null;
    }

    private boolean verifiedAllIsSetUp() {
        return (turn != null) && isBoardSetUp() && isPlayerSetUp();
    }

    private boolean isBoardSetUp() {
        return ((boardController != null) && (boardController.isReady()));
    }

    private boolean isPlayerSetUp() {
        return ((playerController != null) && (playerController.isReady()));
    }

}
