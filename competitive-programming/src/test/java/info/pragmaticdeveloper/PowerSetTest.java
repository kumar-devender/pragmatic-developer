package info.pragmaticdeveloper;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class PowerSetTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testPowerSet(String[] arr, int expectedSetSide) {
        PowerSet powerSet = new PowerSet();
        List<List<String>> result = powerSet.powerSet(arr);
        assertThat(result, hasSize(expectedSetSide));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
//                Arguments.of(new String[]{"a1", "a2"}, 4),
                Arguments.of(new String[]{"a1", "a2", "a3"}, 8)
                );
    }
}