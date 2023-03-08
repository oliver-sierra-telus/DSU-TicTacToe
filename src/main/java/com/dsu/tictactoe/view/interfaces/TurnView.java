package com.dsu.tictactoe.view.interfaces;

import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;

public interface TurnView {
    public void playerTurn(Mark turnMark, PutMarkError putMarkError, String playerName);
}
