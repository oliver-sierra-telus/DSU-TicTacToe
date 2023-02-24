package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.Board;
import com.dsu.tictactoe.model.Coordinate;
import com.dsu.tictactoe.model.Mark;
import com.dsu.tictactoe.model.Player;
import com.dsu.tictactoe.model.PutMarkError;
import com.dsu.tictactoe.model.TTTLine;

public class BoardController implements ReadyToPlay {

    private Board board;
    private Mark markWinner;
    private Mark actualMark;

    public void setBoard(Board board) {
        this.board = board;
        this.markWinner = Mark.EMPTY;
        actualMark = Mark.O;
    }

    public boolean isReady() {
        return board != null;
    }

    public boolean isTicTacToe() {
        return markWinner != Mark.EMPTY;
    }

    public boolean isFull() {
        return board.getNumberEmptySpots() == 0;
    }

    public Mark[][] getMarkMatrix() {
        return board.getMatrixMarks();
    }

    public Mark getTurnMark() {
        return actualMark;
    }

    public PutMarkError putMark(Coordinate playerCoordinate) {
        if (!playerCoordinate.isInRange(0, board.getBoardDimension())) {
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
        if (board.getCoordinateMark(coordinate) == Mark.EMPTY) {
            return;
        }
        Mark[][] markMatrix = board.getMatrixMarks();
        for (TTTLine tttLine : TTTLine.values()) {
            if (verifyLine(markMatrix, coordinate, tttLine)) {
                markWinner = board.getCoordinateMark(coordinate);
                return;
            }
        }
    }

    private boolean verifyLine(Mark[][] markMatrix, Coordinate coordinate, TTTLine tttLine) {
        Mark mark = markMatrix[coordinate.getX()][coordinate.getY()];
        int maxRange = markMatrix.length;
        Coordinate testCoordinate = coordinate;
        do {
            if (markMatrix[testCoordinate.getX()][testCoordinate.getY()] != mark) {
                return false;
            }
            testCoordinate = Coordinate.increment(testCoordinate, tttLine.getMoventX(), tttLine.getMoventY());
        } while (testCoordinate.isInRange(0, maxRange));
        testCoordinate = coordinate;
        do {
            if (markMatrix[testCoordinate.getX()][testCoordinate.getY()] != mark) {
                return false;
            }
            testCoordinate = Coordinate.increment(testCoordinate, -tttLine.getMoventX(), -tttLine.getMoventY());
        } while (testCoordinate.isInRange(0, maxRange));
        return false;
    }

    public boolean isATie() {
        return false;
    }

    public Player getWinner() {
        return null;
    }

    public void setNextMark() {
        actualMark = (actualMark == Mark.O) ? Mark.X : Mark.O;
    }

}
