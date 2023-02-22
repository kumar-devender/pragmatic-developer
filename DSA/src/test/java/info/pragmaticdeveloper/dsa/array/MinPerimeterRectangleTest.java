package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MinPerimeterRectangleTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(36, 24),
                Arguments.of(30, 22)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void getMinPerimeterRectangle(int n, int expect) {
        var result = new MinPerimeterRectangle().getMinPerimeterRectangle(n);
        assertThat(result, is(expect));
    }
}
