package org.java.academy;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class WordsRandomizerTest {

    private final String filePath = "src/test/resources/wordsTest.txt";


    @Test
    void randomWordsByNumberCheckElementsNumber() throws IOException {
        WordsRandomizer wordsRandomizer = new WordsRandomizer(filePath);

        List<String> words1 = wordsRandomizer.randomWordsByNumber(1);
        assertEquals(1, words1.size());

        List<String> words11 = wordsRandomizer.randomWordsByNumber(11);
        assertEquals(11, words11.size());
    }

    @Test
    void randomWordsByNumberCheckElementsUniqueness() throws IOException {
        WordsRandomizer wordsRandomizer = new WordsRandomizer(filePath);

        List<String> words1 = wordsRandomizer.randomWordsByNumber(4);

        Set<String> set = new HashSet<>(words1);

        assertEquals(4, set.size());
    }

    @Test
    void randomWordsByDifficultyLevelCheckElementsNumberForEasy() throws IOException {

        WordsRandomizer wordsRandomizer = new WordsRandomizer(filePath);

        List<String> wordsEasy = wordsRandomizer.randomWordsByDifficultyLevel(DifficultyLevel.EASY);

        assertEquals(4, wordsEasy.size() );
    }

    @Test
    void randomWordsByDifficultyLevelCheckElementsNumberForHard() throws IOException {

        WordsRandomizer wordsRandomizer = new WordsRandomizer(filePath);

        List<String> wordsHard = wordsRandomizer.randomWordsByDifficultyLevel(DifficultyLevel.HARD);

        assertEquals(8, wordsHard.size() );

    }
}