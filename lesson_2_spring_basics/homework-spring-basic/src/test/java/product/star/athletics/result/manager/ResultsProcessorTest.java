package product.star.athletics.result.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultsProcessorTest {
    private ResultsProcessor resultsProcessor;
    @BeforeEach
    void setUp() {
        var applicationConfig = new AnnotationConfigApplicationContext(AthleticsResultsConfig.class);
        resultsProcessor = applicationConfig.getBean(ResultsProcessor.class);
    }

    @Test
    void convertCsvToAthleticResults() throws IOException {
        List<AthleticsResult> athleticsResults
                = new ArrayList<>(resultsProcessor.convertCsvToAthleticResults("src/results.csv"));
        Assertions.assertEquals(7, athleticsResults.size());
    }

    @Test
    void getFastestPersonsByDistanceAndTime() {
        List<AthleticsResult> athleticsSortedResults =
                resultsProcessor.getFastestPersonsByDistanceAndTime(Gender.MALE, Distance.TEN, 2);

        List<AthleticsResult> athleticsExpectedSortedResults = new ArrayList<>();
        AthleticsResult result1 =
                new AthleticsResult("Antonov Antov", Gender.MALE, Distance.TEN, Duration.parse("PT33M33S"));
        AthleticsResult result2 =
                new AthleticsResult("Petrov Petr", Gender.MALE, Distance.TEN, Duration.parse("PT59M47S"));
        athleticsExpectedSortedResults.add(result1);
        athleticsExpectedSortedResults.add(result2);

        assertTrue(athleticsExpectedSortedResults.containsAll(athleticsSortedResults));
    }
}