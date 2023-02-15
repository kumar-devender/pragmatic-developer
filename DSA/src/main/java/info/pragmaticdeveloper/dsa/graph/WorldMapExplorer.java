package info.pragmaticdeveloper.dsa.graph;

import java.util.HashSet;
import java.util.Set;

public class WorldMapExplorer {

    public int countCountries(final int[][] arr) {
        final Set<String> visited = new HashSet<>();
        int count = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                count += explore(arr, visited, arr[row][col], row, col);
            }
        }
        return count;
    }

    public int countCountriesIterative(final int[][] arr) {
        final Set<String> visited = new HashSet<>();
        int count = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (isSameCountryBoundary(arr, arr[row][col], row - 1, col)
                        && isSameCountryBoundary(arr, arr[row][col], row, col - 1)) {
                    String key = row + "," + col;
                    System.out.println(key);
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isSameCountryBoundary(final int[][] arr, int target, int row, int col) {
        boolean rowBound = row >= 0 && row < arr.length;
        boolean colBound = col >= 0 && col < arr[0].length;
        if (!rowBound || !colBound) {
            return true;
        }
        return target != arr[row][col];
    }

    private int explore(final int[][] arr, final Set<String> visited, int target, int row, int col) {
        boolean rowBound = row >= 0 && row < arr.length;
        boolean colBound = col >= 0 && col < arr[0].length;
        if (!rowBound || !colBound) {
            return 0;
        }
        String key = col + "," + row;

        if (visited.contains(key)) {
            return 0;
        }

        if (target != arr[row][col]) {
            return 0;
        }

        visited.add(key);
        explore(arr, visited, target, row - 1, col);
        explore(arr, visited, target, row + 1, col);
        explore(arr, visited, target, row, col - 1);
        explore(arr, visited, target, row, col + 1);
        return 1;
    }
}
