package info.pragmaticdeveloper;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DictionaryFlatter {

    public Map<String, String> flatten(Map<String, Object> map) {
        return flattenMap(map)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Stream<Map.Entry<String, String>> flattenMap(Map<String, Object> map) {
        return map.entrySet()
                .stream()
                .flatMap(this::flatEntry);
    }

    private Stream<Map.Entry<String, String>> flatEntry(Map.Entry<String, Object> entry) {
        if (entry.getValue() instanceof String) {
            return Stream.of(new AbstractMap.SimpleEntry(entry.getKey(), entry.getValue()));
        } else {
            return flattenMap((Map<String, Object>) entry.getValue());
        }
    }
}
