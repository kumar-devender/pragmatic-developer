package info.pragmaticdeveloper.dsa.list;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SinglyLinkedList<T> {
    private Node headNode;
    private int size;

    public class Node {
        private T data;
        private Node nextNode;
    }

    public List<T> getElements() {
        return Stream.iterate(headNode, Objects::nonNull, node -> node.nextNode)
                .map(node -> node.data)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return size;
    }

    void insertFirst(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    void insertAfter(T data, T previous) {
        Node current = headNode;
        while (current != null && !current.data.equals(previous)) {
            current = current.nextNode;
        }
        if (current != null) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.nextNode = current.nextNode;
            current.nextNode = newNode;
            size++;
        }
    }

    void insertLast(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            insertFirst(data);
            return;
        }

        Node current = headNode;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        current.nextNode = newNode;
        size++;
    }

    void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }

        Node current = headNode;
        Node previous = null;
        if (current.data.equals(data)) {
            deleteAtFirst();
            return;
        }
        while (current != null) {
            if (current.data.equals(data)) {
                previous.nextNode = current.nextNode;
                size--;
                return;
            }
            previous = current;
            current = current.nextNode;
        }
    }

    void deleteAtFirst() {
        if (isEmpty()) {
            return;
        }
        headNode = headNode.nextNode;
        size--;
    }

    boolean isPresent(T data) {
        Node current = headNode;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    boolean isEmpty() {
        return headNode == null;
    }
}
