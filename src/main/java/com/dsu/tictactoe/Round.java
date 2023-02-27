package com.dsu.tictactoe;

import com.dsu.tictactoe.board.Board;
import com.dsu.tictactoe.board.Coordinate;

public class Round {
    private Board board;
    private Player player1;
    private Player player2;
    private Statistic statistic;

    public Round(Board board, Player player1, Player player2, Statistic statistic) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.statistic = statistic;
    }

    public void executeRounds() {
        boolean cont = true;

        board.paint();
        while (cont == true) {
            if(board.verifyChoiceExistence() == false){
                return;
            }else{
                executeTurn(player1);
            if (board.determineWinner(player1.getMark()) == true) {
                System.out.println("\nWINNER " + player1.toString() + "\tMARK: " + player1.getMark().getValue());
                cont = false;
            } else {
                cont = true;
                if(board.verifyChoiceExistence() == false){
                    return;
                }else{
                    executeTurn(player2);
                if (board.determineWinner(player2.getMark()) == true) {
                    System.out.println("WINNER " + player2.toString() + "\tMARK: " + player2.getMark().getValue());
                    cont = false;
                } else {
                    cont = true;
                }
                }
            }
            }
        }
    }

    private void executeTurn(Player player) {
        boolean error = false;

        do {
            Coordinate coordinate = player.putPiece();
            if (!board.validateChoice(coordinate)) {
                System.out.println("That space isn't available, try again");
                error = true;
            } else {
                board.update(player.getMark(), coordinate);
                statistic.addStatistic(player.toString() + "\tMARK: " + player.getMark().getValue() +
                        "\tROW: " + (coordinate.getPositionX() + 1) + "\tCOLUMN: " + (coordinate.getPositionY() + 1));
                error = false;
            }
        } while (error == true);

    }

}
