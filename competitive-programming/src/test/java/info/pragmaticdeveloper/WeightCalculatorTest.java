package info.pragmaticdeveloper;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WeightCalculatorTest {
    private WeightCalculator weightCalculator;

    @BeforeEach
    void setUp() {
        weightCalculator = new WeightCalculator();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void calculate(String input, int expected) {
        int actual = weightCalculator.calculate(input);
        MatcherAssert.assertThat(actual, CoreMatchers.is(expected));
    }


    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("10B20 20B10 10 5B10", 460)
        );
    }
}