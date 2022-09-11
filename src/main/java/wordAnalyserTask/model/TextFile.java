package wordAnalyserTask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextFile {

    private String path;
    private String content;
    private Integer totalWords;
    private String fileName;
}
