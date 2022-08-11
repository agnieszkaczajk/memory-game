package org.java.academy;


public class GameLevel {

    private final String level;
    private final int guessChances;

    GameLevel(String level, int guessChances){
        this.level=level;
        this.guessChances = guessChances;
    }




    @Override
    public String toString() {
        return "\n----------------\n" +
                "Level: " + level + "\n" +
                "Guess chances: " + guessChances;
    }
}
