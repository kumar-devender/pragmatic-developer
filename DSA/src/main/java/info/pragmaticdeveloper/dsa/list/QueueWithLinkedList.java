package info.pragmaticdeveloper.dsa.list;

import java.util.Iterator;

public class QueueWithLinkedList<Item> implements Iterable<Item> {

    private Node first;
    private Node last;

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (last == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueWithLinkedListIterator();
    }

    private class QueueWithLinkedListIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }
    }

    private class Node {
        private Node next;
        private Item item;
    }
}
