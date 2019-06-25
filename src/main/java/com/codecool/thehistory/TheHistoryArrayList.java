package com.codecool.thehistory;

import java.lang.reflect.Array;
import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        String[] textWithoutUnnecessarySigns =
                text
                        .replace("\n", " ")
                        .replace("\t", " ")
                        .trim()
                        .replaceAll(" +", " ")
                        .split(" ");
        Collections.addAll(wordsArrayList, textWithoutUnnecessarySigns);


        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsArrayList.removeIf(wordToBeRemoved::equals);
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        ListIterator<String> iterator = wordsArrayList.listIterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals(from)) {
                 iterator.set(to);
            }
        }
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        String fromWordsString = String.join(" ", fromWords);
        String toWordsString = String.join(" ", toWords);

        String regex = "\\b" + fromWordsString + "\\b";
        String wordArrayAsString =
                String
                        .join(" ", wordsArrayList)
                        .replaceAll(regex, toWordsString);

        wordsArrayList = Arrays.asList(wordArrayAsString.split(" "));

        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
