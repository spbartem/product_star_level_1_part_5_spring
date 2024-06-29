package spring.context.homework.service;

import spring.context.homework.model.Answers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ResultsProcessor {
    Map<Integer, Long> calculateFinalScores(List<Answers> correctAnswers) throws IOException;
    Long calculateScoreForOneFile(List<Answers> correctAnswers, List<Answers> inputAnswers);
}
