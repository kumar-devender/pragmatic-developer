package info.pragmaticdeveloper.dsa.tree;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class TreeLongestZigZagTest {

    public static Stream<Arguments> testDataProvider() {
        Node node5 = new Node(5);
        Node node3 = new Node(3);
        Node node20 = new Node(20);
        node3.setLeft(node20);
        Node node6 = new Node(6);
        node20.setLeft(node6);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        Node node15 = new Node(15);
        node10.setLeft(node1);
        node10.setRight(node15);
        Node node30 = new Node(30);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        node15.setLeft(node30);
        node15.setRight(node8);
        node30.setRight(node9);
        node5.setLeft(node3);
        node5.setRight(node10);
        return Stream.of(
                Arguments.of(node5, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testZigZag(Node node, int expected) {
        TreeLongestZigZag treeLongestZigZag = new TreeLongestZigZag();
        var result = treeLongestZigZag.longestZigZagLength(node);
        assertThat(result, is(expected));
    }
}