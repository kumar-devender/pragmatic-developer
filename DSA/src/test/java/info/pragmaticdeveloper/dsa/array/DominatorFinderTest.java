package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DominatorFinderTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 3, 2, 3, -1, 3, 3}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void findDominator(int[] input, int expected) {
        var actual = new DominatorFinder().findDominator(input);
        assertThat(actual, is(expected));
    }
}