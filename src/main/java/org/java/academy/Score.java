package org.java.academy;

public class Score {


    private String playerName;
    private String date;

    public int getUsedChances() {
        return usedChances;
    }

    public long getTimeInSeconds() {
        return timeInSeconds;
    }

    private int usedChances;
    private long timeInSeconds;

    Score(String playerName, String date, int usedChances, long timeInSeconds) {
        this.playerName = playerName;
        this.date = date;
        this.usedChances = usedChances;
        this.timeInSeconds = timeInSeconds;
    }

    @Override
    public String toString(){
        return playerName + " | " + date + " | " + usedChances + " | " + timeInSeconds;

    }
}
