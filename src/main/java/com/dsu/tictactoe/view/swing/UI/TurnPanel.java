package com.dsu.tictactoe.view.swing.UI;

import java.awt.Font;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;

public class TurnPanel extends JPanel {

        private static TurnPanel instance;
        private JLabel actualPlayerLabel;
        private JLabel playerInstrucctionsLabel;
        private JLabel instructionsJLabel;
        private JLabel errorLabel;
        private JTextArea logsTextArea;
        private TurnMarkButton[][] marks;
        private Coordinate selectedCoordinate;

        public static TurnPanel getInstance() {
                if (instance == null) {
                        instance = new TurnPanel();
                }
                return instance;
        }

        private TurnPanel() {
                initComponents();
        }

        public void setInstructionsLabel(String text) {
                this.instructionsJLabel.setText(text);
        }

        public void updateButtonMarks(Mark[][] matrixMarks) {
                for (int x = 0; x < matrixMarks.length; x++) {
                        for (int y = 0; y < matrixMarks.length; y++) {
                                marks[x][y].setMark(matrixMarks[x][y]);
                        }
                }
        }

        public void setPossibleMark(Coordinate possiblCoordinate) {
                marks[possiblCoordinate.getX()][possiblCoordinate.getY()].setText("C");
        }

        public void setPlayerInstructionsLabel(String text) {
                this.playerInstrucctionsLabel.setText(text);
        }

        public void setSelectedCoordinate(Coordinate coordinate) {
                selectedCoordinate = coordinate;
        }

        public Coordinate getSelectedCoordinate() {
                MainWindow.getInstance().setJPanelStartWaitFor(this);
                return selectedCoordinate;
        }

        public void setActualPlayerLabel(String string, Mark turnMark) {
                this.actualPlayerLabel.setText(string);
                setLabelColor(actualPlayerLabel, turnMark);
        }

        public void setErrorLabel(PutMarkError putMarkError) {
                if (putMarkError == PutMarkError.NOT_ERROR) {
                        this.errorLabel.setVisible(false);
                        return;
                }

                this.errorLabel.setText(putMarkError.getErrorDescription());
                this.errorLabel.setVisible(true);
        }

        private void setLabelColor(JLabel label, Mark mark) {
                if (mark == Mark.O) {
                        label.setForeground(new java.awt.Color(153, 0, 153));
                }
                if (mark == Mark.X) {
                        label.setForeground(new java.awt.Color(0, 0, 255));
                }

        }

        public static void finishInstance() {
                instance = null;
        }

        private void initComponents() {

                JLabel jLabel1 = new javax.swing.JLabel();
                JPanel jPanel1 = new JPanel();
                marks = new TurnMarkButton[3][3];
                marks[0][0] = new TurnMarkButton(new Coordinate(0, 0), this);
                marks[1][0] = new TurnMarkButton(new Coordinate(1, 0), this);
                marks[2][0] = new TurnMarkButton(new Coordinate(2, 0), this);
                marks[0][1] = new TurnMarkButton(new Coordinate(0, 1), this);
                marks[1][1] = new TurnMarkButton(new Coordinate(1, 1), this);
                marks[2][1] = new TurnMarkButton(new Coordinate(2, 1), this);
                marks[0][2] = new TurnMarkButton(new Coordinate(0, 2), this);
                marks[1][2] = new TurnMarkButton(new Coordinate(1, 2), this);
                marks[2][2] = new TurnMarkButton(new Coordinate(2, 2), this);

                jPanel1.setBackground(new Color(204, 204, 204));
                actualPlayerLabel = new JLabel();
                playerInstrucctionsLabel = new JLabel();
                JScrollPane jScrollPane1 = new JScrollPane();
                jScrollPane1.setVisible(false);
                logsTextArea = new JTextArea();
                errorLabel = new JLabel();
                instructionsJLabel = new JLabel();
                jLabel1.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
                jLabel1.setText("PLAYING TICTACTOE");

                this.setBackground(new Color(204, 204, 204));
                logsTextArea.setVisible(false);

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(marks[0][0],
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(marks[1][0],
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(marks[2][0],
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(marks[0][1],
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(marks[1][1],
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(marks[2][1],
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(marks[0][2],
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(marks[1][2],
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(marks[2][2],
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                50,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(marks[0][0],
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(marks[1][0],
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(marks[2][0],
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(marks[0][1],
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(marks[1][1],
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(marks[2][1],
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(marks[0][2],
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(marks[1][2],
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(marks[2][2],
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                50,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                actualPlayerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                actualPlayerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                actualPlayerLabel.setText("ACTUAL PLAYER");

                playerInstrucctionsLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                playerInstrucctionsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                playerInstrucctionsLabel.setText("PLAYER PLAYER TYPE ALGO ");

                logsTextArea.setBackground(new java.awt.Color(242, 242, 242));
                logsTextArea.setColumns(20);
                logsTextArea.setRows(5);
                jScrollPane1.setViewportView(logsTextArea);

                errorLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                errorLabel.setForeground(new java.awt.Color(255, 0, 0));
                errorLabel.setText("ERROR");

                instructionsJLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                instructionsJLabel.setForeground(new java.awt.Color(0, 153, 153));
                instructionsJLabel.setText("Click on the board");

                GroupLayout layout = new GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(76, 76, 76)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(errorLabel,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                409,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(instructionsJLabel,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                600,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(jPanel1,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGap(72, 72, 72)
                                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                                                                                .addGroup(layout
                                                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                                                .addGap(6, 6, 6)
                                                                                                                                                                                                .addComponent(
                                                                                                                                                                                                                jScrollPane1,
                                                                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                                244,
                                                                                                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                                .addComponent(actualPlayerLabel,
                                                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                275,
                                                                                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                                .addGap(46, 46, 46)
                                                                                                                                                                .addComponent(playerInstrucctionsLabel,
                                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                350,
                                                                                                                                                                                GroupLayout.PREFERRED_SIZE))))))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(159, 159, 159)
                                                                                                .addComponent(jLabel1)))
                                                                .addContainerGap(411, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jLabel1)
                                                                .addGroup(layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(6, 6, 6)
                                                                                                .addComponent(actualPlayerLabel)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(playerInstrucctionsLabel)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(jScrollPane1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                198,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(61, 61, 61)
                                                                                                .addComponent(jPanel1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                19,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(instructionsJLabel)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(errorLabel)
                                                                .addGap(54, 54, 54)));
        }

        

        

        

}
