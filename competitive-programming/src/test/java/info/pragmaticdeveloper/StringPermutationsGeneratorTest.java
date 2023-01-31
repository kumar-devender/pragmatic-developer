package info.pragmaticdeveloper;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

class StringPermutationsGeneratorTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testPermutation(String input, int expectedSize, String[] expectedItem) {
        StringPermutationsGenerator permutationsGenerator = new StringPermutationsGenerator();
        List<String> result = permutationsGenerator.generate(input);
        assertThat(result, hasSize(expectedSize));
        assertThat(result, containsInAnyOrder(expectedItem));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("ab", 2, new String[]{"ab", "ba"}),
                Arguments.of("a", 1, new String[]{"a"}),
                Arguments.of("abc", 6, new String[]{"abc", "bac", "bca", "acb", "cba", "cab"})
        );
    }
}