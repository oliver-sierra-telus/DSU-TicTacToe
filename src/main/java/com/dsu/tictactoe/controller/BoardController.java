package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.board.Board;
import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.board.TTTLine;
import com.dsu.tictactoe.view.BoardView;

public class BoardController implements ReadyToPlay {

    private Board board;
    private BoardView boardView;

    public BoardController() {
        this.boardView = new BoardView();
    }

    public void setBoard(Board board) {
        this.board = board;
        this.board.setMarkWinner(Mark.EMPTY);
    }

    public boolean isReady() {
        return board != null;
    }

    public boolean isTicTacToe() {
        return board.getMarkWinner() != Mark.EMPTY;
    }

    public boolean isFull() {
        return board.getNumberEmptySpots() == 0;
    }

    public Mark[][] getMarkMatrix() {
        return board.getMatrixMarks();
    }

    public PutMarkError putMark(Coordinate playerCoordinate, Mark actualMark) {
        if (!playerCoordinate.isInRange(0, board.getBoardDimension() - 1)) {
            return PutMarkError.WRONG_COORDINATES;
        }
        if (board.getCoordinateMark(playerCoordinate) != Mark.EMPTY) {
            return PutMarkError.NOT_EMPTY;
        }
        board.putMark(playerCoordinate, actualMark);
        verifyTicTacToe(playerCoordinate);
        return PutMarkError.NOT_ERROR;
    }

    private void verifyTicTacToe(Coordinate coordinate) {
        for (TTTLine tttLine : TTTLine.values()) {
            if (verifyLine(board.getCoordinateMark(coordinate), coordinate, tttLine)) {
                board.setMarkWinner(board.getCoordinateMark(coordinate));
                return;
            }
        }
    }

    private boolean verifyLine(Mark actualMmark, Coordinate coordinate, TTTLine tttLine) {
        Coordinate nextCoordinate = Coordinate.increment(coordinate, tttLine.getDirection());
        int sameMarks = 1 + verifyMarknextPosition(nextCoordinate, tttLine.getDirection(), actualMmark);
        nextCoordinate = Coordinate.increment(coordinate, tttLine.getInvertDirection());
        sameMarks += verifyMarknextPosition(nextCoordinate, tttLine.getInvertDirection(), actualMmark);
        if (sameMarks != this.board.getBoardDimension()) {
            return false;
        }
        board.setMarkWinner(actualMmark);
        return true;
    }

    private int verifyMarknextPosition(Coordinate nextCoordinate, Coordinate direcction, Mark actualMark) {
        if (!nextCoordinate.isInRange(0, this.board.getBoardDimension() - 1)) {
            return 0;
        }
        if (board.getCoordinateMark(nextCoordinate) != actualMark) {
            return 0;
        }
        return 1 + verifyMarknextPosition(Coordinate.increment(nextCoordinate, direcction), direcction, actualMark);
    }

    public boolean isATie() {
        return board.getMarkWinner() == Mark.EMPTY && board.getNumberEmptySpots() == 0;
    }

    public Mark getWinner() {
        return board.getMarkWinner();
    }

    public void showBoard() {
        boardView.showBoard(board.getMatrixMarks());
    }

}