package info.pragmaticdeveloper.dsa.list;

import java.util.Iterator;

public class SimpleList<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    public void insertAtEnd(Item item) {
        Node node = new Node();
        node.item = item;
        if (isFirstNode()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        n++;
    }

    public void insertAtBeginning(Item item) {
        Node node = new Node();
        node.item = item;
        if (isFirstNode()) {
            last = node;
        } else {
            node.next = first;
        }
        first = node;
        n++;
    }

    private boolean isFirstNode() {
        return first == null && last == null;
    }

    public Item removeFirst() {
        if (first == null) {
            return null;
        }
        Node node = first;
        first = first.next;
        n--;
        return node.item;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new SimpleListIterator();
    }

    private class SimpleListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Node node = current;
            current = current.next;
            return node.item;
        }
    }

    private class Node {
        private Node next;
        private Item item;
    }
}
