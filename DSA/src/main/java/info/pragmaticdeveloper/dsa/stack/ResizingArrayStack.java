package info.pragmaticdeveloper.dsa.stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] items = (Item[]) new Object[1];
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        if (n == items.length) {
            reSize(items.length * 2);
        }
        items[n++] = item;
    }

    public Item pop() {
        Item item = items[--n];
        items[n] = null;
        if (n > 0 && n == items.length / 4) {
            reSize(items.length / 2);
        }
        return item;
    }

    private void reSize(int max) {
        Item[] tempItems = (Item[]) new Object[max];
        for (int index = 0; index < n; index++) {
            tempItems[index] = items[index];
        }
        items = tempItems;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseResizingIterator();
    }

    private class ReverseResizingIterator implements Iterator<Item> {
        int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return items[--i];
        }
    }

}
