package com.dsu.tictactoe.utils;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(){
        int responseInt = 0;
        boolean error = false;
        do {
            try {
                responseInt = scanner.nextInt();
                error = false;
    
            } catch (Exception e) {
                error =  true;
            }
        } while (error);
        return  responseInt;
    }

    public static String getStringNext(){
        return scanner.next();
    }
}