package info.pragmaticdeveloper.dsa.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class StoneWallTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void countBlockTypeNeeded(int[] arr, int expect) {
        var result = new StoneWall().countBlockTypeNeeded(arr);
        assertThat(result, is(expect));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}, 7)
        );
    }
}
