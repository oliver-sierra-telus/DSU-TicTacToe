package com.dsu.tictactoe.controller.player;

import java.util.Random;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.PlayerType;

public class ComputerPlayerController extends PlayerController {
   
    public ComputerPlayerController() {
        super(PlayerType.COMPUTER);
    }

    @Override
    public Coordinate getPutCoordinate(Mark[][] markMatrix, Mark playerMark, PutMarkError putMarkError) {
        int coordinateX = 0;
        int coordinateY = 0;
        Random random = new Random();
        int limitRandom = markMatrix.length;
        do {
            coordinateX = random.nextInt(limitRandom);
            coordinateY = random.nextInt(limitRandom);
        } while (markMatrix[coordinateX][coordinateY]!= Mark.EMPTY);
        Coordinate selectedCoordinate = new Coordinate(coordinateX, coordinateY);
        playerView.getCoordinate(putMarkError, selectedCoordinate);
        return selectedCoordinate;

    }
    
}
