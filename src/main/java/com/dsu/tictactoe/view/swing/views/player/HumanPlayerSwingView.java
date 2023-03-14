package com.dsu.tictactoe.view.swing.views.player;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerView;
import com.dsu.tictactoe.view.swing.UI.TurnPanel;

public class HumanPlayerSwingView implements PlayerView {

    @Override
    public String getName(String message) {
        return "nada";
    }

    @Override
    public Coordinate getCoordinate(PutMarkError putMarkError, Coordinate possiblCoordinate) {
        TurnPanel turnPanel = TurnPanel.getInstance();
        turnPanel.setPlayerInstructionsLabel("Click on the board");
        turnPanel.setInstructionsLabel("Click on the box you want to put your mark");
        return TurnPanel.getInstance().getSelectedCoordinate();
    }
    
}
