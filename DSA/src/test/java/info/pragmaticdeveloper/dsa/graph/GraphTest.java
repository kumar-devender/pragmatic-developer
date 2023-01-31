package info.pragmaticdeveloper.dsa.graph;

import info.pragmaticdeveloper.dsa.graph.Graph.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class GraphTest {

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void testIterativeDfs(Node start, List<Node> expected) {
        Graph graph = new Graph();
        List<Node> result = graph.iterativeDfs(start);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("connectedComponentTestProvider")
    void testConnectedComponent(List<Pair> pairs, int expected) {
        Graph graph = new Graph();
        int result = graph.connectedComponent(pairs);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("shortestPathTestProvider")
    void shortestPathComponent(List<Pair> pairs, int source, int dest, int expected) {
        Graph graph = new Graph();
        int result = graph.shortestPath(pairs, source, dest);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("maxComponentSizeTestProvider")
    void testMaxComponentSize(List<Pair> pairs, int expected) {
        Graph graph = new Graph();
        int result = graph.maxComponentSize(pairs);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("testDataProviderRecursiveDFS")
    void testRecursiveDfs(Node start, List<Node> expected) {
        Graph graph = new Graph();
        List<Node> result = graph.recursiveDfs(start);
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @MethodSource("undirectedPathTestProviderRecursiveDFS")
    void testUndirectedPath(List<Pair> pairs, int src, int dest, boolean expected) {
        Graph graph = new Graph();
        boolean result = graph.isPathExist(pairs, src, dest);
        assertThat(result, is(expected));
    }

    private static Stream<Arguments> undirectedPathTestProviderRecursiveDFS() {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(50, 90));
        pairs.add(new Pair(50, 10));
        pairs.add(new Pair(90, 5));
        pairs.add(new Pair(90, 30));
        pairs.add(new Pair(90, 80));
        pairs.add(new Pair(10, 70));
        pairs.add(new Pair(80, 70));
        return Stream.of(
                Arguments.of(pairs, 50, 80, true),
                Arguments.of(pairs, 50, 70, true),
                Arguments.of(pairs, 10, 30, true),
                Arguments.of(pairs, 70, 5, true)
        );
    }

    private static Stream<Arguments> shortestPathTestProvider() {
        List<Pair> pairs1 = new ArrayList<>();
        pairs1.add(new Pair(0, 8));
        pairs1.add(new Pair(0, 1));
        pairs1.add(new Pair(0, 5));
        pairs1.add(new Pair(1, 0));
        pairs1.add(new Pair(5, 0));
        pairs1.add(new Pair(5, 8));
        pairs1.add(new Pair(8, 0));
        pairs1.add(new Pair(8, 5));
        pairs1.add(new Pair(2, 3));
        pairs1.add(new Pair(2, 4));
        pairs1.add(new Pair(3, 2));
        pairs1.add(new Pair(3, 4));
        pairs1.add(new Pair(4, 2));
        pairs1.add(new Pair(4, 3));

        List<Pair> pairs2 = new ArrayList<>();
        pairs2.add(new Pair(0, 4));
        pairs2.add(new Pair(0, 7));
        pairs2.add(new Pair(1, null));
        pairs2.add(new Pair(2, null));
        pairs2.add(new Pair(3, 6));
        pairs2.add(new Pair(4, 0));
        pairs2.add(new Pair(6, 3));
        pairs2.add(new Pair(7, 0));
        pairs2.add(new Pair(8, null));
        return Stream.of(
                Arguments.of(pairs1, 0, 1, 1),
                Arguments.of(pairs1, 5, 1, 2),
                Arguments.of(pairs1, 0, 8, 1),
                Arguments.of(pairs1, 5, 8, 1),
                Arguments.of(pairs1, 5, 2, -1),
                Arguments.of(pairs1, 2, 4, 1),
                Arguments.of(pairs2, 3, 6, 1),
                Arguments.of(pairs2, 7, 0, 1),
                Arguments.of(pairs2, 8, 1, -1)
        );
    }

    private static Stream<Arguments> connectedComponentTestProvider() {
        List<Pair> pairs1 = new ArrayList<>();
        pairs1.add(new Pair(0, 8));
        pairs1.add(new Pair(0, 1));
        pairs1.add(new Pair(0, 5));
        pairs1.add(new Pair(1, 0));
        pairs1.add(new Pair(5, 0));
        pairs1.add(new Pair(5, 8));
        pairs1.add(new Pair(8, 0));
        pairs1.add(new Pair(8, 5));
        pairs1.add(new Pair(2, 3));
        pairs1.add(new Pair(2, 4));
        pairs1.add(new Pair(3, 2));
        pairs1.add(new Pair(3, 4));
        pairs1.add(new Pair(4, 2));
        pairs1.add(new Pair(4, 3));

        List<Pair> pairs2 = new ArrayList<>();
        pairs2.add(new Pair(0, 4));
        pairs2.add(new Pair(0, 7));
        pairs2.add(new Pair(1, null));
        pairs2.add(new Pair(2, null));
        pairs2.add(new Pair(3, 6));
        pairs2.add(new Pair(4, 0));
        pairs2.add(new Pair(6, 3));
        pairs2.add(new Pair(7, 0));
        pairs2.add(new Pair(8, null));
        return Stream.of(
                Arguments.of(pairs1, 2),
                Arguments.of(pairs2, 5)
        );
    }

    private static Stream<Arguments> maxComponentSizeTestProvider() {
        List<Pair> pairs1 = new ArrayList<>();
        pairs1.add(new Pair(0, 8));
        pairs1.add(new Pair(0, 1));
        pairs1.add(new Pair(0, 5));
        pairs1.add(new Pair(1, 0));
        pairs1.add(new Pair(5, 0));
        pairs1.add(new Pair(5, 8));
        pairs1.add(new Pair(8, 0));
        pairs1.add(new Pair(8, 5));
        pairs1.add(new Pair(2, 3));
        pairs1.add(new Pair(2, 4));
        pairs1.add(new Pair(3, 2));
        pairs1.add(new Pair(3, 4));
        pairs1.add(new Pair(4, 2));
        pairs1.add(new Pair(4, 3));

        List<Pair> pairs2 = new ArrayList<>();
        pairs2.add(new Pair(0, 4));
        pairs2.add(new Pair(0, 7));
        pairs2.add(new Pair(1, null));
        pairs2.add(new Pair(2, null));
        pairs2.add(new Pair(3, 6));
        pairs2.add(new Pair(4, 0));
        pairs2.add(new Pair(6, 3));
        pairs2.add(new Pair(7, 0));
        pairs2.add(new Pair(8, null));
        return Stream.of(
                Arguments.of(pairs1, 4),
                Arguments.of(pairs2, 3)
        );
    }

    private static Stream<Arguments> testDataProvider() {
        Node node50 = new Node(50);
        Node node10 = new Node(10);

        Node node5 = new Node(5);
        Node node30 = new Node(30);
        Node node70 = new Node(70);
        node10.addNeighbour(node70);

        Node node90 = new Node(90);
        Node node80 = new Node(80);
        node90.addNeighbour(node30);
        node90.addNeighbour(node80);
        node90.addNeighbour(node5);
        node80.addNeighbour(node70);
        node50.addNeighbour(node10);
        node50.addNeighbour(node90);
        return Stream.of(
                Arguments.of(node50, Arrays.asList(node50, node90, node5, node80, node70, node30, node10))
        );
    }

    private static Stream<Arguments> testDataProviderRecursiveDFS() {
        Node node50 = new Node(50);
        Node node10 = new Node(10);

        Node node5 = new Node(5);
        Node node30 = new Node(30);
        Node node70 = new Node(70);
        node10.addNeighbour(node70);

        Node node90 = new Node(90);
        Node node80 = new Node(80);
        node90.addNeighbour(node30);
        node90.addNeighbour(node80);
        node90.addNeighbour(node5);
        node80.addNeighbour(node70);
        node50.addNeighbour(node10);
        node50.addNeighbour(node90);
        return Stream.of(
                Arguments.of(node50, Arrays.asList(node50, node10, node70, node90, node30, node80, node5))
        );
    }
}
