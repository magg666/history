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

        int counter = 0;
        int indexOfNewArray = 0;
        for (String string : wordsArray) {
            if (string.equals(wordToBeRemoved)) {
                counter++;
            }
        }
        String[] newWordsArray = new String[wordsArray.length - counter];
        for (String word: wordsArray){
            if(!word.equals(wordToBeRemoved)){
                newWordsArray[indexOfNewArray] = word;
                indexOfNewArray ++;
            }
        }
        wordsArray = newWordsArray;


//        String wordArrayAsString =
//                String
//                        .join(" ", wordsArray)
//                        .replaceAll(wordToBeRemoved, "")
//                        .trim()
//                        .replaceAll(" +", " ");
//
//        wordsArray = wordArrayAsString.split(" ");

        //TODO: check the TheHistory interface for more information
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        int counter = 0;
        for(String word: wordsArray){
            counter ++;
        }
        return counter;

//        return wordsArray.length;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceOneWord(String from, String to) {
        for (int i = 0; i < wordsArray.length; i++){
            if(wordsArray[i].equals(from)){
                wordsArray[i] = to;
            }
        }

//        String regex = "\\b" + from + "\\b";
//        String wordArrayAsString =
//                String
//                        .join(" ", wordsArray)
//                        .replaceAll(regex, to);
//
//        wordsArray = wordArrayAsString.split(" ");

        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

        int counter = 0;
        for (int i = 0; i < wordsArray.length;){
            if(Arrays.equals(Arrays.copyOfRange(wordsArray, i, i + fromWords.length), fromWords)){
                counter ++;
                i = i + fromWords.length;
            } else {
                i++;
            }
        }
        String [] freshArray = new  String[wordsArray.length - counter*fromWords.length + counter*toWords.length ];

        int i = 0;
        for(int j = 0; j < wordsArray.length;){
            if(Arrays.equals(Arrays.copyOfRange(wordsArray, j, j + fromWords.length), fromWords)){
                System.arraycopy(toWords, 0, freshArray, i, toWords.length);
                i = i + toWords.length;
                j = j + fromWords.length;
            } else {
                System.arraycopy(wordsArray, j, freshArray, i, 1);
                i++;
                j++;
            }
        }wordsArray = freshArray;
//
//
//
//        String fromWordsString = String.join(" ", fromWords);
//        String toWordsString = String.join(" ", toWords);
//
//        String regex = "\\b" + fromWordsString + "\\b";
//        String wordArrayAsString =
//                String
//                        .join(" ", wordsArray)
//                        .replaceAll(regex, toWordsString);
//
//        wordsArray = wordArrayAsString.split(" ");

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
