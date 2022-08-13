package org.java.academy.score;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {

    @Override
    public int compare(Score score1, Score score2) {
        if(score1.getTimeInSeconds() == score2.getTimeInSeconds()) {
            return Integer.compare(score1.getUsedChances(), score2.getUsedChances());
        }
        return Long.compare(score1.getTimeInSeconds(), score2.getTimeInSeconds());
    }

}
