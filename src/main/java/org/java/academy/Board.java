package org.java.academy;

import java.util.*;

public class Board{

    private List<String> words = new ArrayList<>();
    private Word word;
    private Map<String, List<Word>> boardMap = new HashMap<>();
    int numberOfRows = 2;

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
        boardPrint.append("\n");
        boardPrint.append("  ");

        for(int number = 1; number <= words.size()/numberOfRows; number++){
            boardPrint.append(number).append(" ");
        }
        boardPrint.append("\n");

        for(String key : boardMap.keySet()) {
            List<Word> wordsInRow = boardMap.get(key);
            boardPrint.append(key).append(" ");
            for(Word word : wordsInRow) {
                boardPrint.append(word.toString()).append(" ");
            }
            boardPrint.append("\n");

        }
        boardPrint.append("--------------------");
        return boardPrint.toString();
    }



}
