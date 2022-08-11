package org.java.academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class WordsRandomizer {

    static List<String> listOfWords = new ArrayList<>();



    WordsRandomizer(String path) throws IOException {

        try(FileInputStream fileInputStream = new FileInputStream(path);
            Scanner s = new Scanner(fileInputStream)) {
            while (s.hasNext()) {
                listOfWords.add(s.next());
            }
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
            System.out.println(result.get(i));
        }


        return result;
    }

    List<String> randomWordsByDifficultyLevel(GameLevel.DifficultyLevel level) {
        return randomWordsByNumber(level.numberOfWords);
    }


}
