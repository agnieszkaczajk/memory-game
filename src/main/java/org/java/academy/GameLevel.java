package org.java.academy;


import java.util.ArrayList;
import java.util.List;

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

    public boolean nextMove(){
        if(guessChances >0){
            remain=true;
            return true;
        } else{
            remain=false;
            return false;
        }
    }

    @Override
    public String toString() {
        return "\n----------------\n" +
                "Level: " + level + "\n" +
                "Guess chances: " + guessChances + "\n" +
                getLevel().numberOfWords;
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
