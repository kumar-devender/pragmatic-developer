package info.pragmaticdeveloper.dsa.array;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class GenomicRangeQueryUnitTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}, new int[]{2, 4, 1}),
                Arguments.of("AC", new int[]{0, 0, 1}, new int[]{0, 1, 1}, new int[]{1, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMinImpact(String input, int[] P, int[] Q, int[] expected) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        int[] result = genomicRangeQuery.getMinimalImpactFactor(input, P, Q);
        assertThat(result, equalTo(expected));
    }
}