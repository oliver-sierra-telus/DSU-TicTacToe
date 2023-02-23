package com.dsu.tictactoe.board;

import com.dsu.tictactoe.utils.Mark;

public class Space {
    private boolean available;
    private Mark mark;
    private Coordinate coordinate;
    
    public Space(boolean available, Mark mark, Coordinate coordinate) {
        this.available = available;
        this.mark = mark;
        this.coordinate = coordinate;
    }

    public boolean isAvailable() {
        return available;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }



    public Mark getMark() {
        return mark;
    }

    
    
}
