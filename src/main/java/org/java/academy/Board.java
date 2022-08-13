package org.java.academy;

import java.util.*;

public class Board{

    private final List<String> words = new ArrayList<>();
    private final Map<String, List<Word>> boardMap = new HashMap<>();
    private final int numberOfRows = 2;

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
            Word word = new Word(words.get(i));
            wordChoice.add(word);
        }

        boardMap.put(rowLabelA,wordChoice.subList(0, words.size()/numberOfRows));
        boardMap.put(rowLabelB,wordChoice.subList(words.size()/numberOfRows, words.size()));

    }

    public Map<String, List<Word>> getBoardMap() {
        return boardMap;
    }

    public boolean isPlayerWon() {
        boolean successFlag = true;
        for(String key : boardMap.keySet()) {
            List<Word> wordsInRow = boardMap.get(key);
            for(Word wordElement : wordsInRow) {
                successFlag = successFlag && wordElement.isGuessed();
            }
        }
        return successFlag;
    }

    public String printBoard() {
        StringBuilder boardPrint = new StringBuilder();
        boardPrint.append(formatToName("*"));

        for(int number = 1; number <= words.size()/numberOfRows; number++){
            boardPrint.append(formatToCell(String.valueOf(number)));
        }
        boardPrint.append("\n");

        for(String key : boardMap.keySet()) {
            List<Word> wordsInRow = boardMap.get(key);
            boardPrint.append(formatToName(key));
            for(Word word : wordsInRow) {
                String wordToPrint = word.toString();
                boardPrint.append(formatToCell(wordToPrint));
                }
            boardPrint.append("\n");
            }
            boardPrint.append("\n");


        boardPrint.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return boardPrint.toString();
    }

    private String formatToCell(String wordToConvert) {
        return  String.format("%1$15s", wordToConvert);
    }
    private String formatToName(String wordToConvert) {
        return  String.format("%1$3s", wordToConvert);
    }



}
