package com.dsu.tictactoe.view.swing.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;

import com.dsu.tictactoe.model.Result;
import com.dsu.tictactoe.view.interfaces.views.TicTacToeView;
import com.dsu.tictactoe.view.swing.UI.MainWindow;

public class TicTacToeSwingView implements TicTacToeView {
    private MainWindow mainWindow;

    public TicTacToeSwingView() {
        mainWindow = MainWindow.getInstance();
    }

    @Override
    public void showInstruccions() {
        JPanel jPanel = new JPanel();
        JLabel jLabel1 = new JLabel("How to play Tic Tac Toe?");
        JLabel jLabel2 = new JLabel(
                "Tic Tac Toe is a puzzle game for two players, called X and O, who take turns marking the spaces in a 3×3 grid. ");
        JLabel jLabel3 = new JLabel(
                "The player who succeeded in placing three respective marks in a horizontal, vertical, or diagonal row wins the game. ");
        JLabel jLabel4 = new JLabel(
                "There is also option to play with single player and device will play with you. Also multiplayer means Human vs Human. ");
        JLabel jLabel5 = new JLabel(
                "You can play free puzzle games with your friends and relatives. TicTacToe is playable both on console and GUI!");
        JLabel jLabel6 = new JLabel("TicTacToe");
        JLabel jLabel7 = new JLabel("Create your players, and use coordenates to put your pieces.");
        JButton jButton1 = new JButton("Continue . . . ");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setThreadContinue();
            }
        });

        jLabel1.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        jButton1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N

        GroupLayout layout = new GroupLayout(jPanel);
        jPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(252, 252, 252)
                                                .addComponent(jLabel6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel7)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(144, 144, 144)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(294, 294, 294)
                                                .addComponent(jButton1)))
                                .addContainerGap(1557, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1)
                                .addContainerGap(188, Short.MAX_VALUE)));

        mainWindow.setJPanelStartWaitFor(jPanel);
    }

    @Override
    public void showStatistics(Result result) {

        JPanel jPanel = new JPanel();
        JLabel jLabel6 = new JLabel("TIC TAC TOE");
        JButton jButton1 = new JButton("Continue . . . ");
        JLabel resultLabel = new JLabel((result.isATie())?"TIE":"Winner: "+result.getWinner().getResumeString());
        JLabel player2Label = new JLabel(result.getPlayers()[0].getResumeString());
        JLabel player1Label = new JLabel(result.getPlayers()[1].getResumeString());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainWindow.setThreadContinue();
                }
            });

        resultLabel.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        resultLabel.setForeground(new java.awt.Color(0, 0, 255));
        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        player1Label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(player2Label)
                            .addComponent(resultLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(502, 502, 502)
                        .addComponent(jButton1)))
                .addContainerGap(1508, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addComponent(player1Label)
                    .addContainerGap(1754, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addComponent(resultLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(player2Label)
                .addGap(54, 54, 54)
                .addComponent(jButton1)
                .addGap(112, 112, 112))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(239, 239, 239)
                    .addComponent(player1Label)
                    .addContainerGap(258, Short.MAX_VALUE)))
        );
        MainWindow.getInstance().setJPanelStartWaitFor(jPanel);
    }

    @Override
    public int mainMenu() {
        JPanel jPanel = new JPanel();
        ButtonGroup buttonGroup1 = new ButtonGroup();
        JLabel jLabel1 = new JLabel("MAIN MENU");
        JLabel errorLabel = new JLabel("Select one option to continue . . .");
        JRadioButton[] jRadioButtons = new JRadioButton[4];
        jRadioButtons[0] = new JRadioButton("1) List players.");
        jRadioButtons[1] = new JRadioButton("2) Create player.");
        jRadioButtons[2] = new JRadioButton("3) Init game.");
        jRadioButtons[3] = new JRadioButton("4) Exit.");
        for (JRadioButton jRadioButton : jRadioButtons) {
            buttonGroup1.add(jRadioButton);
        }
        JButton buttonSelectOption = new JButton("Select option");
        buttonSelectOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setThreadContinue();
            }
        });
        errorLabel.setVisible(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        errorLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 51, 102));

        GroupLayout layout = new GroupLayout(jPanel);
        jPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(108, 108, 108)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jRadioButtons[1])
                                                        .addComponent(jRadioButtons[0])
                                                        .addComponent(jRadioButtons[2])
                                                        .addComponent(jRadioButtons[3])))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(156, 156, 156)
                                                .addComponent(buttonSelectOption))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(errorLabel)
                                                        .addComponent(jLabel1))))
                                .addContainerGap(207, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtons[0])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtons[1])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtons[2])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtons[3])
                                .addGap(18, 18, 18)
                                .addComponent(buttonSelectOption)
                                .addGap(18, 18, 18)
                                .addComponent(errorLabel)
                                .addContainerGap(90, Short.MAX_VALUE)));
        int optionSelected = -1;
        do {
            mainWindow.setJPanelStartWaitFor(jPanel);
            for (int i = 0; i < jRadioButtons.length; i++) {
                if (jRadioButtons[i].isSelected()) {
                    optionSelected = i;
                    break;
                }
            }
            if (optionSelected < 0) {
                errorLabel.setVisible(true);
            }
        } while (optionSelected < 0);
        return (optionSelected + 1);
    }


}
