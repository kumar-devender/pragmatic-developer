package info.pragmaticdeveloper.dsa.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinHeap<T extends Comparable> {
    private int size;
    private T[] items;
    private int capacity;

    private MinHeap() {
        // default constructor to avoid creating instance of unknown type
    }

    public MinHeap(Class<T> type, int size) {
        this.items = (T[]) Array.newInstance(type, size);
        this.capacity = size;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private T getLeftChild(int parentIndex) {
        return this.items[getLeftChildIndex(parentIndex)];
    }

    private T getRightChild(int parentIndex) {
        return this.items[getRightChildIndex(parentIndex)];
    }

    private T getParent(int childIndex) {
        return this.items[getParentIndex(childIndex)];
    }

    private void ensureExtraCapacity() {
        if (this.size == this.capacity) {
            this.capacity *= 2;
            this.items = Arrays.copyOf(items, this.capacity * 2);
        }
    }

    private void swap(int index1, int index2) {
        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return items[0];
    }

    public T poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index).compareTo(getLeftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index].compareTo(items[smallerChildIndex]) < 0) {
                break;
            }

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }

    }

    public void add(T item) {
        ensureExtraCapacity();
        items[size++] = item;
        heapifyUp();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index).compareTo(items[index]) > 0) {
            int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }
    }
}
