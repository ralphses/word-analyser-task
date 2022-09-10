package wordAnalyserTask.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordAnalyserTask.model.TextFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TextFileServiceImplTest {

    private TextFileServiceImpl textFileService;
    public final TextFile textFile = TextFile.builder()
            .fileName("fileName")
            .content("Large Content")
            .path("Path")
            .totalWords(2)
            .build();

    @BeforeEach
    void getTextFile() {
        textFileService = new TextFileServiceImpl();
    }


    @Test
    void saveFileAnalysisResult() {
        textFileService.saveFileAnalysisResult(textFile);
    }

    @Test
    void analyseDefaultTextFile() throws IOException {
        assertTrue(textFileService.analyseDefaultTextFile().contains("file_2022-09-"));
    }

    @Test
    void perFormAnalysis() {
        assertTrue(textFileService.perFormAnalysis("Large Content", "Path").getContent().contains("2.0"));
    }

    @Test
    void analyseFile() throws IOException {
        assertTrue(textFileService.analyseFile("src/main/resources/defaultText.txt").contains("analysis results"));
    }
}