package com.dsu.tictactoe.view;

import com.dsu.tictactoe.view.console.ConsoleViewFactory;
import com.dsu.tictactoe.view.interfaces.ViewFactory;

/**
 * ViewFactorySingleton
 */
public class ViewSingleton {
    private static ViewFactory instance;

    public static ViewFactory getInstance(){
        if (instance!=null){
            return instance;
        }
        instance = new ConsoleViewFactory();
        return instance;
    }
}