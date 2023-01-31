package info.pragmaticdeveloper.dsa.tree;

public class BST {

    public boolean isBalancedByHeightCheckOnEachLevel(Node root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public boolean isBalancedByRecursiveSubtreesHeight(Node root) {
        if (root == null) {
            return true;
        }
        int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
        if (Math.abs(heightDiff) > 1) {
            return false;
        }
        return isBalancedByRecursiveSubtreesHeight(root.getLeft()) && isBalancedByRecursiveSubtreesHeight(root.getRight());
    }

    private int checkHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int leftSide = checkHeight(root.getLeft());
        if (leftSide == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightSide = checkHeight(root.getRight());
        if (rightSide == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(leftSide - rightSide) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftSide, rightSide) + 1;
    }

    private int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }

    public boolean check(Node node) {
        return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(Node root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (root.getData() < min || root.getData() > max) {
            return false;
        }

        return checkBST(root.getLeft(), min, root.getData() - 1)
                && checkBST(root.getRight(), root.getData() + 1, max);
    }
}
