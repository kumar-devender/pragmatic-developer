package info.pragmaticdeveloper.dsa.list;

import java.util.Iterator;

public class StackWithLinkedList<Item> implements Iterable<Item> {
    private Node last;
    private int n;

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = last;
        last = node;
        n++;
    }

    public Item pop() {
        Item item = last.item;
        last = last.next;
        n--;
        return item;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackWithLinkedListIterator();
    }

    private class StackWithLinkedListIterator implements Iterator<Item> {
        private Node current = last;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        private Node next;
        private Item item;
    }
}
