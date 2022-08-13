package org.java.academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class WordsRandomizer {

    private final List<String> listOfWords = new ArrayList<>();
    public String word;

    WordsRandomizer(InputStream inputStream) throws IOException {
        Scanner s = new Scanner(inputStream);
        while (s.hasNext()) {
            listOfWords.add(s.next());
        }
    }

    List<String> randomWordsByNumber(int numberOfElements) {
        List<String> result = new ArrayList<>();
        List<String> drawWithoutRepetition = new ArrayList<>();
        drawWithoutRepetition.addAll(listOfWords);

        Random rand = new Random();

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(drawWithoutRepetition.size());
            String randomElement = drawWithoutRepetition.get(randomIndex);
            result.add(i, randomElement);
            drawWithoutRepetition.remove(randomIndex);
        }
        return result;
    }

    List<String> randomWordsByDifficultyLevel(DifficultyLevel level) {
        return randomWordsByNumber(level.numberOfWords);
    }

}
