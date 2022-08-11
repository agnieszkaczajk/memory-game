package org.java.academy;

import java.util.*;

public class Board{

    private List<String> words = new ArrayList<>();
    private Word word;
    private Map<String, List<Word>> boardMap = new HashMap<>();
    int rowSize = 4;


    Board(List<String> words){
        this.words.addAll(words);
        this.words.addAll(words);
        Collections.shuffle(this.words);
    }

    public void createWordsChoice() {
        String rowLabelA = "A";
        String rowLabelB = "B";

        List<Word> wordChoice = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            word = new Word(words.get(i));
            wordChoice.add(word);

        }

        boardMap.put(rowLabelA,wordChoice.subList(0, words.size()/2));
        boardMap.put(rowLabelB,wordChoice.subList(words.size()/2, words.size()));
        System.out.println(boardMap);

        System.out.println(wordChoice.get(1));


    }



        //private map<String letter, List<Words>
}
