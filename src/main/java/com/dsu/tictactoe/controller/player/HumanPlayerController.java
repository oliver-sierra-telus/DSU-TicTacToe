package com.dsu.tictactoe.controller.player;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.player.HumanPlayerView;
import com.dsu.tictactoe.view.player.PlayerView;

public class HumanPlayerController extends PlayerController {

    @Override
    public Coordinate getPutCoordinate(Mark[][] markMatrix, Mark playerMark, PutMarkError putMarkError) {
        return playerView.getCoordinate(putMarkError);
    }

    @Override
    public PlayerView initPlayerView() {
        return new HumanPlayerView();
    }

    @Override
    protected PlayerType initPlayerType() {
        return PlayerType.HUMAN;
    }
    
}
