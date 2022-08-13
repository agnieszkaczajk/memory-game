package org.java.academy;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HighScore {


    int numberOfHighScores = 10;

    public HighScore(){
    }


    boolean updateHighScore(Score score, GameLevel.DifficultyLevel level) throws IOException {

        List<Score> scores = readHighScoreFile(level);
        scores.add(score);
        scores.sort(new ScoreComparator());

        saveToFile(scores, level);
        return true;
    }

    private void saveToFile(List<Score> scores, GameLevel.DifficultyLevel level) throws IOException {
        FileWriter fileWriter = new FileWriter(level.filePath);

        for(int i=0; i < scores.size() && i < numberOfHighScores; i++) {
            fileWriter.append(scores.get(i).toString()).append("\n");
        }
        fileWriter.close();

    }

    private List<Score> readHighScoreFile(GameLevel.DifficultyLevel level) throws IOException {

        Path path = Paths.get(level.filePath);

        List<Score> scores = new ArrayList<>();
        if(path.toFile().exists()) {
            List<String> lines = Files.readAllLines(path);

            for (String line: lines) {
                String[] scoreArray = line.split("\\|");
                if(scoreArray.length == 4) {
                    Score scoreObj = new Score(scoreArray[0].trim(), scoreArray[1].trim(), Integer.parseInt(scoreArray[2].trim()), Long.parseLong(scoreArray[3].trim()));
                    scores.add(scoreObj);
                }
            }
        }

        return scores;
    }
}
