package com.dsu.tictactoe.board;

import com.dsu.tictactoe.utils.Mark;

public class Board {
    private int dimensions = 3;
    private Space[][] board;
    
    public Board() {
        initializeBoard();
    }

    public void initializeBoard(){
        board = new Space[dimensions][dimensions];
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                board[i][j] = new Space(true, Mark.EMPTY, new Coordinate(i, j));
            }
        }
    }

    public void paint(){
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                System.out.print(board[i][j].getMark().getValue() + " ");
            }
            System.out.println();
        }
    }

    public boolean validateChoice(Coordinate coordinate){
        return board[coordinate.getPositionX()][coordinate.getPositionY()].isAvailable();
    }

    public boolean verifyChoiceExistence(){
        boolean choiceExistence = false;
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                if(board[i][j].isAvailable()){
                    choiceExistence = true;
                }
            }
        }
        return choiceExistence;
    }
    
}
