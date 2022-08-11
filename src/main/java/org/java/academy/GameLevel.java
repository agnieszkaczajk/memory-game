package org.java.academy;


public class GameLevel {

    private final DifficultyLevel level;
    private final int guessChances;


    GameLevel(DifficultyLevel level, int guessChances){
        this.level=level;
        this.guessChances = guessChances;
    }


    @Override
    public String toString() {
        return "\n----------------\n" +
                "Level: " + level + "\n" +
                "Guess chances: " + guessChances;
    }

    public enum DifficultyLevel {
        EASY(4),
        HARD(8);

        int numberOfWords;

        DifficultyLevel(int numberOfWords) {
            this.numberOfWords = numberOfWords;
        }

    }


}
