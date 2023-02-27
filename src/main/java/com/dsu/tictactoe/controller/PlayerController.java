package com.dsu.tictactoe.controller;

import com.dsu.tictactoe.model.Player;
import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.view.PlayerView;

public class PlayerController implements ReadyToPlay{

    private Player[] players;
    private PlayerView playerView;
    private final int NUMBER_PLAYERS = 2;

    public PlayerController(){
        playerView = new PlayerView();
        players = new Player[NUMBER_PLAYERS];
    }

    public void setNewGamePlayers(){
        Player selectedPlayer=null;
        for (int i = 0; i < players.length; i++) {
            if (i!=0){
              selectedPlayer = players[0];
            }
            players[i] = playerView.getPlayer(selectedPlayer);
        }
    }

    public boolean isReady() {
        return players.length==NUMBER_PLAYERS &&  players[0]!=null && players[1].getMark()!= Mark.EMPTY;
    }

    public Player[] getPlayers() {
        assert isReady();
        return players.clone();
    }

    public Coordinate getPutCoordinate(Mark[][] markMatrix, Mark playerMark, PutMarkError putMarkError) {
        return null;
    }

    public Player getAccordingMark(Mark winner) {
        assert winner!=Mark.EMPTY && this.isReady();
        return (players[0].getMark() == winner)?players[0]:players[1];
    }

    public void setPlayersMarks(Mark[] marks) {
        assert isReady() && marks.length==2;
        players[0].setMark(marks[0]);
        players[1].setMark(marks[1]);
    }

}
