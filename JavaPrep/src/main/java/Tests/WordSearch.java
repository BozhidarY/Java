package Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearch {
    public static void main(String[] args) {
        // Create an ArrayList to store words
        List<String> words = new ArrayList<>();
        words.add("example");
        words.add("something");
        words.add("awesome");
        words.add("java");
        words.add("programming");
        words.add("is");

        // Perform the search and print the results
        String searchSubstring = "some";
        List<String> searchResults = searchWords(words, searchSubstring);

        if (!searchResults.isEmpty()) {
            System.out.println("Words containing '" + searchSubstring + "':");
            for (String word : searchResults) {
                System.out.println(word);
            }
        } else {
            System.out.println("No words found containing '" + searchSubstring + "'.");
        }
    }

    public static List<String> searchWords(List<String> words, String searchSubstring) {
        // Use Java Streams to filter words containing the search substring
        return words.stream()
                .filter(word -> word.contains(searchSubstring))
                .collect(Collectors.toList());
    }
}
