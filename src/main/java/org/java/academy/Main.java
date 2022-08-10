package org.java.academy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<String> listOfWords;
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        listOfWords = new ArrayList<>();
        initialization();
        System.out.println("End of execution!");
    }

    public static void initialization() throws IOException {
        readWordsFile();
    }

    private static void readWordsFile() throws IOException {
        String path = "src/main/resources/Words.txt";
        try(FileInputStream fileInputStream = new FileInputStream(path);
            Scanner s = new Scanner(fileInputStream)) {
            while (s.hasNext()) {
                listOfWords.add(s.next());
            }
        }
    }
}