package product.star.athletics.result.manager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;
import java.util.List;

public class AthleticsResultsMain {

    public static void main(String[] args) throws FileNotFoundException {
        var applicationConfig = new AnnotationConfigApplicationContext(AthleticsResultsConfig.class);
        ResultsProcessor resultsProcessor = applicationConfig.getBean(ResultsProcessor.class);
        resultsProcessor.convertCsvToAthleticResults("./lesson_2_spring_basics/homework/results.csv");

        List<AthleticsResult> listOfSortedResults = resultsProcessor.getFastestPersonsByDistanceAndTime(
                Gender.FEMALE, Distance.FIVE, 2);
        try {
            for (AthleticsResult rs : listOfSortedResults)
                System.out.println(rs.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}