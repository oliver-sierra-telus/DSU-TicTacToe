package com.dsu.tictactoe.view.interfaces.views;

import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.Player;

public interface TurnView {
    public void startTurn(Player[] players);
    public void playerTurn(Mark turnMark, PutMarkError putMarkError, String playerName);
    public void endTurn(Player[] players, Mark winner);
}
