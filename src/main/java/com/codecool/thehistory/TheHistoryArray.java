package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String textWithoutUnnecessarySigns =
                text
                        .replace("\n", " ")
                        .replace("\t", " ")
                        .trim()
                        .replaceAll("\\s+", " ");

        String[] parts;
        parts = textWithoutUnnecessarySigns.split("\\s");

        String[] combined = new String[wordsArray.length + parts.length];
        System.arraycopy(wordsArray, 0, combined, 0, wordsArray.length);
        System.arraycopy(parts, 0, combined, wordsArray.length, parts.length);
        wordsArray = combined;

        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        String wordArrayAsString =
                String
                        .join(" ", wordsArray)
                        .replaceAll(wordToBeRemoved, "")
                        .trim()
                        .replaceAll(" +", " ");

        wordsArray = wordArrayAsString.split(" ");

        //TODO: check the TheHistory interface for more information
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceOneWord(String from, String to) {
        String regex = "\\b" + from + "\\b";
        String wordArrayAsString =
                String
                        .join(" ", wordsArray)
                        .replaceAll(regex, to);

        wordsArray = wordArrayAsString.split(" ");

        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        String fromWordsString = String.join(" ", fromWords);
        String toWordsString = String.join(" ", toWords);

        String regex = "\\b" + fromWordsString + "\\b";
        String wordArrayAsString =
                String
                        .join(" ", wordsArray)
                        .replaceAll(regex, toWordsString);

        wordsArray = wordArrayAsString.split(" ");

        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
