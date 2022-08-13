package org.java.academy.score;

public class Score {


    private final String playerName;
    private final String date;

    private final int usedChances;

    private final long timeInSeconds;

    public Score(String playerName, String date, int usedChances, long timeInSeconds) {
        this.playerName = playerName;
        this.date = date;
        this.usedChances = usedChances;
        this.timeInSeconds = timeInSeconds;
    }

    public int getUsedChances() {
        return usedChances;
    }

    public long getTimeInSeconds() {
        return timeInSeconds;
    }

    @Override
    public String toString(){
        return playerName + " | " + date + " | " + usedChances + " | " + timeInSeconds;
    }
}
