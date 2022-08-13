package org.java.academy;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String path = "src/main/resources/Words.txt";
    public static WordsRandomizer wordsRandomizer;
    public static GameLevel gameLevel;

    private static boolean startAgain = true;


    public static void main(String[] args) throws IOException {

        initialization();
        Scanner console = new Scanner(System.in);
        Art.homeScreen();

        while(startAgain) {
            gameLevel = start(console, wordsRandomizer);
            gameLevel.play(console);
            startAgain = ending(console);
            System.out.println("Thank you!");
            System.out.println("Come back soon to play memory again!");
        }
    }

      public static void initialization() throws IOException {
        wordsRandomizer = new WordsRandomizer(path);
    }

    private static GameLevel start(Scanner console, WordsRandomizer wordsRandomizer){

        GameLevel gameLevel;
        System.out.println("Welcome to Words memory game!");
        System.out.println("There are two difficulty levels:  \neasy - 4 word pairs  \nhard - 8 word pairs");
        System.out.println("Enter 'e' to choose level easy or 'h' to choose level hard: ");
        String answer = console.next().toLowerCase();

        while(true){
            if (answer.equals("e")){

                System.out.println("You chose level easy.");

                gameLevel = new GameLevel(DifficultyLevel.EASY, wordsRandomizer);
                break;

            } else if (answer.equals("h")){

                System.out.println("You chose level hard");

                gameLevel = new GameLevel(DifficultyLevel.HARD, wordsRandomizer);
                break;

            } else {
                System.out.print("Sorry you have to choose level. Enter 'e' to load level easy or 'h' to load level hard: \n");
                answer = console.next().toLowerCase();
            }

        }
        return gameLevel;

    }

    private static boolean ending(Scanner console){
        boolean playAgain = false;

        System.out.println("Do you want to play again?");
        System.out.println("Enter 'y' to start memory again or 'n' to exit.");

        String answer = console.next().toLowerCase();

        while(true){
            if(answer.equals("y")){
                playAgain = true;
                break;
            } else if (answer.equals("n")){
                playAgain = false;
                break;
            } else {
                System.out.print("Oops, you've made a mistake! Enter 'y' to start memory again or 'n' to exit. \n");
                answer = console.next().toLowerCase();
            }
        }
        return playAgain;
    }

}