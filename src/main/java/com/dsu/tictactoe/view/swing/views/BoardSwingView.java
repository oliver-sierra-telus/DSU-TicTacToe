package com.dsu.tictactoe.view.swing.views;

import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.view.interfaces.views.BoardView;
import com.dsu.tictactoe.view.swing.UI.TurnPanel;

public class BoardSwingView implements BoardView {

    @Override
    public void showBoard(Mark[][] matrixMarks) {
        
        TurnPanel turnPanel = TurnPanel.getInstance();
        turnPanel.updateButtonMarks(matrixMarks);
        
    }
    
}
