package info.pragmaticdeveloper.dsa.tree;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BSTTest {

    @ParameterizedTest
    @MethodSource("bstTestDataProvider")
    void testBst(Node root, boolean expected) {
        BST BST = new BST();
        boolean result = BST.check(root);
        assertThat(result, is(expected));
    }

    @ParameterizedTest
    @MethodSource("balanceTestDataProvider")
    void testBalanced(Node root, boolean expected) {
        BST BST = new BST();
        boolean result = BST.isBalancedByRecursiveSubtreesHeight(root);
        assertThat(result, is(expected));
    }

    @ParameterizedTest
    @MethodSource("balanceTestDataProvider")
    void testBalancedByMeasuringHeightAtEachLevel(Node root, boolean expected) {
        BST BST = new BST();
        boolean result = BST.isBalancedByHeightCheckOnEachLevel(root);
        assertThat(result, is(expected));
    }

    public static Stream<Arguments> balanceTestDataProvider() {
        Node node50 = new Node(50);
        Node node10 = new Node(10);
        Node node80 = new Node(80);
        node50.setLeft(node10);
        node50.setRight(node80);
        Node node8 = new Node(8);
        Node node12 = new Node(12);
        node10.setLeft(node8);
        node10.setRight(node12);
        Node node66 = new Node(66);
        Node node86 = new Node(86);
        node80.setRight(node86);
        node80.setLeft(node66);

        Node node6 = new Node(6);
        Node node3 = new Node(3);
        node6.setLeft(node3);
        node6.setRight(node10);
        Node node2 = new Node(2);
        node3.setLeft(node2);
        Node node1 = new Node(1);
        node2.setLeft(node1);
        return Stream.of(
                Arguments.of(node50, true),
                Arguments.of(node6, false)
        );
    }

    private static Stream<Arguments> bstTestDataProvider() {
        Node node50 = new Node(50);
        Node node10 = new Node(10);
        Node node80 = new Node(80);
        node50.setLeft(node10);
        node50.setRight(node80);
        Node node5 = new Node(5);
        Node node30 = new Node(30);
        node10.setLeft(node5);
        node10.setRight(node30);
        Node node70 = new Node(70);
        Node node90 = new Node(90);
        node80.setLeft(node70);
        node80.setRight(node90);

        Node node12 = new Node(12);
        node12.setRight(node10);
        node12.setLeft(node5);
        return Stream.of(
                Arguments.of(node50, true),
                Arguments.of(node80, true),
                Arguments.of(node10, true),
                Arguments.of(node12, false)
        );
    }
}
