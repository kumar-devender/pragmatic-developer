package info.pragmaticdeveloper.dsa.graph;

import java.util.HashSet;
import java.util.Set;

public class IslandExplorer {
    public int islandCount(char[][] grid) {
        int count = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (explore(grid, i, j, visited)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int minIslandSize(char[][] grid) {
        int minIslandSize = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 'W') {
                    int currentIslandSize = exploreMinSizeIsland(grid, i, j, visited);
                    if (currentIslandSize != 0) {
                        minIslandSize = Math.min(minIslandSize, currentIslandSize);
                    }
                }
            }
        }
        return minIslandSize;
    }

    private int exploreMinSizeIsland(char[][] grid, int row, int col, Set<String> visited) {
        String pos = String.format("%d,%d", row, col);
        boolean rowInBound = row >= 0 && row < grid.length;
        boolean colInBound = col >= 0 && col < grid[0].length;

        if (!rowInBound || !colInBound) {
            return 0;
        }

        if (grid[row][col] == 'W') {
            return 0;
        }

        if (visited.contains(pos)) {
            return 0;
        }
        visited.add(pos);
        int size = 1;
        size += exploreMinSizeIsland(grid, row - 1, col, visited);
        size += exploreMinSizeIsland(grid, row + 1, col, visited);
        size += exploreMinSizeIsland(grid, row, col - 1, visited);
        size += exploreMinSizeIsland(grid, row, col + 1, visited);
        return size;
    }

    private boolean explore(char[][] grid, int row, int col, Set<String> visited) {
        String pos = String.format("%d,%d", row, col);
        boolean rowInBound = row >= 0 && row < grid.length;
        boolean colInBound = col >= 0 && col < grid[0].length;

        if (!rowInBound || !colInBound) {
            return false;
        }

        if (grid[row][col] == 'W') {
            return false;
        }

        if (visited.contains(pos)) {
            return false;
        }
        visited.add(pos);
        explore(grid, row - 1, col, visited);
        explore(grid, row + 1, col, visited);
        explore(grid, row, col - 1, visited);
        explore(grid, row, col + 1, visited);
        return true;
    }
}
