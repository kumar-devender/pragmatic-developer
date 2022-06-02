package info.pragmaticdeveloper.dsa.client.list;

import info.pragmaticdeveloper.dsa.list.QueueWithLinkedList;

public class QueueWithLinkedListClient {
    public static void main(String[] args) {
        QueueWithLinkedList<String> queue = new QueueWithLinkedList<>();
        queue.enqueue("Devender");
        queue.enqueue("Kumar");
        queue.enqueue("Yadav");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
