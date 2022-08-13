package org.java.academy;

import org.java.academy.score.Score;
import org.java.academy.score.ScoreComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreComparatorTest {

    @Test
    void compareScore1Faster() {

        Score score1 = new Score("P1", "data", 2, 20);
        Score score2 = new Score("P2", "data", 2, 30);

        ScoreComparator comparatorTest1 = new ScoreComparator();
        int result = comparatorTest1.compare(score1, score2);

        assertEquals(-1, result);
    }

    @Test
    void compareScore2Faster() {

        Score score1 = new Score("P1", "data", 3, 30);
        Score score2 = new Score("P2", "data", 2, 20);

        ScoreComparator comparatorTest1 = new ScoreComparator();
        int result = comparatorTest1.compare(score1, score2);

        assertEquals(1, result);
    }

    @Test
    void compareScoresEqual() {

        Score score1 = new Score("P1", "data", 2, 20);
        Score score2 = new Score("P2", "data", 2, 20);

        ScoreComparator comparatorTest1 = new ScoreComparator();
        int result = comparatorTest1.compare(score1, score2);

        assertEquals(0, result);
    }

    @Test
    void compareScoresTimeEqualScore1LowChance() {

        Score score1 = new Score("P1", "data", 1, 20);
        Score score2 = new Score("P2", "data", 2, 20);

        ScoreComparator comparatorTest1 = new ScoreComparator();
        int result = comparatorTest1.compare(score1, score2);

        assertEquals(-1, result);
    }

    @Test
    void compareScoresTimeEqualScore2LowChance() {

        Score score1 = new Score("P1", "data", 3, 20);
        Score score2 = new Score("P2", "data", 2, 20);

        ScoreComparator comparatorTest1 = new ScoreComparator();
        int result = comparatorTest1.compare(score1, score2);

        assertEquals(1, result);
    }


}