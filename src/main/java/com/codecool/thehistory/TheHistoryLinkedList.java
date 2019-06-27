package com.codecool.thehistory;

import java.util.*;

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
        int currentIndex = 0;

        while (currentIndex < wordsLinkedList.size()){
            if (!wordsLinkedList.get(currentIndex).equals(fromWords[0]) || currentIndex + fromWords.length > wordsLinkedList.size()) {
                currentIndex++;
            } else {
                List<String> newList = wordsLinkedList.subList(currentIndex, currentIndex + fromWords.length);
                if (!Objects.equals(newList, Arrays.asList(fromWords))) {
                    currentIndex++;
                } else {
                    wordsLinkedList.subList(currentIndex, currentIndex + fromWords.length).clear();
                    wordsLinkedList.addAll(currentIndex, Arrays.asList(toWords));
                    currentIndex = currentIndex + toWords.length;

                }
            }
        }



//        ListIterator<String> wordsIterator = wordsLinkedList.listIterator();
//        int fromWordsLength = fromWords.length;
//        int toWordsLength = toWords.length;
//        String firstFromWords = fromWords[0];
//        List<String> fromWordsAsList = Arrays.asList(fromWords);
//        List<String> toWordsAsList = Arrays.asList(toWords);
//
//
//        while (wordsIterator.nextIndex() < wordsLinkedList.size()) {
//            if (wordsIterator.next().equals(firstFromWords)
//                    && wordsIterator.previousIndex() + fromWordsLength <= wordsLinkedList.size()
//                    && Objects.equals(wordsLinkedList.subList(wordsIterator.previousIndex(), wordsIterator.previousIndex() + fromWordsLength), fromWordsAsList)) {
//                wordsLinkedList.subList(wordsIterator.previousIndex(), wordsIterator.previousIndex() + fromWordsLength).clear();
//                wordsLinkedList.addAll(wordsIterator.previousIndex(), toWordsAsList);
//                wordsIterator = wordsLinkedList.listIterator(wordsIterator.previousIndex() + toWordsLength);
//
//            }
//        }


//        List<String> freshList = new LinkedList<>();
//
//        int currentIndex = 0;
//        while (currentIndex < wordsLinkedList.size()) {
//            if (wordsLinkedList.get(currentIndex).equals(fromWords[0])
//                    && currentIndex + fromWords.length <= wordsLinkedList.size()) {
//                List<String> newList = wordsLinkedList.subList(currentIndex, currentIndex + fromWords.length);
//
//                if (Objects.equals(Arrays.asList(fromWords), newList)) {
//                    freshList.addAll(Arrays.asList(toWords));
//                    currentIndex = currentIndex + fromWords.length;
//                } else {
//                    freshList.add(wordsLinkedList.get(currentIndex));
//                    currentIndex++;
//                }
//            } else {
//                freshList.add(wordsLinkedList.get(currentIndex));
//                currentIndex++;
//            }
//        }
//        wordsLinkedList = freshList;
//    }


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
