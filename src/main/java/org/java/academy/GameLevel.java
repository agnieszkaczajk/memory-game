package org.java.academy;


public class GameLevel {

    private final DifficultyLevel level;
    public int guessChances;
    public boolean remain = true;


    GameLevel(DifficultyLevel level){
        this.level=level;
        this.guessChances = level.numberOfChances;
    }

    public DifficultyLevel getLevel(){
        return level;
    }

    @Override
    public String toString() {
        return "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Level: " + level + " - " +
                getLevel().numberOfWords + " pair words \n"+
                "Guess chances: " + guessChances +"\n";
    }

    public int usedChances() {
        return level.numberOfChances - guessChances;
    }

    public enum DifficultyLevel {
        EASY(4, 10, "HighScoreEasy.txt"),
        HARD(8, 15, "HighScoreHard.txt");

        int numberOfWords;
        int numberOfChances;
        String filePath;

        DifficultyLevel(int numberOfWords, int numberOfChances, String filePath) {
            this.numberOfWords = numberOfWords;
            this.numberOfChances = numberOfChances;
            this.filePath = filePath;
        }

    }


}
