package com.dsu.tictactoe.board;

import com.dsu.tictactoe.utils.Mark;

public class Board {
    private int dimensions = 3;
    private Space[][] board;

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        board = new Space[dimensions][dimensions];

        //Fill matrix with empty mark
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                board[i][j] = new Space(Mark.EMPTY, new Coordinate(i, j));
            }
        }
    }

    public void paint() {
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                System.out.print(board[i][j].getMark().getValue() + " ");
            }
            System.out.println();
        }
    }

    public boolean validateChoice(Coordinate coordinate) {
        //Verifies if the given coordinate is emoty (available)
        return board[coordinate.getPositionX()][coordinate.getPositionY()].isAvailable();
    }

    public boolean verifyChoiceExistence() {
        int counter = 0;

        //Verifies if the board isn't full
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (board[i][j].isAvailable()) {
                    counter++;
                }
            }
        }

        //Returns true if there is at least one empty space
        if(counter >= 1){
            return true;
        }else{
            //Means that the board is full
            return false;
        }
    }

    private boolean verifyColumns(Mark mark) {
        int counterColumn1 = 0, counterColumn2 = 0, counterColumn3 = 0;

        //Traverse the board matrix column by column and if there is the given mark the respective counter 
        //for the column increments
        for (int j = 0; j < dimensions; j++) {
            for (int i = 0; i < dimensions; i++) {
                if (board[i][j].getMark().equals(mark)) {
                    if (j == 0) {
                        counterColumn1++;
                    } else if (j == 1) {
                        counterColumn2++;
                    } else {
                        counterColumn3++;
                    }
                }
            }
        }

        //If there is the mark three times in a column, there is a TicTacToe so returns true
        if (counterColumn1 == 3 || counterColumn2 == 3 || counterColumn3 == 3) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verifyRows(Mark mark) {
        int counterRow1 = 0, counterRow2 = 0, counterRow3 = 0;

        //Traverse board matrix row by row and if there is the given mark the resepective counter
        //for the row increments
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (board[i][j].getMark().equals(mark)) {
                    if (j == 0) {
                        counterRow1++;
                    } else if (j == 1) {
                        counterRow2++;
                    } else {
                        counterRow3++;
                    }
                }
            }
        }

        //If there is the mark three times in a row, there is a TicTacToe so returns true
        if (counterRow1 == 3 || counterRow2 == 3 || counterRow3 == 3) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verifyDiagonal(Mark mark) {
        int counter = 0;

        //Traverse board matrix main diagonal and if there is the given mark the
        //counter increments
        for (int i = 0; i < dimensions; i++) {
            if (board[i][i].getMark().equals(mark)) {
                counter++;
            }
        }

        //If the mark is three times in the main diagonal, there is a TicTacToe so returns true
        if (counter == 3) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verifyReverseDiagonal(Mark mark) {
        int counter = 0;

        //Traverse board matrix reverse diagonal and if there is the given mark the
        //counter increments
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                //Operation to check only the reverse diagonal in the matrix
                if((i+j) == (dimensions - 1)){
                    if (board[i][j].getMark().equals(mark)) {
                        counter++;
                    }
                }
            }
        }

        //If the mark is three times in the reverse diagonal, there is a TicTacToe so returns true
        if (counter == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean determineWinner(Mark mark){
        //Check all the win possible ways to make TicTacToc
        //Returns true if it matches one way
        if(verifyColumns(mark) == true || verifyRows(mark) == true || verifyDiagonal(mark) == true || verifyReverseDiagonal(mark) == true){
            return true;
        }else{
            return false;
        }
    }

    public void update(Mark mark, Coordinate coordinate) {
        //Update board when a player puts a mark in a position of the board
        board[coordinate.getPositionX()][coordinate.getPositionY()].setMark(mark);
        paint();
    }

}
