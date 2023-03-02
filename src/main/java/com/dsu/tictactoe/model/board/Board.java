package com.dsu.tictactoe.model.board;

public class Board {

    //           x y
    private Mark[][] matrixMarks;
    private final int MATRIX_DIMENSION=3;
    private int emptySpots = 0;
    private Mark markWinner;

    public Board(){
        markWinner = Mark.EMPTY;
        matrixMarks = new Mark[MATRIX_DIMENSION][MATRIX_DIMENSION];
        emptySpots = MATRIX_DIMENSION*MATRIX_DIMENSION;
        for (int i = 0; i < MATRIX_DIMENSION; i++) {
            for (int j = 0; j < MATRIX_DIMENSION; j++) {
                matrixMarks[i][j]=Mark.EMPTY;
            }
        }   
    }

    public int getBoardDimension() {
        return MATRIX_DIMENSION;
    }

    public int getNumberEmptySpots() {
        return emptySpots;
    }

    public Mark[][] getMatrixMarks(){
        Mark[][] cloneMarks = matrixMarks.clone();
        for (int i = 0; i < cloneMarks.length; i++) {
            cloneMarks[i] = cloneMarks[i].clone();
        }
        return cloneMarks;
    }

    public void putMark(Coordinate coordinate, Mark mark){
        assert coordinate.isInRange(MATRIX_DIMENSION, MATRIX_DIMENSION);
        if (matrixMarks[coordinate.getX()][coordinate.getY()] == Mark.EMPTY){
            emptySpots--;
        }
        matrixMarks[coordinate.getX()][coordinate.getY()]=mark;    
        
    }

    public Mark getCoordinateMark(Coordinate coordinate){
        assert coordinate.isInRange(MATRIX_DIMENSION, MATRIX_DIMENSION);
        return matrixMarks[coordinate.getX()][coordinate.getY()];
    }

    public Mark getMarkWinner() {
        return markWinner;
    }

    public void setMarkWinner(Mark markWinner) {
        this.markWinner = markWinner;
    }


    
}   
