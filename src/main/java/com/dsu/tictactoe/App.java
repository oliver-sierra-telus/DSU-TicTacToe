package com.dsu.tictactoe;

import com.dsu.tictactoe.utils.Console;
import com.dsu.tictactoe.view.ViewSingleton;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] argss ){
        String args = (argss != null && argss.length>0)?argss[0]:"";
        if (args!=null && args.length()>0){
            try {
                int viewType = Integer.parseInt(args);
                if (viewType == 1 || viewType == 2){
                    ViewSingleton.setInstanceType(viewType);
                }
                else{
                    setViewType();
                }
            } catch (Exception e) {
                setViewType();
            }
        }
        else{
            setViewType();
        }
        new TictactoeApp().runGame();
    }

    public static void setViewType(){
        int viewType = 0;
        do {
            Console.printTitle("Select type of views");
            Console.printLine("1) Swing");
            Console.printLine("2) Console");
            viewType = Console.readInt("Select your option: ");
        } while (!(viewType == 1 || viewType == 2));
        ViewSingleton.setInstanceType(viewType);
    }
}
