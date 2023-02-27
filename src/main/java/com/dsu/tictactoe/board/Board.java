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
        return board[coordinate.getPositionX()][coordinate.getPositionY()].isAvailable();
    }

    public boolean verifyChoiceExistence() {
        int counter = 0;

        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (board[i][j].isAvailable()) {
                    counter++;
                }
            }
        }

        if(counter >= 1){
            return true;
        }else{
            return false;
        }
    }

    public boolean verifyColumns(Mark mark) {
        int counterColumn1 = 0, counterColumn2 = 0, counterColumn3 = 0;

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

        if (counterColumn1 == 3 || counterColumn2 == 3 || counterColumn3 == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyRows(Mark mark) {
        int counterRow1 = 0, counterRow2 = 0, counterRow3 = 0;

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

        if (counterRow1 == 3 || counterRow2 == 3 || counterRow3 == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyDiagonal(Mark mark) {
        int counter = 0;

        for (int i = 0; i < dimensions; i++) {
            if (board[i][i].getMark().equals(mark)) {
                counter++;
            }
        }

        if (counter == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyReverseDiagonal(Mark mark) {
        int counter = 0;

        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                //Condicion para tomar en cuenta unicamente la diagonal inversa
                if((i+j) == (dimensions - 1)){
                    if (board[i][j].getMark().equals(mark)) {
                        counter++;
                    }
                }
            }
        }

        if (counter == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean determineWinner(Mark mark){
        if(verifyColumns(mark) == true || verifyRows(mark) == true || verifyDiagonal(mark) == true || verifyReverseDiagonal(mark) == true){
            return true;
        }else{
            return false;
        }
    }

    public void update(Mark mark, Coordinate coordinate) {
        board[coordinate.getPositionX()][coordinate.getPositionY()].setMark(mark);
        paint();
    }

}
