package com.dsu.tictactoe.board;

import com.dsu.tictactoe.utils.Mark;

public class Space {
    private Mark mark;
    private Coordinate coordinate;
    
    public Space(Mark mark, Coordinate coordinate) {
        this.mark = mark;
        this.coordinate = coordinate;
    }

    public boolean isAvailable() {
        return mark.isAvailable(mark);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
    
}
