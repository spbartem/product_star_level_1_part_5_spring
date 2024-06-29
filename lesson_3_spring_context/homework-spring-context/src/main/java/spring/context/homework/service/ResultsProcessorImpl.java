package spring.context.homework.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.context.homework.model.Answers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ResultsProcessorImpl implements ResultsProcessor {
    private final static String SOURCE_PATH = "./src/main/resources/";
    private final AnswersReader answersReader;

    @Value("#{${scoresMap}}")
    private Map<Integer, Long> scoresRanges;
    @Autowired
    public ResultsProcessorImpl(AnswersReader answersReader) {
        this.answersReader = answersReader;
    }

    public Map<Integer, Long> calculateFinalScores(List<Answers> correctAnswers) throws IOException {
        Map<Integer, Long> listOfResults = new HashMap<>();
        File sourceDir = new File(SOURCE_PATH);

        for (File file : Objects.requireNonNull(sourceDir.listFiles())) {
            if (file.isFile() && file.getName().matches("answers_\\d+.csv")) {
                var path = file.getAbsoluteFile().toPath();
                var inputAnswers = answersReader.readAnswersFromFile(path);

                Long scoreForOneFile = calculateScoreForOneFile(correctAnswers, inputAnswers);
                var studentId = Integer.valueOf(file.getName().replaceAll("\\D", ""));
                listOfResults.put(studentId, scoreForOneFile);
            }
        }
        return listOfResults;
    }

    public Long calculateScoreForOneFile(List<Answers> correctAnswers, List<Answers> inputAnswers) {
        Long result = 0L;
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (correctAnswers.get(i).equals(inputAnswers.get(i))) {
                result += scoresRanges.get(i + 1);
            }
        }
        return result;
    }
}
