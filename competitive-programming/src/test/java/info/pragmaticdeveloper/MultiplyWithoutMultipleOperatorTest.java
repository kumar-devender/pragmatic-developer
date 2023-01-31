package info.pragmaticdeveloper;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MultiplyWithoutMultipleOperatorTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMultipleWithoutOperator(int larger, int smaller, int expected) {
        MultiplyWithoutMultipleOperator withoutMultipleOperator = new MultiplyWithoutMultipleOperator();
        int result = withoutMultipleOperator.multiply(larger, smaller);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(4, 4, 16),
                Arguments.of(4, 3, 12),
                Arguments.of(8, 7, 56),
                Arguments.of(6539, 5498, 35951422),
                Arguments.of(35951, 35914, 1291144214)
        );
    }
}
