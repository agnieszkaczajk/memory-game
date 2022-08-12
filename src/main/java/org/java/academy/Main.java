package org.java.academy;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String path = "src/main/resources/Words.txt";
    private static WordsRandomizer wordsRandomizer;
    private static GameLevel gameLevel;

    private static Board board;

    private boolean startAgain = true;

    String answerRegExp = "[aAbB]\\d";


    public static void main(String[] args) throws IOException {
        initialization();
        Scanner console = new Scanner(System.in);
        Main game = new Main();

        while(game.startAgain) {
            game.gameLevel = game.start(console);

            System.out.println(game.gameLevel);

            game.play(console);

            game.startAgain = game.ending(console);


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

    private void play(Scanner console){


        board = new Board(wordsRandomizer.randomWordsByDifficultyLevel(gameLevel.getLevel()));
        board.createWordsChoice();


        while(gameLevel.guessChances>0) {
            Word one = askForWord(console);
            one.setUncovered(true);

            Word two = askForWord(console);
            two.setUncovered(true);
            System.out.println(board.printBoard());

            if(!one.equals(two)){
                one.setUncovered(false);
                two.setUncovered(false);
                gameLevel.guessChances -= 1;
                System.out.println("Sorry, words did not match. Try again");
                System.out.println(gameLevel.toString());
                System.out.println(gameLevel.guessChances);
                if(gameLevel.guessChances == 0) {
                    System.out.println("Sorry, You're looser!");
                    break;
                }

            } else if (one.equals(two)){

                System.out.println("Yay! This is a pair!");
                System.out.println(gameLevel.toString());
                one.setGuessed(true);
                two.setGuessed(true);

                if(gameLevel.guessChances==0) break;
            } else{
                System.out.println("Ups! Something gone wrong! Try again!");
            }

            if(board.isPlayerWon()){
                System.out.println("Congratulations! You're winner! ");
                break;
            }

        }

    }

    private Word askForWord(Scanner console) {
        while (true) {
            System.out.println(board.printBoard());
            System.out.println("Choose a word to reveal (e.g. A1)!");

            String answer = console.next().toUpperCase();
            if(inputValidation(answer, gameLevel.getLevel())) {
                String rowName = answer.substring(0, 1);
                int columnId = Integer.parseInt(answer.substring(1));

                Word checkIsUncovered = board.getBoardMap().get(rowName).get(columnId-1);
                //return board.getBoardMap().get(rowName).get(columnId-1);
                if(checkIsUncovered.isUncovered() || checkIsUncovered.isGuessed()){
                    System.out.println("Oops! This word is already face up! Choose again!");
                } else{
                    return checkIsUncovered;
                }
            }
        }
    }

    private boolean ending(Scanner console){
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

     boolean inputValidation(String answerToValidate, GameLevel.DifficultyLevel level){

        Pattern pattern = Pattern.compile(answerRegExp);
        Matcher matcher = pattern.matcher(answerToValidate);

        if(matcher.matches()){
            int answerNumber = Integer.parseInt(answerToValidate.substring(1));
            if(answerNumber <= level.numberOfWords && answerNumber > 0){
                return  true;
            }

        }

        System.out.println("Oops, you've made a mistake! Choose again! \n");
        return false;
    }

}