package info.pragmaticdeveloper.dsa.list;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CycleDetection {
    public static void main(String[] args) {
        Node<String> head = new Node<>("head");
        Node<String> item1 = new Node<>("item1");
        head.next = item1;
        Node<String> item2 = new Node<>("item2");
        item1.next = item2;
        Node<String> item3 = new Node<>("item3");
        item2.next = item3;
        Node<String> item4 = new Node<>("item4");
        item3.next = item4;
        Node<String> item5 = new Node<>("item5");
        item4.next = item5;
        Node<String> item6 = new Node<>("item6");
        item5.next = item6;
        Node<String> item7 = new Node<>("item7");
        item6.next = item7;
        item7.next = item2;
        System.out.println(isCycleUsingRace(head));
        System.out.println(isCycleByStoringPointers(head));
    }

    private static boolean isCycleByStoringPointers(Node head) {
        if (head == null) {
            return false;
        }
        Set<Node> nodes = new HashSet<>();
        Node current = head;
        nodes.add(current);
        while (current.next != null) {
            current = current.next;
            if (nodes.contains(current)) {
                return true;
            }
            nodes.add(current);
        }
        return false;
    }

    private static boolean isCycleUsingRace(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return data.equals(node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }
}
