package com.dsu.tictactoe;

import java.util.ArrayList;

public class Statistic {
    private ArrayList<String> statistics = new ArrayList<String>();

    public void addStatistic(String message){
        statistics.add(message);
    }
}
