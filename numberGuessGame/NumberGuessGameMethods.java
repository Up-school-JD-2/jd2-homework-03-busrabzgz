package org.example.homeworks.algorithmExamples.jdHw.numberGuessGame;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGameMethods {
//0-First we define global variables
    static Scanner n=new Scanner(System.in);
    static int guess=0, counter=0;
    public  static int numberGenerator(){
        Random rnd = new Random();
        int number= rnd.nextInt(101);
        return number;
    }
    static int number=numberGenerator();
//    1-We define the intro part of the game
    public static void displayTitle() {

        System.out.println("=====================================");
        System.out.println("| Welcome to Guess Random Number Game |");
        System.out.println("=====================================");
        System.out.println("");
    }
//    1.1-We define exitMethod of the game
    public static void exitGame(){
        System.out.println("=====================================");
        System.out.println("| You are leaving the game!! Bye Bye... |");
        System.out.println("=====================================");
    }

// 1.2- We define main menu for game
    public static void mainMenu(){
        Scanner s = new Scanner(System.in);
        displayTitle();
        System.out.println("Will this be Singleplayer or Multiplayer?");
        System.out.print("Type 'S' for Singleplayer or 'M' for Multiplayer: ");
        System.out.println('\n'+"Are you leave the game? Type 'E' for leave: ");
        char option = s.next().charAt(0);
        if (option == 'S')
            singlePlayer();
        else if (option == 'M')
            multiPlayer();
        else if (option=='E')
            exitGame();
        else
            System.out.println("ERROR: Invalid Option!");


    }


//2-We define the method of the game according to multi and single user
//2.1-singlePlayer:
    public static void singlePlayer(){
        System.out.println("Single Player mode Selected.");
        System.out.println("");
        displayTitle();
        System.out.println("Please enter your userName:");
        String userName = n.next();

        while (guess!=number) {
            System.out.println("===========================");
            System.out.print("Please guess a Number: ");
            guess = n.nextInt();
            System.out.println("===========================");
            counter++;
            if (number < guess)
                System.out.println("Your guess is Too High!");
            else if (number > guess)
                System.out.println("Your guess is Too Low!");
            System.out.println("");
        }
        System.out.println("========================================");
        System.out.println("| Congrats!"+userName+" You've guessed the Number! |");
        System.out.println("========================================");
        System.out.println("The Number was: "+ guess);
        JFrame frame = new JFrame();

        String[] columnNames = {"UserName", "Tries","Succes"};

        Object[][] data = {
                {"UserName", "Tries","Status"},
                {userName, counter,"Winner"},
        };
        JTable table = new JTable(data, columnNames);

        frame.add(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


//2.2 Multiple player:
    public static void multiPlayer() {
        System.out.println("Multiplayer mode Selected.");
        System.out.println("");
        displayTitle();
        System.out.println("Please enter Player 1's userName:");
        String player1 = n.next();
        System.out.println("Please enter Player 2's userName:");
        String player2 = n.next();


        int guess1 = 0, guess2 = 0;
        String winner = null;
        String loser=null;

        while (guess1!=number && guess2!=number) {
            System.out.println("================================");
            System.out.println(player1+": Guess a Number: ");
            guess1 = n.nextInt();
            System.out.println("================================");
            System.out.println(player2+": Guess a Number: ");
            guess2 = n.nextInt();
            System.out.println("================================");
            System.out.println(player1+" Guessed "+ guess1);
            System.out.println(player2+" Guessed "+ guess2);
            counter++;
            if (number < guess1)
                System.out.println(player1+": Your guess is Too High!");
            else if (number > guess1)
                System.out.println(player1+": Your guess is Too Low!");
            if (number < guess2)
                System.out.println(player2+": Your guess is Too High!");
            else if (number > guess2)
                System.out.println(player2+": Your guess is Too Low!");
            System.out.println("");
        }
        if (guess1==number) {
            System.out.println("============================");
            System.out.println("| Congrats!"+player1 +"Wins! |");
            System.out.println("============================");
            winner = player1;
            loser=player2;

        }
        else if (guess2==number) {
            System.out.println("============================");
            System.out.println("| Congrats!"+player2+" Wins! |");
            System.out.println("============================");
            winner = player2;
            loser=player1;
        }

        System.out.println("The Number was: "+ number);
        System.out.println("");

//We can use Jframe Class  for make tablo abouth winner and loser.This table shows the names of the users,
// the number of attempts and their success.
        int winnerTriesPlayer1=counter;
        int loserTriesPlayer2=counter-1;
        JFrame frame = new JFrame();

        String[] columnNames = {"UserName", "Tries","Succes"};

        Object[][] data = {
                {"UserName", "Tries","Status"},
                {winner, winnerTriesPlayer1,"Winner"},
                {loser, loserTriesPlayer2,"Loser"}
        };
        JTable table = new JTable(data, columnNames);

        frame.add(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}




