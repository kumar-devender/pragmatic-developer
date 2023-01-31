package info.pragmaticdeveloper.dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private List<Node> neighbour = new ArrayList<>();
    private Integer data;
    private boolean visited;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", visited=" + visited +
                '}';
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Node(int data) {
        this.data = data;
    }

    public List<Node> getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(List<Node> neighbour) {
        this.neighbour = neighbour;
    }

    public void addNeighbour(Node neighbour) {
        this.neighbour.add(neighbour);
    }

    public void addNeighbours(List<Node> neighbour) {
        this.neighbour.addAll(neighbour);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
