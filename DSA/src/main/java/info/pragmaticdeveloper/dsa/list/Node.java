package info.pragmaticdeveloper.dsa.list;

public class Node {
    private int data;
    private Node next;

    public static void main(String[] args) {
        System.out.println(5/2);
    }

    public Node(int data) {
        this.data = data;
    }

    public Node insertAtTail(int d) {
        Node node = new Node(d);
        Node n = this;
        if (n.next != null) {
            n = n.next;
        }
        n.next = node;
        return node;
    }
}
