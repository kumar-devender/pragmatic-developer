package info.pragmaticdeveloper.enums;


import org.hamcrest.core.Is;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

class ToggleStatusTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("off", ToggleStatus.OFF),
                Arguments.of("on", ToggleStatus.ON)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testEnumByString(String input, ToggleStatus expected) {
        assertThat(ToggleStatus.getByName(input), Is.is(expected));
    }
}