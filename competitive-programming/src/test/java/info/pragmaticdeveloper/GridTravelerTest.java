package info.pragmaticdeveloper;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GridTravelerTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMaxMove(int row, int column, int expectedResult) {
        GridTraveler gridTraveler = new GridTraveler();
        int result = gridTraveler.maxMove(row, column);
        assertThat(result, is(expectedResult));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(Arguments.of(3, 3, 6),
                Arguments.of(1, 1, 1),
                Arguments.of(2, 3, 3));
    }
}