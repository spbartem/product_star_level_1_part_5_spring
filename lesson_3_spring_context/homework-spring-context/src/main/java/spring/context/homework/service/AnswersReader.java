package spring.context.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.context.homework.model.Answers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswersReader {
    private final AnswersParser answersParser;
    @Autowired
    public AnswersReader(AnswersParser answersParser) {
        this.answersParser = answersParser;
    }

    public List<Answers> readAnswersFromFile(Path filePath) throws IOException {
        return Files.lines(filePath)
                .map(answersParser::parseAnswers)
                .collect(Collectors.toList());
    }
}
