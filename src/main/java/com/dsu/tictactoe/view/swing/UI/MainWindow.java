package com.dsu.tictactoe.view.swing.UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    private static MainWindow instance;
    private Boolean threadPaused;
    private JPanel jPanel;

    private MainWindow(){
        this.setSize(800,700);
        this.setLocationRelativeTo(null);  
        this.setTitle("MVC DSU TIC TAC TOE");
        this.setVisible(true);
        this.toFront();
        this.requestFocus();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setJPanelStartWaitFor(JPanel jPanel){
        this.jPanel = jPanel;
        this.jPanel.setVisible(true);
        this.add(this.jPanel);
        waitFor();
        this.remove(this.jPanel);
        //SwingUtilities.updateComponentTreeUI(this);
        
    }

    public void setThreadContinue(){
        this.threadPaused = false;
    }

    private void waitFor(){
        //this.setVisible(false);
       
        //SwingUtilities.updateComponentTreeUI(this);
        this.revalidate();
        this.repaint();
    
        
        //this.revalidate();
        //this.repaint();
        //this.setVisible(true);
        this.threadPaused = true;
        while(threadPaused){
            try {
               Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
    }

    public static MainWindow getInstance(){
        if (instance == null){
            instance = new MainWindow();
        }
        return instance;
    }
    
}
