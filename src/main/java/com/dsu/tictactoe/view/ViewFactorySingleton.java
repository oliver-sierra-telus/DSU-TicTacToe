package com.dsu.tictactoe.view;

/**
 * ViewFactorySingleton
 */
public class ViewFactorySingleton {
    private static ViewFactory instance;

    public static ViewFactory getInstance(){
        if (instance!=null){
            return instance;
        }
        instance = new ConsoleViewFactory();
        return instance;
    }
    
}