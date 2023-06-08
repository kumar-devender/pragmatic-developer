package info.pragmaticdeveloper.dsa.heap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class MergeSortedListTest {

    public static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(new ListNode[]{buildNodeChain(1, 2, 3, 5, 7),
                                buildNodeChain(3, 6, 10, 12, 45),
                                buildNodeChain(3, 4, 7, 9, 11)},
                        buildNodeChain(1, 2, 3, 3, 3, 4, 5, 6, 7, 7, 9, 10, 11, 12, 45)),
                Arguments.of(new ListNode[]{}, null),
                Arguments.of(new ListNode[]{buildNodeChain(-2, -1, -1, -1)},
                        buildNodeChain(-2, -1, -1, -1))
        );
    }

    private static ListNode buildNodeChain(int... values) {
        ListNode first = new ListNode(0);
        ListNode current = first;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return first.next;
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void merge(ListNode[] nodes, ListNode expected) {
        var result = new MergeSortedList().merge(nodes);
        assertThat(result, equalTo(expected));
    }
}