package com.dsu.tictactoe.view.swing.UI;

import javax.swing.JButton;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;

public class TurnMarkButton extends JButton {

    private Coordinate coordinate;

    public TurnMarkButton(Coordinate coordinate, TurnPanel turnPanel) {
        this.coordinate = coordinate;
        this.setFont(new java.awt.Font("Segoe UI", 1, 18));
        this.setText(" ");

        this.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnPanel.setSelectedCoordinate(coordinate);
                MainWindow.getInstance().setThreadContinue();
            }
        });

    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setMark(Mark mark) {
        if (mark == Mark.EMPTY) {
            this.setText(" ");
            return;
        }
        if (mark == Mark.O) {
            this.setForeground(new java.awt.Color(153, 0, 153));    
            this.setText(mark.toString());
            return;
        }
        this.setForeground(new java.awt.Color(0, 0, 255));
        
        this.setText(mark.toString());
    }

}
