package com.codecool.thehistory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        String[] textWithoutUnnecessarySigns =
                text
                        .replace("\n", " ")
                        .replace("\t", " ")
                        .trim()
                        .replaceAll(" +", " ")
                        .split("\\s");

        Collections.addAll(wordsLinkedList, textWithoutUnnecessarySigns);
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsLinkedList.removeIf(n -> n.equals(wordToBeRemoved));

//        for (ListIterator<String> iterator = wordsLinkedList.listIterator(); iterator.hasNext();) {
//        if (iterator.next().equals(wordToBeRemoved)) {
//            iterator.remove();
//        }
//    }
}
        //TODO: check the TheHistory interface for more information


    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        Collections.replaceAll(wordsLinkedList, from, to);
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {


        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
