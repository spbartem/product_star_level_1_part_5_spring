package spring.context.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import spring.context.homework.config.ResultProcessorConfig;
import spring.context.homework.service.AnswersReader;
import spring.context.homework.service.ResultsProcessorImpl;

import java.io.IOException;
import java.util.Map;

public class ResultsProcessorMain {

    public static void main(String[] args) throws IOException {
        /*
         * Предполагается, что в папке ./src/main/resources/ хранятся ответы нескольких студенов.
         * Файл с ответами имеет имя формата, answers_N.csv, где N - ID студента.
         */

        var applicationConfig = new AnnotationConfigApplicationContext(ResultProcessorConfig.class);

        var answersReader = applicationConfig.getBean(AnswersReader.class);
        var filePathOfCorrectAnswers = new ClassPathResource("correct_answers.csv").getFile().toPath();
        var correctAnswers = answersReader.readAnswersFromFile(filePathOfCorrectAnswers);
        var resultsProcessor = applicationConfig.getBean(ResultsProcessorImpl.class);

        var finalResults = resultsProcessor.calculateFinalScores(correctAnswers);
        for (Map.Entry<Integer, Long> entry : finalResults.entrySet()) {
            System.out.println("Summary scores for Student ID " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
