package info.pragmaticdeveloper;

import java.util.*;
import java.util.stream.Collectors;

public class RelationshipsAnalyzer {

    public boolean hasCommonAncestor(int[][] arr, int node1, int node2) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Pair pair = new Pair(arr[i][0], arr[i][1]);
            pairs.add(pair);
        }
        List<Integer> node1Ancestor = new ArrayList<>();
        List<Integer> node2Ancestor = new ArrayList<>();
        addParentInList(node1Ancestor, pairs, node1);
        addParentInList(node2Ancestor, pairs, node2);
        return node1Ancestor.stream()
                .anyMatch(node2Ancestor::contains);
    }

    private void addParentInList(List<Integer> parents, List<Pair> pairs, int node) {
        List<Pair> parentChildPair = pairs.stream()
                .filter(pair -> pair.child == node && !parents.contains(pair.parent))
                .collect(Collectors.toList());
        if (parentChildPair.isEmpty()) {
            return;
        }
        parentChildPair.forEach(pair -> {
            parents.add(pair.parent);
            addParentInList(parents, pairs, pair.parent);
        });
    }

    public List<Integer> getWithSingleParent(int arr[][]) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i][1])) {
                List<Integer> list = map.get(arr[i][1]);
                list.add(arr[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i][0]);
                map.put(arr[i][1], list);
            }
        }

        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Integer> getWithZeroParent(int arr[][]) {
        Set<Integer> left = new HashSet<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            right.add(arr[i][1]);
            left.add(arr[i][0]);
        }

        return left.stream()
                .filter(item -> !right.contains(item))
                .collect(Collectors.toList());
    }

    private static class Pair {
        int parent;
        int child;

        Pair(int parent, int child) {
            this.parent = parent;
            this.child = child;
        }
    }

}
