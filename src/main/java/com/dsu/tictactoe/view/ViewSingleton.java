package com.dsu.tictactoe.view;

import com.dsu.tictactoe.view.console.ConsoleViewFactory;
import com.dsu.tictactoe.view.interfaces.ViewsFactory;
import com.dsu.tictactoe.view.swing.SwingViewsFactory;

/**
 * ViewFactorySingleton
 */
public class ViewSingleton {
    private static ViewsFactory instance;

    public static ViewsFactory getInstance() {
        if (instance == null) {
            instance = new SwingViewsFactory();
        }
        return instance;
    }

    public static void setInstanceType(int type) {
        if (type == 1) {
            instance = new SwingViewsFactory();
            return;
        }
        instance = new ConsoleViewFactory();
    }
}