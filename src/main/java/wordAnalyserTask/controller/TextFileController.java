package wordAnalyserTask.controller;

import wordAnalyserTask.service.TextFileService;
import wordAnalyserTask.service.TextFileServiceImpl;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class TextFileController {

    private TextFileService textFileService;

    public TextFileController() {
        initialize();
    }

    /**
     * Loads a sample text file from the resources directory,
     * analysis the uploaded file and writes the result to a file
     */

    public void start(){
        try {
            printResponse(textFileService.analyseDefaultTextFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        displayWelcome();

        //Accepts a new directory for a .txt file to be analysed
        String newPath = new Scanner(System.in).next();
        Optional<String> responsePathOptional = Optional.of("");

        try {
            responsePathOptional = Optional.ofNullable(textFileService.analyseFile(newPath));
        } catch (IOException e) {
           System.err.println("No such file");
        }
        responsePathOptional.ifPresent(this::printResponse);
    }

    private void displayWelcome() {
        System.out.println("TEXT ANALYSER JAVA PROGRAM");
        System.out.println("Enter file path to be analysed (format -> C:\\Users\\User\\Desktop\\file.txt)");
    }

    private void printResponse(String path) {
        System.out.println("File uploaded and analysed, Result stored in " + path);
    }

    private void initialize() {
        this.textFileService = new TextFileServiceImpl();
    }
}
