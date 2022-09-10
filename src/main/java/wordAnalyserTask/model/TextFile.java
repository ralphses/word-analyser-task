package wordAnalyserTask.model;

import lombok.Builder;

@Builder
public class TextFile {

    private String path;
    private String content;
    private Integer totalWords;
    private String fileName;

    public TextFile(String path, String content, Integer totalWords, String fileName) {
        this.path = path;
        this.content = content;
        this.totalWords = totalWords;
        this.fileName = fileName;
    }

    public TextFile(String path, String content) {
        this.path = path;
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        fileName = fileName.replaceAll(":", "_");
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(Integer totalWords) {
        this.totalWords = totalWords;
    }

    @Override
    public String toString() {
        return "TextFile{" +
                "path='" + path + '\'' +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", totalWords=" + totalWords +
                '}';
    }
}
