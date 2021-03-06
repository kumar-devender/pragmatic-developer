package info.pragmaticdeveloper;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class DictionaryFlatterTest {
    private DictionaryFlatter dictionaryFlatter;

    @BeforeEach
    void setUp() {
        dictionaryFlatter = new DictionaryFlatter();
    }

    @MethodSource("dataProvider")
    @ParameterizedTest
    void testFlattenMap(Map<String, Object> input, Map<String, String> expectedMap) {
        Map<String, String> result = dictionaryFlatter.flatten(input);
        MatcherAssert.assertThat(result, Matchers.aMapWithSize(5));
        for (Map.Entry<String, String> entry : expectedMap.entrySet()) {
            MatcherAssert.assertThat(result, IsMapContaining.hasEntry(entry.getKey(), entry.getValue()));
        }
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(Arguments.of(buildInputMap(), buildExpected()));

    }

    private static Map<String, String> buildExpected() {
        Map<String, String> map = new HashMap<>();
        map.put("", "1");
        map.put("Key1", "1");
        map.put("a", "2");
        map.put("b", "3");
        map.put("d", "3");
        return map;
    }

    private static Map<String, Object> buildInputMap() {
        HashMap<String, Object> map = new HashMap<>();
        Map<String, Object> mapLevel1 = new HashMap<>();
        Map<String, Object> mapLevel2 = new HashMap<>();
        Map<String, Object> mapLevel3 = new HashMap<>();

        mapLevel3.put("", "1");

        mapLevel2.put("d", "3");
        mapLevel2.put("e", mapLevel3);

        mapLevel1.put("a", "2");
        mapLevel1.put("b", "3");
        mapLevel1.put("c", mapLevel2);

        map.put("Key1", "1");
        map.put("Key2", mapLevel1);
        return map;
    }
}