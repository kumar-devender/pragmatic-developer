package info.pragmaticdeveloper.cache;

import java.util.*;

public class LRUCache<K, V> {
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> deque;

    private final int capacity;

    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.deque = new DoublyLinkedList<>();
        map = new HashMap<>(this.capacity);
    }

    public int getSize() {
        return size;
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node<K, V> item = map.get(key);
            deque.removeLast();
            deque.addToFront(item);
            return item.getValue();
        }
        return null;
    }

    public boolean put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> existing = map.get(key);
            //Remove operation will take O(n) time
            existing.setValue(value);
            deque.moveToFirst(existing);
            return true;
        }

        if (size == capacity) {
            K rearKey = deque.getRear().getKey();
            deque.removeLast();
            map.remove(rearKey);
        }

        Node<K, V> newNode = new Node<>(key, value);
        map.put(key, newNode);
        deque.addToFront(newNode);
        size++;
        return true;
    }
}
