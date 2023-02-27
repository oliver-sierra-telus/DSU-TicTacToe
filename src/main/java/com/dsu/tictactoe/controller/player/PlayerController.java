package com.dsu.tictactoe.controller.player;

import com.dsu.tictactoe.controller.ReadyToPlay;
import com.dsu.tictactoe.model.Player;
import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.view.PlayerView;

public abstract class PlayerController implements ReadyToPlay{

    private Player[] players;
    protected PlayerView playerView;
    private final int NUMBER_PLAYERS = 2;

    public PlayerController(){
        playerView = new PlayerView();
        players = new Player[NUMBER_PLAYERS];
    }

    /**
     * For this reason we create the PutMarkError
     * To avoid code of this type
     */
    public void setNewGamePlayers(){
        players[0] = playerView.getPlayer(null,"first");
        String errorMessage = null;
        do {
            
            players[1] = playerView.getPlayer(errorMessage,"second");
            errorMessage =null;
            if(players[0].equals(players[1])){
                errorMessage = "Repeated player";
            }
        } while (errorMessage!=null);
    }

    public boolean isReady() {
        return players.length==NUMBER_PLAYERS &&  players[0]!=null && players[1].getMark()!= Mark.EMPTY;
    }

    public Player[] getPlayers() {
        assert isReady();
        return players;
    }

    public abstract Coordinate getPutCoordinate(Mark[][] markMatrix, Mark playerMark, PutMarkError putMarkError);

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
