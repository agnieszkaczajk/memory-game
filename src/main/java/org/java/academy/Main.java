package org.java.academy;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String path = "src/main/resources/Words.txt";
    private static WordsRandomizer wordsRandomizer;
    private static GameLevel gameLevel;

    private static Board board;

    private boolean startAgain = true;



    public static void main(String[] args) throws IOException {
        initialization();
        Scanner console = new Scanner(System.in);
        Main game = new Main();

        while(game.startAgain) {
            game.gameLevel = game.start(console);

            System.out.println(game.gameLevel);

            game.play(console);

            game.ending(console);


            System.out.println("Thank you!");
            System.out.println("Come back soon to play memory again!");
        }


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

                int guessChances = 3;
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

    private void play(Scanner console){


        board = new Board(wordsRandomizer.randomWordsByDifficultyLevel(gameLevel.getLevel()));
        board.createWordsChoice();
        System.out.println(board.printBoard());

        while(gameLevel.guessChances>0) {
            System.out.println("Choose a word to reveal (e.g. A1)!");

            String answer = console.next().toUpperCase();
            //TODO regular expresion to validte inserted field id


            String rowName = answer.substring(0, 1);
            int columnId = Integer.parseInt(answer.substring(1));

            Word one = board.getBoardMap().get(rowName).get(columnId-1);
            one.setUncovered(true);

           System.out.println(board.printBoard());

            System.out.println("Choose second word to reveal!");
            String answer2 = console.next().toUpperCase();

            String rowName2 = answer2.substring(0, 1);
            int columnId2 = Integer.parseInt(answer2.substring(1));

            Word two = board.getBoardMap().get(rowName2).get(columnId2-1);
            two.setUncovered(true);
            System.out.println(board.printBoard());

            if(!one.equals(two)){
                one.setUncovered(false);
                two.setUncovered(false);
                gameLevel.guessChances -= 1;
                System.out.println("Sorry, words did not match. Try again");
                System.out.println(gameLevel.toString());
                System.out.println(board.printBoard());
                System.out.println(gameLevel.guessChances);
                if(gameLevel.guessChances == 0) {
                    System.out.println("Sorry, You're looser!");
                    break;
                }

            } else if (one.equals(two)){

                System.out.println("Yay! This is a pair!");
                System.out.println(gameLevel.toString());
                System.out.println(board.printBoard());
                one.setGuessed(true);
                two.setGuessed(true);

                if(gameLevel.guessChances==0) break;
            } else{
                System.out.println("Ups! something gone wrong! Try egain!");
            }

            if(board.isPlayerWon()){
                System.out.println("Congratulations! You're winner! ");
                break;
            }

        }

    }

    private boolean ending(Scanner console){


        System.out.println("Do you want to play again?");
        System.out.println("Enter 'y' to start memory again or 'n' to exit.");

        String answer = console.next().toLowerCase();

        if(answer.equals("y")){
            startAgain = true;
        } else if (answer.equals("n")){
            startAgain = false;
        } else {
            System.out.print("Ups, You have mistaken! Enter 'y' to start memory again or 'n' to exit. \n");
            answer = console.next().toLowerCase();
        }
        return startAgain;
    }

}