package info.pragmaticdeveloper.dsa.array;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class NonDivisorCountFinderTest {

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2, 3, 6}, new int[]{2, 4, 3, 2, 0})
//                Arguments.of(new int[]{2}, new int[]{0}),
//                Arguments.of(new int[]{4, 4}, new int[]{0, 0}),
//                Arguments.of(new int[]{2, 2, 2}, new int[]{0, 0, 0})
        );
    }

    @ParameterizedTest(name = "for input {0} ->> expect {1}")
    @MethodSource("testDataProvider")
    void testNonDivisorCount(int[] arr, int[] expected) {
        var result = new NonDivisorCountFinder().getNonDivisorCount(arr);
        assertThat(result, equalTo(expected));
    }

}