package info.pragmaticdeveloper.dsa.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderLevelTest {
    public static Stream<Arguments> testDataProvider() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.setLeft(node2);
        node1.setRight(node3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.setLeft(node4);
        node2.setRight(node5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node3.setLeft(node6);
        node3.setRight(node7);
        return Stream.of(
                Arguments.of(node1, new int[]{1, 2, 3, 4, 5, 6, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testLevelOrder(Node node, int[] expected) {
        var result = node.levelOrder();
        assertThat(result, is(expected));
    }
}
