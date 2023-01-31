package info.pragmaticdeveloper.dsa.graph;

import info.pragmaticdeveloper.dsa.stack.Stack;

import java.util.*;

public class Graph {
    public static class Pair {
        private Integer left;
        private Integer right;

        public Pair(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        public Integer getLeft() {
            return left;
        }

        public void setLeft(Integer left) {
            this.left = left;
        }

        public Integer getRight() {
            return right;
        }

        public void setRight(Integer right) {
            this.right = right;
        }
    }

    public boolean isPathExist(List<Pair> pairs, int source, int destination) {
        Map<Node, List<Node>> graph = buildGraph(pairs);
        return pathExist(graph, new Node(source), new Node(destination));
    }

    public int shortestPath(List<Pair> pairs, int src, int dest) {
        Map<Node, List<Node>> graph = buildGraph(pairs);
        Node sourceNode = getNode(graph.keySet(), src);
        Node destNode = getNode(graph.keySet(), dest);
        return getShortestPath(graph, sourceNode, destNode);
    }

    private int getShortestPath(Map<Node, List<Node>> graph, Node sourceNode, Node destNode) {
        class Walk {
            private Node visitor;
            private int distance;
        }
        Queue<Walk> queue = new LinkedList<>();
        Walk walk = new Walk();
        walk.visitor = sourceNode;
        walk.distance = 0;
        sourceNode.setVisited(true);
        queue.add(walk);
        while (!queue.isEmpty()) {
            Walk currentWalk = queue.poll();
            if (currentWalk.visitor == destNode) {
                return currentWalk.distance;
            }
            for (Node neighbour : graph.get(currentWalk.visitor)) {
                if (!neighbour.isVisited()) {
                    walk = new Walk();
                    neighbour.setVisited(true);
                    walk.visitor = neighbour;
                    walk.distance = currentWalk.distance + 1;
                    queue.add(walk);
                }
            }
        }
        return -1;
    }

    private Node getNode(Set<Node> nodes, int src) {
        return nodes.stream()
                .filter(node -> node.getData() == src)
                .findFirst()
                .orElse(null);
    }

    public int connectedComponent(List<Pair> pairs) {
        Map<Node, List<Node>> graph = buildGraph(pairs);
        int count = 0;
        for (Map.Entry<Node, List<Node>> entry : graph.entrySet()) {
            if (explore(graph, entry.getKey())) {
                count++;
            }
        }
        return count;
    }

    public int maxComponentSize(List<Pair> pairs) {
        Map<Node, List<Node>> graph = buildGraph(pairs);
        int maxComponent = 0;
        for (Map.Entry<Node, List<Node>> entry : graph.entrySet()) {
            Node current = entry.getKey();
            int currentComponentSize = componentSize(graph, current);
            if (currentComponentSize > maxComponent) {
                maxComponent = currentComponentSize;
            }
        }
        return maxComponent;
    }

    private int componentSize(Map<Node, List<Node>> graph, Node current) {
        if (current.isVisited()) {
            return 0;
        }
        current.setVisited(true);
        int size = 1;
        for (Node neighbour : graph.get(current)) {
            size += componentSize(graph, neighbour);
        }
        return size;
    }

    private boolean explore(Map<Node, List<Node>> graph, Node current) {
        if (current == null || current.isVisited()) {
            return false;
        }
        current.setVisited(true);
        for (Node node : graph.get(current)) {
            explore(graph, node);
        }
        return true;
    }

    private boolean pathExist(Map<Node, List<Node>> graph, Node src, Node dest) {
        if (src == null || src.isVisited()) {
            return false;
        }

        if (src.equals(dest)) {
            return true;
        }

        src.setVisited(true);

        for (Node node : graph.get(src)) {
            if (pathExist(graph, node, dest)) {
                return true;
            }
        }
        return false;
    }

    private Map<Node, List<Node>> buildGraph(List<Pair> pairs) {
        Map<Node, List<Node>> graph = new HashMap<>();
        Map<Integer, Node> map = new HashMap<>();
        for (Pair pair : pairs) {
            Node left = getOrCreate(pair.getLeft(), map);
            List<Node> leftNeighbours = getOrInitializeNeighbour(left, graph);
            // if no neighbour exist i.e no outgoing edge from the node
            if (pair.getRight() != null) {
                Node right = getOrCreate(pair.getRight(), map);
                List<Node> rightNeighbours = getOrInitializeNeighbour(right, graph);
                // if neighbour is already added then we don't need to add again
                if (!rightNeighbours.contains(left)) {
                    rightNeighbours.add(left);
                }

                if (!leftNeighbours.contains(right)) {
                    leftNeighbours.add(right);
                }
            }
        }
        return graph;
    }

    private Node getOrCreate(int key, Map<Integer, Node> map) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        Node newNode = new Node(key);
        map.put(key, newNode);
        return newNode;
    }

    private List<Node> getOrInitializeNeighbour(Node key, Map<Node, List<Node>> nodeMap) {
        if (nodeMap.containsKey(key)) {
            return nodeMap.get(key);
        }
        List<Node> neighbour = new ArrayList<>();
        nodeMap.put(key, neighbour);
        return neighbour;
    }

    public List<Node> iterativeDfs(Node start) {
        List<Node> traverseList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            traverseList.add(current);
            for (Node neighbour : current.getNeighbour()) {
                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    stack.push(neighbour);
                }
            }
        }
        return traverseList;
    }

    public List<Node> recursiveDfs(Node start) {
        List<Node> traverseList = new ArrayList<>();
        doRecursiveDfs(start, traverseList);
        return traverseList;
    }

    private void doRecursiveDfs(Node current, List<Node> traverseList) {
        if (current == null || current.isVisited()) {
            return;
        }
        current.setVisited(true);
        traverseList.add(current);
        for (Node neighbour : current.getNeighbour()) {
            doRecursiveDfs(neighbour, traverseList);
        }
    }
}
