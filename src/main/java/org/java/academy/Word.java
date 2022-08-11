package org.java.academy;

public class Word{
    private String word;
    private boolean guessed = false;
    private boolean uncovered = false;

    Word(String word){
        this.word=word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isGuessed(){
        return guessed;
    }

    public void setGuessed(boolean isGuessed){
        guessed = isGuessed;
    }

    public boolean isUncovered() {
        return uncovered;
    }

    public void setUncovered(boolean uncovered) {
        this.uncovered = uncovered;
    }

    @Override
    public boolean equals(Object obj){
        if(obj.toString() == this.word) {
            return true;
        } else{
            return false;
        }
    }

    public String toString() {
        // if guessed or uncovered return word otherwise "X"
        if(guessed || uncovered){
            return word;
        } else{
            return "X";
        }

    }
    
}