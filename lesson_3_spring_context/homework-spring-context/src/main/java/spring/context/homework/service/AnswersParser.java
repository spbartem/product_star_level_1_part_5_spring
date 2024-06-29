package spring.context.homework.service;

import org.springframework.stereotype.Service;
import spring.context.homework.model.Answers;

@Service
public class AnswersParser {

    private final String SEPARATOR = "-";

    public Answers parseAnswers(String line) {
        String[] parts = line.replaceAll(" ", "").split(SEPARATOR);

        var numberOfQuestion = Integer.valueOf(parts[0]);
        var answer = parts[1];

        return new Answers(numberOfQuestion, answer);
    }
}
