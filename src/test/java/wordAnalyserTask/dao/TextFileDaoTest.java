package wordAnalyserTask.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordAnalyserTask.model.TextFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class TextFileDaoTest {

    private TextFileDao textFileDao;

    @BeforeEach
    void initialize() {
        textFileDao = new TextFileDao();
    }

    @Test
    void uploadFile() throws IOException {
        String path = "src/main/resources/defaultText.txt";
        assertTrue("Platon made bamboo boats".equalsIgnoreCase(textFileDao.uploadFile(path)));
    }

    @Test
    void writeAnalysedFile() {
        TextFile textFile = TextFile.builder()
                .fileName("fileName")
                .content("Large Content")
                .path("Path")
                .totalWords(2)
                .build();

        assertTrue((textFileDao.writeAnalysedFile(textFile)).contains("fileName"));
    }
}