package wordAnalyserTask.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FileAnalyserTest {

    private TextFileAnalyser fileAnalyser;

    @BeforeEach
    void createFile() {
        fileAnalyser = new TextFileAnalyser();
    }

    @Test
    void analyse() {
        assertTrue(fileAnalyser.analyse("Large Content", "Path").getContent().contains("2.0"));
    }

    @Test
    void collectWords() {
        assertTrue(List.of("Ralph").get(0).equalsIgnoreCase(fileAnalyser.collectWords("Ralph is good").get(0)));
    }

    @Test
    void isVowel() {
        assertTrue(fileAnalyser.isVowel('a'));
    }

    @Test
    void findVowels() {
        assertEquals(List.of('a').get(0), fileAnalyser.findVowels("Ralph").get(0));
    }

    @Test
    void compareTwoVowelSets() {
        Set<Character> secondSet = new java.util.HashSet<>();
        secondSet.add('a');
        secondSet.add('f');
        assertTrue(fileAnalyser.compareTwoVowelSets(Set.of('a', 'f'), secondSet));
    }

    @Test
    void findAverage() {
        List<String> list = Arrays.asList("Platon made bamboo boats".split(" "));
        assertEquals(2, Math.round(fileAnalyser.findAverage(list.get(0), list)));
    }
}