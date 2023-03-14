package com.dsu.tictactoe.view.swing.views.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.model.player.PlayerError;
import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerManagerView;
import com.dsu.tictactoe.view.swing.UI.MainWindow;

public class PlayerManagerSwingView implements PlayerManagerView {

    private MainWindow mainWindow;

    private JTable tablePlayerList;
    private JScrollPane jScrollPane1;

    public PlayerManagerSwingView() {
        mainWindow = MainWindow.getInstance();
    }

    @Override
    public Player getNewPlayer(PlayerError playerError, Player newPlayer, PlayerType[] playerTypevalues) {
        JPanel jPanel = new JPanel();
        JLabel jLabel1 = new JLabel("CREATE PLAYER");
        JButton createPlayerButton = new JButton("Create player");
        JLabel errorJLabel = new JLabel((playerError == PlayerError.NO_ERROR) ? "  " : playerError.getDescription());
        JLabel jLabel2 = new JLabel("Player type:");
        JComboBox playerTypeComboBox = new JComboBox<>(
                new DefaultComboBoxModel<>(PlayerType.getStringArrayPlayerTypes()));
        JLabel jLabel3 = new JLabel("Player name:");
        JTextField nameTextField = new JTextField("  ");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        createPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameTextField.getText().trim().length() < 3) {
                    errorJLabel.setText("The name must have more than three characters.");
                    return;
                }
                mainWindow.setThreadContinue();
            }
        });
        errorJLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        errorJLabel.setForeground(new Color(255, 51, 51));

        playerTypeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (playerTypeComboBox.getSelectedItem().equals(PlayerType.COMPUTER.name())) {
                    nameTextField.setText(getAlphaNumericString(10));
                    nameTextField.setEnabled(false);
                    return;
                }
                nameTextField.setEnabled(true);
                nameTextField.setText("");
            }
        });

        GroupLayout layout = new GroupLayout(jPanel);
        jPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(errorJLabel)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(52, 52, 52)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(createPlayerButton)
                                                        .addGroup(layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(nameTextField)
                                                                .addComponent(playerTypeComboBox, 0, 125,
                                                                        Short.MAX_VALUE)))))
                                .addContainerGap(418, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(playerTypeComboBox, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(createPlayerButton)
                                .addGap(28, 28, 28)
                                .addComponent(errorJLabel)
                                .addContainerGap(166, Short.MAX_VALUE)));

        mainWindow.setJPanelStartWaitFor(jPanel);
        return new Player(nameTextField.getText().trim(),
                PlayerType.valueOf((String) playerTypeComboBox.getSelectedItem()));
    }

    @Override
    public List<Player> getNewGamePlayers(List<Player> allPlayers, int numbePlayers) {
        String[] arrayPlayers = getStringArrayPlayers(allPlayers);
        List<Player> selectedPlayers = new ArrayList<>();

        JPanel jPanel = new JPanel();
        JLabel jLabel1 = new javax.swing.JLabel("SELECT PLAYERS");
        JButton selectPlayerButton = new javax.swing.JButton("Select players");
        JComboBox jComboBox1 = new JComboBox<>(
                new DefaultComboBoxModel<>(filterStringArrayPlayers(arrayPlayers, arrayPlayers[1])));
        JComboBox jComboBox2 = new JComboBox<>(
                new DefaultComboBoxModel<>(filterStringArrayPlayers(arrayPlayers, arrayPlayers[0])));
        JLabel jLabel2 = new javax.swing.JLabel("Player 1");
        JLabel jLabel3 = new javax.swing.JLabel("Player 2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeSelecctionComboBox(jComboBox1, jComboBox2, arrayPlayers);
            }
        });
        jComboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeSelecctionComboBox(jComboBox2, jComboBox1, arrayPlayers);
            }
        });
        selectPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Player player : allPlayers) {
                    if (player.getResumeString().equals(jComboBox1.getSelectedItem())||player.getResumeString().equals(jComboBox2.getSelectedItem())){
                        selectedPlayers.add(player);
                    }
                }
                mainWindow.setThreadContinue();
            }
        });

        GroupLayout layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel1)
                                                        .addGap(450, 450, 450))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(57, 57, 57)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jComboBox2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(selectPlayerButton)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(selectPlayerButton)
                                .addContainerGap(232, Short.MAX_VALUE)));

        mainWindow.setJPanelStartWaitFor(jPanel);
        return selectedPlayers;

    }

    private void changeSelecctionComboBox(JComboBox comboBoxChange, JComboBox comboBoxSecondEfect,
            String[] listPlayers) {
        String secondEfectSelected = (String) comboBoxSecondEfect.getSelectedItem();
        String selectedComboBox = (String) comboBoxChange.getSelectedItem();
        comboBoxSecondEfect
                .setModel(new DefaultComboBoxModel<>(filterStringArrayPlayers(listPlayers, selectedComboBox)));
        comboBoxSecondEfect.setSelectedItem(secondEfectSelected);
    }

    private String[] filterStringArrayPlayers(String[] listPlayers, String filter) {
        String[] newListPlayers = new String[listPlayers.length - 1];
        int index = 0;
        for (String player : listPlayers) {
            if (!(player.equals(filter))) {
                newListPlayers[index] = player;
                index++;
            }
        }

        return newListPlayers;
    }

    private String[] getStringArrayPlayers(List<Player> allPlayers) {
        String[] newListPlayers = new String[allPlayers.size()];
        for (int i = 0; i < newListPlayers.length; i++) {
            newListPlayers[i] = allPlayers.get(i).getResumeString();
        }
        return newListPlayers;
    }

    @Override
    public void showAllPlayers(List<Player> players) {
        JPanel jPanel = new JPanel();
        JLabel jLabel1 = new JLabel("PLAYERS LIST");
        JButton buttonToContinue = new JButton("Click to go back . . .");
        createPlayerListTable(players);
        JLabel errorJLabel = new JLabel((players.size() > 0) ? " " : "No Players created");
        jLabel1.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        errorJLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorJLabel.setForeground(new java.awt.Color(255, 51, 51));
        buttonToContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setThreadContinue();
            }
        });
        GroupLayout layout = new GroupLayout(jPanel);
        jPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(errorJLabel)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(214, 214, 214)
                                                .addComponent(buttonToContinue))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(268, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(errorJLabel)
                                .addGap(23, 23, 23)
                                .addComponent(buttonToContinue)
                                .addContainerGap(92, Short.MAX_VALUE)));
        mainWindow.setJPanelStartWaitFor(jPanel);
    }

    private void createPlayerListTable(List<Player> players) {
        String[][] data = getPlayerListStringArray(players);
        String[] columnNames = { "No.", "Name", "Type" };
        tablePlayerList = new JTable(data, columnNames);
        jScrollPane1 = new JScrollPane(tablePlayerList);
        if (players.size() == 0) {
            tablePlayerList.setVisible(false);
            jScrollPane1.setVisible(false);
        }
    }

    private String[][] getPlayerListStringArray(List<Player> players) {
        if (players.size() == 0) {
            return new String[][] {
                    { "     ", "     ", "     " },
                    { "     ", "     ", "     " }
            };
        }
        String[][] tableObjects = new String[players.size()][3];
        for (int i = 0; i < tableObjects.length; i++) {
            tableObjects[i][0] = i + "";
            tableObjects[i][1] = players.get(i).getName();
            tableObjects[i][2] = players.get(i).getPlayerType().name();
        }
        return tableObjects;
    }

    /**
     * source:
     * https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
     * 
     * @param n
     * @return
     */
    static String getAlphaNumericString(int n) {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
