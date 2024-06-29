package product.star.athletics.result.manager;

import org.springframework.stereotype.Service;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InMemoryResultsProcessor implements ResultsProcessor {
    private final List<AthleticsResult> athleticsResults = new ArrayList<>();

    @Override
    public List<AthleticsResult> convertCsvToAthleticResults(String path) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\t");
                AthleticsResult athleticsResult = new AthleticsResult(split[0], Gender.fromCode(split[1]), Distance.fromCode(split[2]), getDurationFromString(split[3]));
                athleticsResults.add(athleticsResult);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return athleticsResults;
    }

    public static Duration getDurationFromString(String duration) {
        //format hours:minutes:seconds
        String[] separatedIntervals = duration.split(":");

        switch (separatedIntervals.length) {
            case 2:
                return Duration.ofSeconds(Integer.parseInt(separatedIntervals[0]) * 60L +
                        Integer.parseInt(separatedIntervals[1]));
            case 3:
                return Duration.ofSeconds(Integer.parseInt(separatedIntervals[0]) * 3600L +
                        Integer.parseInt(separatedIntervals[1]) * 60L + Integer.parseInt(separatedIntervals[2]));
            default:
                throw new IllegalArgumentException("Unknown duration: " + duration);
        }
    }

    @Override
    public List<AthleticsResult> getFastestPersonsByDistanceAndTime (Gender gender, Distance distance, int upTo) {
        return athleticsResults.stream()
                .filter(result -> result.getGender().equals(gender) && result.getDistance().equals(distance))
                .sorted(Comparator.comparing(AthleticsResult::getDuration))
                .limit(upTo)
                .collect(Collectors.toList());
    }
}
