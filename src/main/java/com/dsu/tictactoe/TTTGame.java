package com.dsu.tictactoe;

import java.util.ArrayList;

import com.dsu.tictactoe.board.Board;
import com.dsu.tictactoe.utils.Console;
import com.dsu.tictactoe.utils.Mark;

public class TTTGame {
    private Board board;
    private Round round;
    private Statistic statistic;
    private Player player1;
    private Player player2;
    private ArrayList<Player> playersList = new ArrayList<Player>();

    public void setup() {
        addPlayer();
        setPlayers();
        
        board = new Board();
        statistic = new Statistic();
        round = new Round(board, player1, player2, statistic);
    }

    public void execute() {
        System.out.println("==========STARTING GAME==========");
        System.out.println("Mark for player 1: " + player1.getMark().getValue());
        System.out.println("Mark for player 2: " + player2.getMark().getValue());
        round.executeRounds();
    }

    public void statistics() {
        statistic.displayStatistics();
    }

    private void addPlayer(){
        String name;
        int option = 1;

        do {
            System.out.println("\tADD NEW PLAYER");
            System.out.print("Name: ");
            name = Console.getStringNext();
            playersList.add(new Player(name));
            if(playersList.size() >= 2){
                System.out.print("Add another player? 0. No 1. Yes : ");
                option = Console.getInt();
            }
        } while (option == 1 || playersList.size() < 2);
    }

    private void displayPlayers(){
        for(Player player : playersList){
            System.out.println(player.toString());
        }
    }

    private Player selectPlayer(int counter){
        int id;
        Player foundPlayer = null;

        do{
            displayPlayers();
            System.out.println("SELECT PLAYER #" + counter);
            System.out.print("ID: ");
            id = Console.getInt();
            foundPlayer = searchPlayer(id);
        }while(foundPlayer == null);

        return foundPlayer;
    }

    private void setPlayers(){
        boolean distinct = false;

        do{
            player1 = selectPlayer(1);
            player2 = selectPlayer(2);
            if(player1.equals(player2)){
                System.out.println("Oops! Both players should be different. Try again");
                distinct = false;
            }else{
                distinct = true;
            }
        }while(distinct == false);
        player1.setMark(Mark.X);
        player2.setMark(Mark.ZERO);
    }

    private Player searchPlayer(int id){
        Player foundPlayer = null;
        for(Player player : playersList){
            if(player.getId() == id){
                foundPlayer = player;
            }
        }

        return foundPlayer;
    }
    
}
