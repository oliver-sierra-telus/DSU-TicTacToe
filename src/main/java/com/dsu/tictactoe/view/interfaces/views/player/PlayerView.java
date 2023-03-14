package com.dsu.tictactoe.view.interfaces.views.player;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.PutMarkError;

public interface PlayerView {
    public abstract String getName(String message);
    public abstract Coordinate getCoordinate( PutMarkError putMarkError, Coordinate possiblCoordinate);
}
