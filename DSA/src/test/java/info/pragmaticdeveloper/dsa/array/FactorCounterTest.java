package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class FactorCounterTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testFactorCount(int num, int expectedResult) {
        int result = new FactorCounter().count(num);
        assertThat(result, is(expectedResult));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(16, 5),
                Arguments.of(24, 8),
                Arguments.of(36, 9),
                Arguments.of(1, 1),
                Arguments.of(2147395600, 135)
        );
    }
}