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

        // 1.
//        for(String word: textWithoutUnnecessarySigns){
//            wordsArrayList.add(word);
//        }
        //2.
        wordsArrayList.addAll(Arrays.asList(textWithoutUnnecessarySigns));

        //3.
//        Collections.addAll(wordsArrayList, textWithoutUnnecessarySigns);


        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        // 1.
        List<String> freshArrayList = new ArrayList<>();
        for (String word : wordsArrayList) {
            if (!word.equals(wordToBeRemoved)) {
                freshArrayList.add(word);
            }
        }
        wordsArrayList = freshArrayList;

        // 2.
//        wordsArrayList.removeIf(wordToBeRemoved::equals);
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public int size() {
        // 1.
//        int counter = 0;
//        for(String word: wordsArrayList){
//            counter ++;
//        }
//        return counter;
        //TODO: check the TheHistory interface for more information
        //2.
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
        List<String> freshList = new ArrayList<>();

        int currentIndex = 0;
        while (currentIndex < wordsArrayList.size()) {
            if (currentIndex + fromWords.length <= wordsArrayList.size() && Arrays.equals(fromWords, wordsArrayList.subList(currentIndex, currentIndex + fromWords.length).toArray())) {
                freshList.addAll(Arrays.asList(toWords));
                currentIndex = currentIndex + fromWords.length;
            } else {
                freshList.add(wordsArrayList.get(currentIndex));
                currentIndex++;
            }
        }
        wordsArrayList = freshList;


//        String fromWordsString = String.join(" ", fromWords);
//        String toWordsString = String.join(" ", toWords);
//
//        String regex = "\\b" + fromWordsString + "\\b";
//        String wordArrayAsString =
//                String
//                        .join(" ", wordsArrayList)
//                        .replaceAll(regex, toWordsString);
//
//        wordsArrayList = Arrays.asList(wordArrayAsString.split(" "));

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
