package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.board.Board;
import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.board.TTTLine;

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
        return board != null && markWinner != null && actualMark != null;
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
        int moventChange = 1;
        for (int i = 0; i < 2; i++) {
            testCoordinate = coordinate;
            testCoordinate = Coordinate.increment(testCoordinate, moventChange*tttLine.getMoventX(), moventChange*tttLine.getMoventY());
            while (testCoordinate.isInRange(0, maxRange)) {    
                if (markMatrix[testCoordinate.getX()][testCoordinate.getY()] != mark) {
                    return false;
                }
                testCoordinate = Coordinate.increment(testCoordinate, moventChange*tttLine.getMoventX(), moventChange*tttLine.getMoventY());
            } 
            moventChange*=-1;
        }
        return true;
    }

    public boolean isATie() {
        return markWinner==Mark.EMPTY && board.getNumberEmptySpots()==0;
    }

    public Mark getWinner() {
        return markWinner;
    }

    public void setNextMark() {
        actualMark = (actualMark == Mark.O) ? Mark.X : Mark.O;
    }

}