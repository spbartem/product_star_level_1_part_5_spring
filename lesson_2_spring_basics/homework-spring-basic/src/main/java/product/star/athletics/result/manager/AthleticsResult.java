package product.star.athletics.result.manager;

import java.time.Duration;
import java.util.Objects;

public class AthleticsResult {
    private String fio;
    Gender gender;
    Distance distance;
    private Duration duration;

    public AthleticsResult(String fio, Gender gender, Distance distance, Duration duration) {
        this.fio = fio;
        this.gender = gender;
        this.distance = distance;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AthleticsResult that = (AthleticsResult) o;
        return fio.equals(that.fio) && gender == that.gender && distance == that.distance && duration.equals(that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, gender, distance, duration);
    }

    public Gender getGender() {
        return gender;
    }

    public Distance getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "AthleticsResult{" +
                "fio='" + fio + '\'' +
                ", gender=" + gender +
                ", distance=" + distance +
                ", duration=" + duration +
                '}';
    }
}
