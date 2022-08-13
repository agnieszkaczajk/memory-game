package org.java.academy;


import org.java.academy.score.HighScore;
import org.java.academy.score.Score;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameLevel {

    private final static String answerRegExp = "[aAbB]\\d";
    public Board board;
    private final DifficultyLevel level;
    public int guessChances;
    private final WordsRandomizer wordsRandomizer;

    GameLevel(DifficultyLevel level, WordsRandomizer wordsRandomizer){
        this.level=level;
        this.guessChances = level.numberOfChances;
        this.wordsRandomizer = wordsRandomizer;
    }

    void play(Scanner console) throws IOException {
        board = new Board(wordsRandomizer.randomWordsByDifficultyLevel(level));
        board.createWordsChoice();

        //Instant start = Instant.now();
        Instant start = Instant.now();

        while(guessChances > 0) {
            Word one = askForWord(console);
            one.setUncovered(true);

            Word two = askForWord(console);
            two.setUncovered(true);
            System.out.println(board.printBoard());

            if(!one.equals(two)){
                one.setUncovered(false);
                two.setUncovered(false);
                guessChances -= 1;
                if(guessChances == 0) {
                    System.out.println("Sorry, you lost - your chances are over.");
                    break;
                }
                System.out.println("Sorry, words did not match. Try again.");

            } else {
                System.out.println("Yay! This is a pair!");
                one.setGuessed(true);
                two.setGuessed(true);
                guessChances -= 1;

            }

            if(board.isPlayerWon()){
                System.out.println("Congratulations! You are the winner! ");
                Instant stop = Instant.now();
                int usedChances = usedChances();
                long timeElapsed = Duration.between(start,stop).getSeconds();
                System.out.println("You solved the memory game after " + usedChances +
                        " chances. It took you " + timeElapsed +" seconds.");
                console.nextLine(); // to discard /n
                System.out.println("Enter your name to save your high score:");
                String playerName = console.nextLine();
                saveHighScore( playerName, usedChances, timeElapsed);
                break;
            }
            if(guessChances==0) {
                System.out.println("Sorry, you lost - your chances are over.");
                break;
            }
        }
    }

    private Word askForWord(Scanner console) {
        while (true) {
            System.out.println(this.toString());
            System.out.println(board.printBoard());
            System.out.println("Choose a word to reveal (e.g. A1):");

            String answer = console.next().toUpperCase();
            if(inputValidation(answer)) {
                String rowName = answer.substring(0, 1);
                int columnId = Integer.parseInt(answer.substring(1));

                Word checkIsUncovered = board.getBoardMap().get(rowName).get(columnId-1);
                if(checkIsUncovered.isUncovered() || checkIsUncovered.isGuessed()){
                    System.out.println("Oops! This word is already face up! Choose again!");
                } else{
                    return checkIsUncovered;
                }
            }
        }
    }

    boolean inputValidation(String answerToValidate){

       Pattern pattern = Pattern.compile(answerRegExp);
       Matcher matcher = pattern.matcher(answerToValidate);

       if(matcher.matches()){
           int answerNumber = Integer.parseInt(answerToValidate.substring(1));
           if(answerNumber <= level.numberOfWords && answerNumber > 0){
               return  true;
           }
       }
       System.out.println("Oops, you've made a mistake! Please choose a word again! \n");
       return false;
   }

    private void saveHighScore(String playerName, int usedChances, long timeElapsed) throws IOException {

       String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
       Score score = new Score(playerName, today, usedChances, timeElapsed);

       HighScore highScore = new HighScore();
       highScore.updateHighScore(score, level);
       highScore.printHighScore(level);

   }

    public DifficultyLevel getLevel(){
        return level;
    }

    @Override
    public String toString() {
        return "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Level: " + level +  "\n"+
                "Guess chances: " + guessChances + "\n";
    }

    public int usedChances() {
        return level.numberOfChances - guessChances;
    }


}
