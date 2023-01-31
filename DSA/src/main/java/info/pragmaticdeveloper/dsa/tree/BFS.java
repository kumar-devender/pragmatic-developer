package info.pragmaticdeveloper.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public boolean isExist(Node root, int value) {
        return check(root, value);
    }

    private boolean check(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.getData() == value) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.getData() == value) {
                return true;
            }
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return false;
    }

    public List<Node> bfsIterative(Node root) {
        List<Node> traverseList = new ArrayList<>();
        if (root == null) {
            return traverseList;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            traverseList.add(current);
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return traverseList;
    }
}
