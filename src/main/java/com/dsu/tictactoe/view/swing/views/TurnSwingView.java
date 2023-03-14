package com.dsu.tictactoe.view.swing.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.view.interfaces.views.TurnView;
import com.dsu.tictactoe.view.swing.UI.MainWindow;
import com.dsu.tictactoe.view.swing.UI.TurnPanel;

public class TurnSwingView implements TurnView {


    @Override
    public void startTurn(Player[] players) {
        // TODO Auto-generated method stub

        TurnPanel.getInstance();
    }

    @Override
    public void playerTurn(Mark turnMark, PutMarkError putMarkError, String playerName) {
        
        TurnPanel turnPanel = TurnPanel.getInstance();
        turnPanel.setActualPlayerLabel(turnMark.toString()+" - "+playerName, turnMark);
        turnPanel.setErrorLabel(putMarkError);
    }

    @Override
    public void endTurn(Player[] players, Mark winner) {
        TurnPanel.finishInstance();

        JPanel jPanel = new JPanel();

        JLabel jLabel6 = new JLabel();
        JButton jButton1 = new JButton();

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("END . . .");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Continue . . . ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainWindow.getInstance().setThreadContinue();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel6)))
                .addContainerGap(1777, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel6)
                .addGap(110, 110, 110)
                .addComponent(jButton1)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        MainWindow.getInstance().setJPanelStartWaitFor(jPanel);
    }
    
}
