package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MaxProfitFinderTest {


    @ParameterizedTest
    @MethodSource("testDataProvider")
    void maxPossibleProfit(int[] price, int expected) {
        int result = new MaxProfitFinder().maxPossibleProfit(price);
        assertThat(result, is(expected));
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void maxPossibleProfitBruteForce(int[] price, int expected) {
        int result = new MaxProfitFinder().maxPossibleProfitBruteForce(price);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{23171, 21011, 21123, 21366, 21013, 21367}, 356),
                Arguments.of(new int[]{9, 2, 7, 1, 3}, 5),
                Arguments.of(new int[]{9, 2, 7, 1, 3, 6, 8, 7, 4}, 7)
        );
    }
}