package product.star.athletics.result.manager;

import java.io.FileNotFoundException;
import java.util.List;

public interface ResultsProcessor {
    List<AthleticsResult> convertCsvToAthleticResults(String path) throws FileNotFoundException;
    List<AthleticsResult> getFastestPersonsByDistanceAndTime(Gender gender, Distance distance, int limit);
}
