package info.pragmaticdeveloper;

import java.util.HashMap;
import java.util.Map;

public class MultiLevelKeyDictionaryFlatter {

    public Map<String, String> flattenMap(Map<String, Object> map) {
        Map<String, String> result = new HashMap<>();
        flattenNesting("", map, result);
        return result;
    }

    private void flattenNesting(String parent, Map<String, Object> map, Map<String, String> result) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String) {
                putEntryInResult(parent, result, entry);
            } else {
                flattenNextLevel(parent, result, entry);
            }
        }
    }

    private void flattenNextLevel(String parent, Map<String, String> result, Map.Entry<String, Object> entry) {
        if (parent.isEmpty()) {
            flattenNesting(entry.getKey(), (Map<String, Object>) entry.getValue(), result);
        } else {
            String key = entry.getKey().isEmpty() ? parent : parent + "." + entry.getKey();
            flattenNesting(key, (Map<String, Object>) entry.getValue(), result);
        }
    }

    private void putEntryInResult(String parent, Map<String, String> result, Map.Entry<String, Object> entry) {
        if (parent.isEmpty()) {
            result.put(entry.getKey(), entry.getValue().toString());
        } else {
            String key = entry.getKey().isEmpty() ? parent : parent + "." + entry.getKey();
            result.put(key, entry.getValue().toString());
        }
    }
}
