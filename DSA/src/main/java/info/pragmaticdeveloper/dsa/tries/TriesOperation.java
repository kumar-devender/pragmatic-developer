package info.pragmaticdeveloper.dsa.tries;

import java.util.Arrays;

public class TriesOperation {
    private final Node root = new Node();

    public void add(String[] names) {
        Arrays.asList(names)
                .forEach(root::add);
        System.out.println(root);
    }

    public int find(String prefix) {
        return root.find(prefix);
    }
}
