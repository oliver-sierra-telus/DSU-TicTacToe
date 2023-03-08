package com.dsu.tictactoe.controller.player;

import java.util.Random;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.console.player.ComputerPlayerConsoleView;

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
            ((ComputerPlayerConsoleView)playerView).showThinkingAboutTheCoordinate(coordinateX,coordinateY);
        } while (markMatrix[coordinateX][coordinateY]!= Mark.EMPTY);
        ((ComputerPlayerConsoleView)playerView).turnFinish();
        return new Coordinate(coordinateX, coordinateY);

    }
    
}
