package org.java.academy;

public enum DifficultyLevel {
        EASY(4, 10, "HighScoreEasy.txt"),
        HARD(8, 15, "HighScoreHard.txt");
        public final int numberOfWords;
        public final int numberOfChances;
        public final String filePath;

        DifficultyLevel(int numberOfWords, int numberOfChances, String filePath) {
            this.numberOfWords = numberOfWords;
            this.numberOfChances = numberOfChances;
            this.filePath = filePath;
        }
}