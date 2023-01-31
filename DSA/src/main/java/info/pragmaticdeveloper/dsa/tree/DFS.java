package info.pragmaticdeveloper.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public List<Node> dfsIterative(Node root) {
        return traverseIterative(root);
    }

    public List<Node> dfsRecursive(Node root) {
        List<Node> traverseResult = new ArrayList<>();
        dfsRecursive(root, traverseResult);
        return traverseResult;
    }

    private void dfsRecursive(Node root, List<Node> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        dfsRecursive(root.getLeft(), nodes);
        dfsRecursive(root.getRight(), nodes);
    }

    private List<Node> traverseIterative(Node root) {
        List<Node> nodes = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            nodes.add(current);
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
        return nodes;
    }
}
