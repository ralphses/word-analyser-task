package wordAnalyserTask.service;

import wordAnalyserTask.dao.TextFileDao;
import wordAnalyserTask.model.TextFile;

import java.io.IOException;

public class TextFileServiceImpl implements TextFileService {

    private static final String DEFAULT_FILE_PATH = "src/main/resources/defaultText.txt";
    private TextFileDao textFileDao;
    private  FileAnalyser fileAnalyser;

    public TextFileServiceImpl() {
        initialize();
    }
    private void initialize() {
        this.textFileDao = new TextFileDao();
        fileAnalyser = new FileAnalyser();
    }

    @Override
    public String saveFileAnalysisResult(TextFile textFile) {
        return textFileDao.writeAnalysedFile(textFile);
    }
    @Override
    public String analyseDefaultTextFile() throws IOException {
        String defaultReadFile = textFileDao.uploadFile(DEFAULT_FILE_PATH);
        TextFile textFile  = perFormAnalysis(defaultReadFile, DEFAULT_FILE_PATH);
        return saveFileAnalysisResult(textFile);
    }

    @Override
    public TextFile perFormAnalysis(String text, String path) {
        return fileAnalyser.analyse(text, path);
    }

    @Override
    public String analyseFile(String newPath) throws IOException {
        String fileContent = textFileDao.uploadFile(newPath);
        return saveFileAnalysisResult(perFormAnalysis(fileContent, newPath));
    }

}
