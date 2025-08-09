package main.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    // An enum to clearly choose the traversal strategy.
    public enum TraversalStrategy {
        DFS,
        BFS
    }

    /**
     * Calculates the number of islands using the specified traversal strategy.
     */
    public int numIslands(char[][] grid, TraversalStrategy strategy) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islandCount = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Start a traversal only if the cell is land and has not been visited.
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // Choose which traversal to run based on the input strategy.
                    if (strategy == TraversalStrategy.DFS) {
                        dfs(grid, visited, i, j);
                    } else { // Default to BFS
                        bfs(grid, visited, i, j);
                    }
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    /**
     * Depth-First Search.
     */
    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        // Base Case: Stop if out of bounds, already visited, or on water.
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] == '0') {
            return;
        }

        visited[r][c] = true; // Mark as visited.

        // Explore neighbors.
        dfs(grid, visited, r + 1, c);
        dfs(grid, visited, r - 1, c);
        dfs(grid, visited, r, c + 1);
        dfs(grid, visited, r, c - 1);
    }

    /**
     * Breadth-First Search.
     */
    private void bfs(char[][] grid, boolean[][] visited, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll();
            int row = currentCell[0];
            int column = currentCell[1];

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : directions) {
                int newR = row + dir[0];
                int newC = column + dir[1];

                if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && !visited[newR][newC] && grid[newR][newC] == '1') {
                    visited[newR][newC] = true;
                    queue.add(new int[]{newR, newC});
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands islandFinder = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        // --- Run with BFS ---
        // Note: We create a copy of the grid if we want to run both tests on the same initial data,
        // but since our methods no longer modify the grid, it's not necessary here.
        System.out.println("--- Using BFS ---");
        System.out.println("Grid 1 output is " + islandFinder.numIslands(grid, TraversalStrategy.BFS)); // Expected: 1

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Grid 2 output is " + islandFinder.numIslands(grid2, TraversalStrategy.BFS)); // Expected: 3
        System.out.println("-----------------");

        // --- Run with DFS ---
        System.out.println("\n--- Using DFS ---");
        System.out.println("Grid 1 output is " + islandFinder.numIslands(grid, TraversalStrategy.DFS)); // Expected: 1
        System.out.println("Grid 2 output is " + islandFinder.numIslands(grid2, TraversalStrategy.DFS)); // Expected: 3
        System.out.println("-----------------");
    }
}