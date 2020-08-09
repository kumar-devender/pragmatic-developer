package info.pragmaticdeveloper.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

public enum CountryCode {
    IT("IT"),
    DE("DE"),
    FR("FR"),
    IN("IN"),
    US("US"),
    CN("CN"),
    AF("AF"),
    AR("AR");

    private static final Map<String, CountryCode> BY_VALUE = stream(CountryCode.values())
            .collect(collectingAndThen(toMap(CountryCode::getValue, identity()),
                    Collections::unmodifiableMap));

    private final String value;

    CountryCode(String attributeValue) {
        this.value = attributeValue;
    }

    public static Optional<CountryCode> fromValue(String attributeValue) {
        return ofNullable(BY_VALUE.get(attributeValue));
    }

    public String getValue() {
        return value;
    }
}
