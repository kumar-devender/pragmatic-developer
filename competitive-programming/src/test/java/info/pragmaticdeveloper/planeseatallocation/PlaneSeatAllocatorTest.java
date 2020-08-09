package info.pragmaticdeveloper.planeseatallocation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PlaneSeatAllocatorTest {
    private PlaneSeatAllocator seatAllocator;

    @BeforeEach
    void setUp() {
        seatAllocator = new PlaneSeatAllocator();
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testSolution(Integer rows, String reservedSeats, Integer expected) {
        int actual = seatAllocator.solution(rows, reservedSeats);
        assertThat(actual, is(expected));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(2, "1A 2F 1C", 2),
                Arguments.of(2, "1C 1E 1F", 2),
                Arguments.of(1, "1C 1E 1F", 0),
                Arguments.of(1, "", 2)
        );
    }
}