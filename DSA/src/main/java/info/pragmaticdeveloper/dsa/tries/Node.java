package info.pragmaticdeveloper.dsa.tries;

public class Node {
    private static final int NUMBER_OF_CHARS = 26;
    private final Node[] children = new Node[NUMBER_OF_CHARS];
    int size = 0;

    private static int getCharIndex(char c) {
        return c - 'a';
    }

    public Node getNode(char c) {
        return children[getCharIndex(c)];
    }

    public void setNode(char c, Node node) {
        children[getCharIndex(c)] = node;
    }

    public void add(String s) {
        add(s, 0);
    }

    private void add(String s, int index) {
        if (index == s.length()) {
            return;
        }
        size++;
        char current = s.charAt(index);
        Node child = getNode(current);
        if (child == null) {
            child = new Node();
            setNode(current, child);
        }
        child.add(s, index + 1);
    }

    public int find(String prefix) {
        return findCount(prefix, 0);
    }

    private int findCount(String s, int index) {
        if (s.length() == index) {
            return size;
        }

        Node node = getNode(s.charAt(index));
        if (node == null) {
            return 0;
        }
        return node.findCount(s, index + 1);
    }
}
