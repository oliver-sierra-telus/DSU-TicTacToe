package com.dsu.tictactoe.controller.player;

import com.dsu.tictactoe.controller.ReadyToPlay;
import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.Mark;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.model.player.PlayerType;
import com.dsu.tictactoe.view.ViewSingleton;
import com.dsu.tictactoe.view.interfaces.views.player.PlayerView;

public abstract class PlayerController implements ReadyToPlay{

    protected Player player;
    protected PlayerView playerView;
    protected PlayerType playerType;

    public PlayerController(PlayerType playerType){
        this.playerType = playerType;
        this.playerView = ViewSingleton.getInstance().getPlayerView(playerType);
    }

    public abstract Coordinate getPutCoordinate(Mark[][] markMatrix, Mark playerMark, PutMarkError putMarkError);    

    public boolean isReady() {
        return player!=null && player.getMark()!= Mark.EMPTY && player.getPlayerType()!=null;
    }    

    public Player getPlayer() {
        assert this.isReady();
        return this.player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setMark(Mark mark) {
        player.setMark(mark);
    }

    public Mark getMark() {
        return player.getMark();
    }

    public String getName() {
        return player.getName();
    }
}
