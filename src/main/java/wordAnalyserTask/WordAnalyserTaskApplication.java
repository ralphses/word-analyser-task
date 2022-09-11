package wordAnalyserTask;

import wordAnalyserTask.controller.TextFileController;

/**
 * This is a project task from Luxoft DXC
 * This application uploads a text file, analysis it
 * And find the average number of vowel per word
 *
 * @author Raphael Eze
 */

public class WordAnalyserTaskApplication {

    public static void main(String[] args) {

        //Main entrance to this application
        new TextFileController().start();
    }
}
