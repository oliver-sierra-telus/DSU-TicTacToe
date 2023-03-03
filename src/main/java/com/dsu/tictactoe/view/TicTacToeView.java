package com.dsu.tictactoe.view;

import com.dsu.tictactoe.model.Result;
import com.dsu.tictactoe.utils.Console;

public class TicTacToeView {

    public void showInstruccions() {
        Console.printTitle("TicTacToe");
        String whatIs = "Tic Tac Toe is a puzzle game for two players, called X and O, who take turns marking the spaces in a 3×3 grid. The player who succeeded in placing three respective marks in a horizontal, vertical, or diagonal row wins the game. There is also option to play with single player and device will play with you. Also multiplayer means Human vs Human. You can play free puzzle games with your friends and relatives. TicTacToe is playable both on your desktop and on your mobile phone!";
        Console.printLine(whatIs);

        Console.printTitle("How to play Tic Tac Toe?");
        String instructions = "Create your players, and use coordenates to put your pieces.";
        Console.printLine(instructions);
        
    }

    public void showStatistics(Result result) {
        Console.printTitle("Statistics");
        if (result.isATie()){
            Console.printTitle("TIE");
            Console.printLine(result.getPlayers()[0].toString());
            Console.printLine(result.getPlayers()[1].toString());
            return;
        }

        Console.printTitle("Winner: "+result.getWinner().toString());
        Console.printLine("Loser: "+result.getLoser());
        Console.readString("Enter to continue");
    }

    public int mainMenu() {
        int optionSelected = 0;
        do {
            Console.printTitle("Main menu");
            Console.printLine("1) List players.");
            Console.printLine("2) Create player.");
            Console.printLine("3) Init game.");
            Console.printLine("0) Exit.");
            Console.printWhiteLine();
            optionSelected = Console.readInt("Enter your option:");
            if (!(optionSelected>=0 && optionSelected<4)){
                Console.printLine("Error: wrong selection");
            }
            else{
                return optionSelected;
            }
        } while (true);
    }
}
