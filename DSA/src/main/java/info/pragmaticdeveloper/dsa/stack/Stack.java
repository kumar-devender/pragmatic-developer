package info.pragmaticdeveloper.dsa.stack;

public class Stack<T> {
    private Node<T> top;

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("devender");
        stack.push("kumar");
        stack.push("yadav");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push("Astha");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T t) {
        Node<T> node = new Node<>(t);
        node.prev = top;
        top = node;
    }

    public T peek() {
        return top.data;
    }

    public T pop() {
        T item = top.data;
        top = top.prev;
        return item;
    }

    private class Node<T> {
        private final T data;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }
}
