package info.pragmaticdeveloper.dsa.array;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class CountDivTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(6, 11, 2, 3),
                Arguments.of(0, 1, 11, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testDivCount(int a, int b, int k, int expected) {
        CountDiv countDiv = new CountDiv();
        var result = countDiv.countDiv(a, b, k);
        assertThat(result, equalTo(expected));
    }
}