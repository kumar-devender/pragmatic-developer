package info.pragmaticdeveloper.dsa.recursion;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class AnagramTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("cat", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testAnaGram(String input, Integer expectedSize) {
        Anagram anagram = new Anagram();
        List<String> result = anagram.getAnagram(input);
        assertThat(result, hasSize(expectedSize));
    }
}