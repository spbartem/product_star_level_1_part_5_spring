package product.star.athletics.result.manager;

import java.util.Objects;
import java.util.stream.Stream;

public enum Gender {
    MALE("Ì"), FEMALE("Æ");

    private String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Gender fromCode(String code) {
        return Stream.of(Gender.values())
                .filter(gender -> Objects.equals(gender.getCode(), code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown gender:" + code));
    }
}
