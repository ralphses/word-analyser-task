package wordAnalyserTask.dao;

import wordAnalyserTask.model.TextFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static java.nio.file.Files.*;

public class TextFileDao {

    private final String WRITE_DESTINATION_PATH = "src/main/resources/analysis results/";

    public TextFileDao() { init();}

    public String uploadFile(String filePath) throws IOException {
        return lines(Paths.get(filePath)).collect(Collectors.joining(System.lineSeparator()));
    }

    public String writeAnalysedFile(TextFile textFile) {

        File file = new File(WRITE_DESTINATION_PATH + textFile.getFileName());

        String content  = "Vowel Analysis for " + textFile.getPath() + "\n" +
                "" + textFile.getContent() + "\n" +
                "Total number of words : " + textFile.getTotalWords();

        try(FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return file.getAbsolutePath();
    }

    private void init() {
        try {
            createDirectories(Paths.get(WRITE_DESTINATION_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
