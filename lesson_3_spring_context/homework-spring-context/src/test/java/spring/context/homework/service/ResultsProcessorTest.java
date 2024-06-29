package spring.context.homework.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import spring.context.homework.config.ResultProcessorConfig;
import spring.context.homework.model.Answers;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ResultsProcessorTest {

    private final static Path SOURCE_FILE = Path.of("./src/main/resources/answers_1.csv");
    private AnswersReader answersReader;
    private ResultsProcessor resultsProcessor;
    private List<Answers> correctAnswers;

    @BeforeEach
    void setUp() throws IOException {
        var applicationConfig = new AnnotationConfigApplicationContext(ResultProcessorConfig.class);

        answersReader = applicationConfig.getBean(AnswersReader.class);
        Path filePathOfCorrectAnswers = new ClassPathResource("correct_answers.csv").getFile().toPath();
        correctAnswers = answersReader.readAnswersFromFile(filePathOfCorrectAnswers);
        resultsProcessor = applicationConfig.getBean(ResultsProcessorImpl.class);
    }

    @Test
    void calculateFinalScores() throws IOException {
        Map<Integer, Long> exceptedResults = new HashMap<>();
        exceptedResults.put(1, 18L);
        exceptedResults.put(2, 14L);
        exceptedResults.put(3, 12L);

        var actualResults= resultsProcessor.calculateFinalScores(correctAnswers);

        Assertions.assertEquals(actualResults.size(), 3);
        Assertions.assertEquals(exceptedResults, actualResults);
    }

    @Test
    void calculateScoreForOneFile() throws IOException {
        var inputAnswers = answersReader.readAnswersFromFile(SOURCE_FILE);
        Long actualScores = resultsProcessor.calculateScoreForOneFile(correctAnswers, inputAnswers);
        Assertions.assertEquals(actualScores, 18);
    }
}