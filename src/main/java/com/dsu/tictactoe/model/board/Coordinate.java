package com.dsu.tictactoe.model.board;

public class Coordinate {
    private int x;
    private int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean isInRange(int min, int max){
        return isInRangeValue(x,min,max) && isInRangeValue(y,min,max);
    }
    
    private boolean isInRangeValue(int value, int min, int max){
        return (value>=min)&&(value<=max);
    }

    public static Coordinate increment(Coordinate coordinate, int incrementX, int incrementY){
        return new Coordinate(coordinate.getX()+incrementX, coordinate.getY()+incrementY);
    }
    
}
