package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class CountCoinPhaseTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void countCoinPhase(int coin, int expected) {
        var result = new CountCoinPhase().countCoinPhase(coin);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(10, 3)
        );
    }
}
