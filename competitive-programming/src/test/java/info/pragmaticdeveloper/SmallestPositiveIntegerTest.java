package info.pragmaticdeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SmallestPositiveIntegerTest {
    private SmallestPositiveIntegerFinder smallestPositiveIntegerFinder;

    @BeforeEach
    void setUp() {
        smallestPositiveIntegerFinder = new SmallestPositiveIntegerFinder();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testSmallestPositiveInteger(int inputArr[], int expected) {
        int actual = smallestPositiveIntegerFinder.getSmallestPositiveInteger(inputArr);
        assertThat(actual, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 4),
                Arguments.of(new int[]{1, 3, 6, 4, 1, 2}, 5),
                Arguments.of(new int[]{1, 1, 0, -1, -2}, 2),
                Arguments.of(new int[]{2, 3, 7, 6, 8, -1, -10, 15}, 1),
                Arguments.of(new int[]{2, 3, -7, 6, 8, 1, -10, 15}, 4),
                Arguments.of(new int[]{-1, -3}, 1)
        );
    }
}