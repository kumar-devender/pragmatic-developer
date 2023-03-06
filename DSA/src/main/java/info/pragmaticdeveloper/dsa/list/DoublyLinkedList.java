package info.pragmaticdeveloper.dsa.list;

public class DoublyLinkedList<T> {
    private Node head;
    private int size;

    public class Node {
        private T data;
        private Node nextNode;
        private Node preNode;
    }

    public int getSize() {
        return size;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        // point new node next to current head
        newNode.nextNode = head;
        // point new node as previous of head
        if (head != null)
            head.preNode = newNode;
        // now head will point to new node
        head = newNode;
        size++;
    }

    boolean isEmpty() {
        return head == null;
    }
}
