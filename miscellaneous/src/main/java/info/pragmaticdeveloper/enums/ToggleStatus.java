package info.pragmaticdeveloper.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ToggleStatus {
    OFF("off"),
    ON("on");
    private final String status;

    private static final Map<String, ToggleStatus> map = Stream.of(ToggleStatus.values())
            .collect(Collectors.toMap((val) -> val.status, Function.identity()));

    public static ToggleStatus getByName(String name) {
        return map.get(name);
    }

    ToggleStatus(String name) {
        this.status = name;
    }

    @Override
    public String toString() {
        return Character.toUpperCase(status.charAt(0)) + status.substring(1);
    }
}
