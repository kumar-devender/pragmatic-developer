package info.pragmaticdeveloper.dsa.tree;

import java.util.*;

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

    public int[] levelOrder() {
        List<Integer> levelOrder = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            var current = queue.poll();
            levelOrder.add(current.getData());
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return levelOrder.stream().mapToInt(i -> i).toArray();
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
