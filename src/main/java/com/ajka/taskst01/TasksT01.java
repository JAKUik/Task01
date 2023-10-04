package com.ajka.taskst01;

/**
 *
 * @author Jaroslav Kucera
 */

/**
 * Úkol 1 - Rekurze:
 * Napište funkci `word_chain`, která na vstupu dostane libovolně velkou množinu 
 * slov a vrátí největší počet slov, které lze zřetězit jeden po druhém tak, že 
 * první písmeno druhého slova je stejné jako poslední písmeno prvního slova.
 * Opakování slov není povoleno.
 *
 * Příklady:
 * word_chain({'goose', 'dog', 'ethanol'}) == 3  # dog – goose – ethanol
 * word_chain({'why', 'new', 'neural', 'moon'}) == 3  # (moon – new – why)
 */

import java.util.*;

public class TasksT01 {

    public static void main(String[] args) {
        Set<String> words = 
                new HashSet<>(Arrays.asList("goose", "dog", "ethanol"));
        System.out.println(wordChain(words));

        words = new HashSet<>(Arrays.asList("why", "new", "neural", 
                "moon"));
        System.out.println(wordChain(words));

        words = new HashSet<>(Arrays.asList("red", "rabbit", "tulip", 
                "sunflower", "pear", "elephant", "rose", "tiger", "apple"));
        System.out.println(wordChain(words));        
    }
    /**
     * Recursive function. Searches all chained lists
     * 
     * :param words: A set of words
     * :param current_word: Actual processed word
     * :param path: List of processed words
     * :return: All chained lists
     */
    public static List<List<String>> searchAllPaths(Set<String> words, 
            String currentWord, List<String> path) {
        if (path == null) {
            path = new ArrayList<>();
        }
        if (currentWord != null) {
            path.add(currentWord);
        }
        List<List<String>> allPaths = new ArrayList<>();
        for (String word : words) {
            if (currentWord == null || word.charAt(0) == 
                    currentWord.charAt(currentWord.length() - 1)) {
                Set<String> remainingWords = new HashSet<>(words);
                remainingWords.remove(word);
                List<String> newPath = new ArrayList<>(path);
                List<List<String>> newPaths = searchAllPaths(remainingWords, 
                        word, newPath);
                allPaths.addAll(newPaths);
            }
        }
        if (allPaths.isEmpty() && currentWord != null) {
            allPaths.add(path);
        }
        return allPaths;
    }
    
    /**
     * Searches for the longest list from all chained lists
     * :param words: A set of words
     * :return: Longest list
     */
    public static List<String> wordChain(Set<String> words) {
        List<List<String>> allPaths = searchAllPaths(words, null, null);
        List<String> longestPath = new ArrayList<>();
        for (List<String> path : allPaths) {
            if (longestPath.size() <= path.size()) {
                longestPath = path;
            }
        }
        return longestPath;
    }
}
