package com.dsu.tictactoe.view.interfaces;

import com.dsu.tictactoe.model.Result;

public interface TicTacToeView {

    public void showInstruccions();

    public void showStatistics(Result result);

    public int mainMenu();
}
