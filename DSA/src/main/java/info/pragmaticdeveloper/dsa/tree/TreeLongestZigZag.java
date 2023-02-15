package info.pragmaticdeveloper.dsa.tree;

public class TreeLongestZigZag {

    int longestZigZagLength(Node root) {
        return exploreLeft(root, 0);
    }

    private int exploreLeft(Node root, int dir) {
        if (root == null) {
            return 0;
        }
        int left = exploreLeft(root.getLeft(), -1);
        int right = exploreLeft(root.getRight(), 1);
        if ((dir == -1)) {
            return right + 1;
        }
        if ((dir == 1)) {
            return left + 1;
        }
        return Math.max(left, right) + 1;
    }
}
