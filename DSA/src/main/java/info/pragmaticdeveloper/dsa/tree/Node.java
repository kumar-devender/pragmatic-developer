package info.pragmaticdeveloper.dsa.tree;

public class Node {
    private int data;
    private Node left;
    private Node right;

    public void insert(int item) {
        if (data < item) {
            if (left == null) {
                left = new Node(item);
            } else {
                left.insert(item);
            }
        } else {
            if (right == null) {
                right = new Node(item);
            } else {
                right.insert(item);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }

    public boolean contains(int item) {
        if (item == data) {
            return true;
        } else if (item < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(item);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(item);
            }
        }
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
