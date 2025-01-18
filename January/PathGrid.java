package January;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.*;

public class PathGrid {
     public int minCost(int[][] grid) {
          int n = grid.length;
          int m = grid[0].length;
          int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
          int[][] result = new int[n][m];

          for (int i = 0; i < n; i++) {
               Arrays.fill(result[i], Integer.MAX_VALUE);
          }

          PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
          pq.offer(new int[] { 0, 0, 0 });
          result[0][0] = 0;

          while (!pq.isEmpty()) {
               int[] top = pq.poll();
               int cost = top[0];
               int i = top[1];
               int j = top[2];
               // smalloptimization
               if (result[i][j] < cost)
                    continue;
               for (int x = 0; x < 4; x++) {
                    int new_i = i + dir[x][0];
                    int new_j = j + dir[x][1];

                    if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < m) {
                         int griddir = grid[i][j];
                         int dircost = (griddir - 1 != x) ? 1 : 0;
                         int newcost = cost + dircost;

                         if (newcost < result[new_i][new_j]) {
                              result[new_i][new_j] = newcost;
                              pq.offer(new int[] { newcost, new_i, new_j });
                         }
                    }
               }
          }

          return result[n - 1][m - 1];
     }

     public static void main(String[] args) {

     }
}