package info.pragmaticdeveloper.dsa.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class MaxMinFormTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 1, 4, 2, 3}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 1, 6, 2, 5, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 1, 3, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testArrange(int[] input, int[] expected) {
        var result = new MaxMinForm().arrangeUsingTempArray(input);
        assertThat(result, equalTo(expected));
    }
}
