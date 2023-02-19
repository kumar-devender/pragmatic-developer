package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DominatorFinderTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testFindDominator(int[] input, int expected) {
        var actual = new DominatorFinder().findDominator(input);
        assertThat(actual, is(expected));
    }

    @ParameterizedTest
    @MethodSource("equiLeaderCountProvider")
    void testFindEquiLeaderCount(int[] input, int expected) {
        var actual = new DominatorFinder().equiLeaderCount(input);
        assertThat(actual, is(expected));
    }

    private static Stream<Arguments> equiLeaderCountProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 4, 4, 4, 2}, 2),
                Arguments.of(new int[]{4, 4, 2, 5, 3, 4, 4, 4}, 3),
                Arguments.of(new int[]{4, 4, 2}, 0),
                Arguments.of(new int[]{0, 0}, 1),
                Arguments.of(new int[]{1, 2}, 0)
        );
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 3, 2, 3, -1, 3, 3}, 7)
        );
    }
}