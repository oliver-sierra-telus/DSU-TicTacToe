package com.dsu.tictactoe.view.swing.views.player;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerView;
import com.dsu.tictactoe.view.swing.UI.TurnPanel;

public class ComputerPlayerSwingview implements PlayerView {

    @Override
    public String getName(String message) {
        return "nada";
    }

    @Override
    public Coordinate getCoordinate(PutMarkError putMarkError, Coordinate possiblCoordinate) {

        TurnPanel turnPanel =  TurnPanel.getInstance();
        turnPanel.setPlayerInstructionsLabel("X: "+possiblCoordinate.getX()+" Y: "+possiblCoordinate.getY() + ". Click on the board.");
        turnPanel.setPossibleMark(possiblCoordinate);
        turnPanel.setInstructionsLabel("Click on the board to continue. The coordinate was selected automatically. ");
        TurnPanel.getInstance().getSelectedCoordinate();
        return possiblCoordinate;
    }

    
}
