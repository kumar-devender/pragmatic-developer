package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MinMaxDivisionTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void getMinPossibleBlockSize(int K, int M, int[] input, int expected) {
        var result = new MinMaxDivision().getMinPossibleBlockSize(K, M, input);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(3, 5, new int[]{2, 1, 5, 1, 2, 2, 2}, 6)
        );
    }
}