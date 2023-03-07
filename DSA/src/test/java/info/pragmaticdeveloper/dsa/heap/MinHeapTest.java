package info.pragmaticdeveloper.dsa.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class MinHeapTest {

    private static Stream<Arguments> peekTestDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 2, 5, 7, 8, 1}, 1, 7)
        );
    }

    private static Stream<Arguments> pollTestDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 2, 5, 7, 8, 1}, new int[]{1, 2, 3, 4, 5, 7, 8})
        );
    }

    @ParameterizedTest(name = "{index} : given {0} then peek return {1}")
    @MethodSource("peekTestDataProvider")
    void peek(int[] arr, int expectedTop, int expectedSize) {
        var minHeap = new MinHeap<>(Integer.class, arr.length);
        Arrays.stream(arr)
                .boxed()
                .forEach(minHeap::add);
        assertThat(minHeap.peek(), is(expectedTop));
        assertThat(minHeap.getSize(), is(expectedSize));
    }

    @ParameterizedTest(name = "{index} : given {0} then poll return {1}")
    @MethodSource("pollTestDataProvider")
    void poll(int[] arr, int[] expected) {
        var minHeap = new MinHeap<>(Integer.class, arr.length);
        Arrays.stream(arr)
                .boxed()
                .forEach(minHeap::add);
        Arrays.stream(expected)
                .forEach(topItem -> assertThat(minHeap.poll(), is(topItem)));
        assertThat(minHeap.isEmpty(), is(true));
    }
}