package info.pragmaticdeveloper.dsa.tree;

import info.pragmaticdeveloper.dsa.stack.Stack;

public class Tree {
    public int maxRootToLeafSum(Node root) {
        return maxPathSum(root);
    }

    public int minElement(Node root) {
        return getMin(root);
    }

    public int sumAllNodeIterative(Node root) {
        int sum = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            sum += current.getData();
            if (current.getLeft() != null)
                stack.push(current.getLeft());
            if (current.getRight() != null)
                stack.push(current.getRight());
        }
        return sum;
    }

    public int minElementIterative(Node root) {
        return getMinIterative(root);
    }

    private int getMinIterative(Node root) {
        int min = Integer.MAX_VALUE;
        if (root == null) {
            return min;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (min > current.getData()) {
                min = current.getData();
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
        }
        return min;
    }

    private int getMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int currentMin = root.getData();
        int minChild = Math.min(getMin(root.getLeft()), getMin(root.getRight()));
        return Math.min(currentMin, minChild);
    }

    private int maxPathSum(Node root) {
        if (root == null) {
            return 0;
        }
        int current = root.getData();
        int leftSum = maxPathSum(root.getLeft());
        int rightSum = maxPathSum(root.getRight());
        current += Math.max(leftSum, rightSum);
        return current;
    }
}
