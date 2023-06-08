package info.pragmaticdeveloper.cache;

public class DoublyLinkedList<K, V> {
    private Node<K, V> front;
    private Node<K, V> rear;

    void addToFront(Node<K, V> node) {
        if (rear == null) {
            rear = node;
            front = node;
            return;
        }

        node.setNext(front);
        node.setPrev(null);
        front.setPrev(node);
        front = node;
    }

    public Node<K, V> getRear() {
        return rear;
    }

    public void removeLast() {
        if (rear == null) {
            return;
        }
        if (rear == front) {
            rear = front = null;
            return;
        }
        rear = rear.getPrev();
        rear.setNext(null);
    }

    public void moveToFirst(Node<K, V> target) {
        // target is already at front
        if (target == front) {
            return;
        }
        //target is last node then current rear previous will be rear after operation
        if (target == rear) {
            rear = rear.getPrev();
            rear.setNext(null);
        } else {
            // node is in the middle
            target.getPrev().setNext(target.getNext());
            target.getNext().setPrev(target.getNext());
        }
        addToFront(target);
    }
}
