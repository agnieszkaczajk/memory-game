package org.java.academy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<String> listOfWords;
    private GameLevel gameLevel;


    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        listOfWords = new ArrayList<>();
        initialization();
        System.out.println("End of execution!");

        Scanner console = new Scanner(System.in);
        Main game = new Main();
        game.gameLevel = game.start(console);

        System.out.println(game.gameLevel);
    }

    public static void initialization() throws IOException {
        readWordsFile();
    }

    private static void readWordsFile() throws IOException {
        String path = "src/main/resources/Words.txt";
        try(FileInputStream fileInputStream = new FileInputStream(path);
            Scanner s = new Scanner(fileInputStream)) {
            while (s.hasNext()) {
                listOfWords.add(s.next());
            }
        }

    }

    private GameLevel start(Scanner console){

        GameLevel gameLevel;
        System.out.println("Welcome to Words memory game!");
        System.out.println("There are two difficulty levels:  \neasy - 4 word pairs  \nhard - 8 word pairs");
        System.out.println("Enter 'e' to choose level easy or 'h' to choose level hard: ");
        String answer = console.next().toLowerCase();

        while(true){
            if (answer.equals("e")){

                System.out.print("You have chosen level easy");
                String level = "easy";
                int guessChances = 8;
                gameLevel = new GameLevel(level, guessChances);

                break;

            } else if (answer.equals("h")){

                System.out.print("You have chosen level hard");
                String level = "hard";
                int guessChances = 15;
                gameLevel = new GameLevel(level, guessChances);
                break;

            } else {
                System.out.print("Sorry you have to choose level. Enter 'e' to load level easy or 'h' to load level hard: \n");
                answer = console.next().toLowerCase();
            }

        }
        return gameLevel;

    }


}