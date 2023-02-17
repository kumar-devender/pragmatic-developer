package info.pragmaticdeveloper.dsa.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class AliveFishPredictorTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void countAliveFish(int[] sizes, int[] movement, int expected) {
        var result = new AliveFishPredictor().countAliveFish(sizes, movement);
        assertThat(result, is(expected));
    }
}