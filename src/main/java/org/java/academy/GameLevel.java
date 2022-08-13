package org.java.academy;


public class GameLevel {

    private final DifficultyLevel level;
    public int guessChances;
    public boolean remain = true;


    GameLevel(DifficultyLevel level, int guessChances){
        this.level=level;
        this.guessChances = guessChances;
    }

    public DifficultyLevel getLevel(){
        return level;
    }

    @Override
    public String toString() {
        return "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Level: " + level + " - " +
                getLevel().numberOfWords + " pair words \n"+
                "Guess chances: " + guessChances + "\n";
    }

    public enum DifficultyLevel {
        EASY(2, "HighScoreEasy.txt"),
        HARD(8, "HighScoreHard.txt");

        int numberOfWords;
        String filePath;

        DifficultyLevel(int numberOfWords, String filePath) {
            this.numberOfWords = numberOfWords;
            this.filePath = filePath;
        }

    }


}
