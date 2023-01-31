package info.pragmaticdeveloper.dsa.tree;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class DFSTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testdfsRecursive(Node root, List<Node> expected) {
        DFS dfs = new DFS();
        List<Node> result = dfs.dfsRecursive(root);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testdfsIterative(Node root, List<Node> expected) {
        DFS dfs = new DFS();
        List<Node> result = dfs.dfsIterative(root);
        assertThat(result, equalTo(expected));
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
        return Stream.of(Arguments.of(node50, Arrays.asList(node50, node10, node5, node30, node80, node70, node90)));
    }
}