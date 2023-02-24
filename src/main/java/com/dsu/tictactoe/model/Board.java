package com.dsu.tictactoe.model;

public class Board {

    //           x y
    private Mark[][] matrixMarks;
    private final int MATRIX_DIMENSION=3;
    private int emptySpots = 0;

    public Board(){
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
        return matrixMarks.clone();
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

}   
