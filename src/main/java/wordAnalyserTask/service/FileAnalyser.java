package wordAnalyserTask.service;

import wordAnalyserTask.model.TextFile;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FileAnalyser {

    private String content = "";

    public TextFile analyse(String text, String path) {

        Map<Map<Set<Character>, Integer>, Double> averageNumberOfVowelsPerWordGroup = new HashMap<>();
        List<String> words = collectWords(text);
        words.forEach(word -> averageNumberOfVowelsPerWordGroup.put(Map.of(Set.copyOf(findVowels(word)), word.length()), findAverage(word, words)));

        averageNumberOfVowelsPerWordGroup.forEach((key, value) -> content = content.concat(key + " -> " + String.format("%.1f", value)).concat("\n"));
        TextFile textFile = new TextFile(Path.of(path).getFileName().toString(), content, collectWords(text).size(), "file_" + LocalDateTime.now());
        content = "";
        return textFile;

    }
    public List<String> collectWords(String statement) {
        return Arrays.stream(statement.split(" ")).collect(Collectors.toList());
    }

    public boolean isVowel(char character) {
        return String.valueOf(character).equalsIgnoreCase("a") ||
                String.valueOf(character).equalsIgnoreCase("e") ||
                String.valueOf(character).equalsIgnoreCase("o") ||
                String.valueOf(character).equalsIgnoreCase("u") ||
                String.valueOf(character).equalsIgnoreCase("i");
    }

    public List<Character> findVowels(String word) {
        return word.chars()
                .mapToObj(cha -> (char) cha)
                .filter(this::isVowel)
                .map(Character::toLowerCase)
                .collect(Collectors.toList());
    }

    public boolean compareTwoVowelSets(Set<Character> firstSet, Set<Character> secondSet) {

        if(!(firstSet.size() == secondSet.size())) {
            return false;
        }
        Set<Character> allSets = new HashSet<>();
        allSets.addAll(secondSet);
        allSets.addAll(firstSet);
        return allSets.size() == firstSet.size();
    }

    public Double findAverage(String currentWord, List<String> otherWords) {
        double currentWordCount = 1;
        double currentTotalVowelCount = findVowels(currentWord).size();

        for (String word : otherWords) {
            if ((compareTwoVowelSets(Set.copyOf(findVowels(word)), Set.copyOf(findVowels(currentWord)))) && word.length() == currentWord.length()) {
                currentTotalVowelCount += findVowels(word).size();
                currentWordCount += 1;
            }
        }
        return  currentTotalVowelCount/currentWordCount;
    }

}
