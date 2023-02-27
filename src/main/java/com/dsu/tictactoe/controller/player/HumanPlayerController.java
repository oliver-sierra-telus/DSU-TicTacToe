package com.dsu.tictactoe.controller.player;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;

public class HumanPlayerController extends PlayerController {

    @Override
    public Coordinate getPutCoordinate(Mark[][] markMatrix, Mark playerMark, PutMarkError putMarkError) {
        return playerView.getCoordinate(putMarkError);
    }
    
}
