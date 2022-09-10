package wordAnalyserTask.service;

import wordAnalyserTask.model.TextFile;

import java.io.IOException;


public interface TextFileService {

    String saveFileAnalysisResult(TextFile textFile) throws IOException;

    String analyseDefaultTextFile() throws IOException;

    TextFile perFormAnalysis(String text, String path);

    String analyseFile(String newPath) throws IOException;
}
