package dfs;

public class LC200 {

    class Solution {
        int[] mov1 = new int[]{1, 0, -1, 0};
        int[] mov2 = new int[]{0, 1, 0, -1};

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int length = grid.length;
            int height = grid[0].length;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    visited[i][j] = false;
                }
            }
            int ans = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (grid[i][j] == '1') {
                        dfs(i, j, length, height, visited, grid, ans);
                        ans++;
                    }
                }
            }
            return ans;

        }

        private void dfs(int i, int j, int length, int height, boolean[][] visited, char[][] grid, int ans) {
            if (i < 0 || j < 0 || i >= length || j >= height || grid[i][j] != '1') {
                return;
            }

            grid[i][j] = '2';
            visited[i][j] = true;
            for (int m = 0; m < 4; m++) {
                dfs(i + mov1[m], j + mov2[m], length, height, visited, grid, ans);
            }

        }
    }
}
