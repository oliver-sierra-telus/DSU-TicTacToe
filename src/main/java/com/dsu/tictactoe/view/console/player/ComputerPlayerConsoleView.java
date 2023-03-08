package com.dsu.tictactoe.view.console.player;

import com.dsu.tictactoe.model.board.Coordinate;
import com.dsu.tictactoe.model.board.PutMarkError;
import com.dsu.tictactoe.model.player.Player;
import com.dsu.tictactoe.utils.Console;
import com.dsu.tictactoe.view.interfaces.player.PlayerView;

public class ComputerPlayerConsoleView implements PlayerView{

    @Override
    public Player getPlayer(String errorMessage, String numberPlayer) {
        if (errorMessage!=null){
            Console.printLine(errorMessage);
        }
        String name = "";
        do {
            name = getName( "Name of "+numberPlayer+" the player:");
            //Console.readString("Name of "+numberPlayer+" the player:")
            name = name.trim();
            if (name.length()==0){
                errorMessage = "Invalid username, enter again.";;
            }
        } while (name.length()==0);
        return new Player(name);
    }

    @Override
    public String getName( String message) {
        Console.readString("Thinking the name, press enter please . . . ");
        String name = ComputerPlayerConsoleView.getAlphaNumericString(10);
        Console.readString("The name is "+name+" and means nothin xD. Enter to continue. . .");
        return name ;
    }

    @Override
    public Coordinate getCoordinate(PutMarkError putMarkError) {
        if (putMarkError!= PutMarkError.NOT_ERROR){
            Console.printLine("Oh no!, an error :P");
        }
        return null;
    }

    public void turnFinish(){
        Console.readString("Enter to continue . . . ");
    }

    public void showThinkingAboutTheCoordinate(int x, int y ){
        Console.printLine("My possible coordinate is: x"+x+" y: "+y);
    }


    /**
     * source: https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
     * @param n
     * @return
     */
    static String getAlphaNumericString(int n) {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
