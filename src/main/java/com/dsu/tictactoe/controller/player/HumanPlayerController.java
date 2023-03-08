package com.dsu.tictactoe.controller.player;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.PlayerType;

public class HumanPlayerController extends PlayerController {

    public HumanPlayerController() {
        super(PlayerType.HUMAN);
    }

    @Override
    public Coordinate getPutCoordinate(Mark[][] markMatrix, Mark playerMark, PutMarkError putMarkError) {
        return playerView.getCoordinate(putMarkError);
    }

  

    
}
