package info.pragmaticdeveloper.dsa.tree;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class TreeTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testMaxRootToLeafPathSum(Node root, int expected) {
        Tree tree = new Tree();
        int result = tree.maxRootToLeafSum(root);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("testMinDataProvider")
    void testMinElement(Node root, int expected) {
        Tree tree = new Tree();
        int result = tree.minElement(root);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("testSumDataProvider")
    void testSumAllNode(Node root, int expected) {
        Tree tree = new Tree();
        int result = tree.sumAllNodeIterative(root);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("testMinDataProvider")
    void testMinElementIterative(Node root, int expected) {
        Tree tree = new Tree();
        int result = tree.minElementIterative(root);
        assertThat(result, equalTo(expected));
    }

    public static Stream<Arguments> testMinDataProvider() {
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
        return Stream.of(
                Arguments.of(node50, 5),
                Arguments.of(node80, 70),
                Arguments.of(node70, 70)
        );
    }

    public static Stream<Arguments> testSumDataProvider() {
        Node node50 = new Node(50);
        Node node60 = new Node(60);
        Node node90 = new Node(90);
        Node node5 = new Node(5);
        node60.setLeft(node5);
        node60.setRight(node90);

        Node node65 = new Node(65);
        Node node62 = new Node(62);
        node65.setLeft(node62);
        node65.setRight(node90);

        Node node55 = new Node(55);
        node62.setLeft(node55);
        return Stream.of(
                Arguments.of(node50, 50),
                Arguments.of(node65, 272),
                Arguments.of(node60, 155)
        );
    }

    public static Stream<Arguments> testDataProvider() {
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

        Node node60 = new Node(60);
        node60.setLeft(node5);
        node60.setRight(node90);

        Node node65 = new Node(65);
        Node node62 = new Node(62);
        node65.setLeft(node62);
        node65.setRight(node90);

        Node node55 = new Node(55);
        node62.setLeft(node55);
        return Stream.of(
                Arguments.of(node50, 220),
                Arguments.of(node60, 150),
                Arguments.of(node65, 182)
        );
    }
}
