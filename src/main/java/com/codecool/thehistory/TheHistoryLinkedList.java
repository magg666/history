package com.codecool.thehistory;

import sun.awt.util.IdentityLinkedList;

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
        for (ListIterator<String> iterator = wordsLinkedList.listIterator(); iterator.hasNext(); ) {
            if (iterator.next().equals(from)) {
                iterator.remove();
                iterator.add(to);
            }
        }

//        Collections.replaceAll(wordsLinkedList, from, to);
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        List<String> freshList = new LinkedList<>();
        int currentIndex = 0;

        while (currentIndex < wordsLinkedList.size()) {
            if (currentIndex + fromWords.length <= wordsLinkedList.size()
                    && Arrays.equals(wordsLinkedList.subList(currentIndex, currentIndex + fromWords.length).toArray(), fromWords)) {
                freshList.addAll(Arrays.asList(toWords));
                currentIndex = currentIndex + fromWords.length;
            } else {
                ListIterator iterator = wordsLinkedList.listIterator(currentIndex);
                freshList.add((String) iterator.next());
                currentIndex++;
            }
        }
        wordsLinkedList = freshList;
    }


    // 5.92 12.971 12.664
//        List<String> freshList = new LinkedList<>();
//        int currentIndex = 0;
//
//
//        while (currentIndex < wordsLinkedList.size()) {
//            if (currentIndex + fromWords.length <= wordsLinkedList.size()
//                    && Arrays.equals(wordsLinkedList.subList(currentIndex, currentIndex + fromWords.length).toArray(new String[0]), fromWords)) {
//                freshList.addAll(Arrays.asList(toWords));
//                currentIndex = currentIndex + fromWords.length;
//            } else {
//                freshList.add(wordsLinkedList.get(currentIndex));
//                currentIndex++;
//            }
//        }
//        wordsLinkedList = freshList;
//    }

// 47.512 1m 53.471 2m 10.487
//        int currentIndex = 0;
//
//        while (currentIndex + fromWords.length <= wordsLinkedList.size()) {
//            String [] newList = wordsLinkedList.subList(currentIndex, currentIndex + fromWords.length).toArray(new String[0]);
//            if (Arrays.equals(newList, fromWords)) {
//                wordsLinkedList.subList(currentIndex, currentIndex + fromWords.length).clear();
//                wordsLinkedList.addAll(currentIndex, Arrays.asList(toWords));
//                currentIndex = currentIndex + toWords.length;
//            } else {
//                currentIndex++;
//            }
//        }
//    }

// 35.866 2m 3.816 1m 46.414
//        ListIterator<String> wordsIterator = wordsLinkedList.listIterator();
//        int fromWordsLength = fromWords.length;
//        int toWordsLength = toWords.length;
//        List<String> fromWordsAsList = Arrays.asList(fromWords);
//        List<String> toWordsAsList = Arrays.asList(toWords);
//
//
//        while (wordsIterator.nextIndex() + fromWordsLength <= wordsLinkedList.size()) {
//            if (Objects.equals(wordsLinkedList.subList(wordsIterator.nextIndex(), wordsIterator.nextIndex() + fromWords.length), fromWordsAsList)) {
//                wordsLinkedList.subList(wordsIterator.nextIndex(), wordsIterator.nextIndex() + fromWords.length).clear();
//                wordsLinkedList.addAll(wordsIterator.nextIndex(), toWordsAsList);
//                wordsIterator = wordsLinkedList.listIterator(wordsIterator.nextIndex() + toWordsLength);
//
//            } else {
//                wordsIterator.next();
//            }
//        }

// 10.426 25.522 25.617
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
//    }

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
