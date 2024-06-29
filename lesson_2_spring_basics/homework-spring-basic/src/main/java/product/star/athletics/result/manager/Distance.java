package product.star.athletics.result.manager;

import java.util.Objects;
import java.util.stream.Stream;

public enum Distance {
    FIVE("5"), TEN("10");

    private String code;

    Distance(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Distance fromCode(String code) {
        return Stream.of(Distance.values())
                .filter(distance -> Objects.equals(distance.getCode(), code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown distance:" + code));
    }
}
