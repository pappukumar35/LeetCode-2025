package January;

import java.util.*;

public class Maximun_Number {
     public int findMaxFish(int[][] grid) {
          int res = 0;
          int m = grid.length, n = grid[0].length;

          for (int i = 0; i < m; i++) {
               for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) {
                         res = Math.max(res, dfs(i, j, grid, m, n));

                    }
               }
          }

          return res;
     }

     private int dfs(int r, int c, int[][] grid, int m, int n) {
          if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
               return 0;

          int sum = 0, temp = grid[r][c];

          grid[r][c] = 0;

          sum += dfs(r, c + 1, grid, m, n);
          sum += dfs(r + 1, c, grid, m, n);
          sum += dfs(r, c - 1, grid, m, n);
          sum += dfs(r - 1, c, grid, m, n);

          return sum + temp;
     }

     public static void main(String[] args) {

     }

}