package com.dsu.tictactoe.model.board;

public enum TTTLine {
    ROW(new Coordinate(1,0)),
    COLUMN(new Coordinate(0,1)),
    DIAGONAL(new Coordinate(1,1)),
    INVERTED_DIAGONAL(new Coordinate(1,-1));

    private Coordinate direction;
    private Coordinate invertDirection;

    private TTTLine(Coordinate direction) {
        this.direction = direction;
        invertDirection = new Coordinate(direction.getX()*-1, direction.getY()*-1);
    }

    public Coordinate getDirection(){
        return direction;
    }

    public Coordinate getInvertDirection(){
        return invertDirection;
    }
}
