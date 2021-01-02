package info.pragmaticdeveloper;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

class CyclicCharacterIncrementerTest {
    private CyclicCharacterIncrementer cyclicCharacterIncrementer;

    @BeforeEach
    void setUp() {
        cyclicCharacterIncrementer = new CyclicCharacterIncrementer();
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void testCharacterIncrementer(String input, int counter, String expected) {
        String output = cyclicCharacterIncrementer.incrementChars(input, counter);
        assertThat(output, CoreMatchers.equalTo(expected));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("abc", 2, "cde"),
                Arguments.of("zab", 2, "bcd"),
                Arguments.of("abc", 54, "cde"),
                Arguments.of("abc", 28, "cde")
        );
    }
}