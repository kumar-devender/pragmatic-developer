package info.pragmaticdeveloper;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("hello");
        queue.enqueue("world");
        System.out.println(queue.peek());
        queue.enqueue("Devender");
        queue.enqueue("Kumar");
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
    }

    //FIFO
    private static class MyQueue<T> {
        //LIFO
        private final Stack<T> stackNewest = new Stack<>();
        private final Stack<T> stackOldest = new Stack<>();

        public T peek() {
            shiftStack();
            return stackOldest.peek();
        }

        private void shiftStack() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public void enqueue(T item) {
            stackNewest.push(item);
        }

        public T dequeue() {
            shiftStack();
            return stackOldest.pop();
        }
    }
}
