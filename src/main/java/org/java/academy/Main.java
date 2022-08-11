package org.java.academy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String path = "src/main/resources/Words.txt";
    private static WordsRandomizer wordsRandomizer;
    private static GameLevel gameLevel;

    private static Board board;



    public static void main(String[] args) throws IOException {
        initialization();
        Scanner console = new Scanner(System.in);
        Main game = new Main();
        game.gameLevel = game.start(console);

        System.out.println(game.gameLevel);

        memoryBoard();

       /* board = new Board(wordsRandomizer.randomWordsByDifficultyLevel(gameLevel.getLevel()));
        board.createBoard();*/

        System.out.println("Thank you!");



    }

    private static void memoryBoard() {
        board = new Board(wordsRandomizer.randomWordsByDifficultyLevel(gameLevel.getLevel()));
        board.createWordsChoice();
    }

    public static void initialization() throws IOException {
        wordsRandomizer = new WordsRandomizer(path);
    }


    private GameLevel start(Scanner console){

        GameLevel gameLevel;
        System.out.println("Welcome to Words memory game!");
        System.out.println("There are two difficulty levels:  \neasy - 4 word pairs  \nhard - 8 word pairs");
        System.out.println("Enter 'e' to choose level easy or 'h' to choose level hard: ");
        String answer = console.next().toLowerCase();

        while(true){
            if (answer.equals("e")){

                System.out.println("You have chosen level easy");

                int guessChances = 10;
                gameLevel = new GameLevel(GameLevel.DifficultyLevel.EASY, guessChances);

                break;

            } else if (answer.equals("h")){

                System.out.println("You have chosen level hard");

                int guessChances = 15;
                gameLevel = new GameLevel(GameLevel.DifficultyLevel.HARD, guessChances);
                break;

            } else {
                System.out.print("Sorry you have to choose level. Enter 'e' to load level easy or 'h' to load level hard: \n");
                answer = console.next().toLowerCase();
            }

        }
        return gameLevel;

    }


}