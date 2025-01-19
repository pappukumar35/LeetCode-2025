package January;

import java.util.PriorityQueue;
import java.util.*;

public class Trapping_Rain_Water {
     class Pair {
          int height;
          int row;
          int col;

          public Pair(int height, int row, int col) {
               this.height = height;
               this.row = row;
               this.col = col;
          }
     }

     public int trapRainWater(int[][] heightMap) {
          int m = heightMap.length;
          int n = heightMap[0].length;

          PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

          boolean[][] visited = new boolean[m][n];

          for (int i = 0; i < n; i++) {
               pq.offer(new Pair(heightMap[0][i], 0, i));
               visited[0][i] = true;

               pq.offer(new Pair(heightMap[m - 1][i], m - 1, i));
               visited[m - 1][i] = true;
          }
          for (int i = 0; i < m; i++) {
               pq.offer(new Pair(heightMap[i][0], i, 0));
               visited[i][0] = true;

               pq.offer(new Pair(heightMap[i][n - 1], i, n - 1));
               visited[i][n - 1] = true;
          }

          int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

          int water = 0;

          while (!pq.isEmpty()) {
               Pair pair = pq.poll();
               int height = pair.height;
               int row = pair.row;
               int col = pair.col;

               for (int[] dir : direction) {
                    int newI = row + dir[0];
                    int newJ = col + dir[1];

                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]) {
                         int currHeight = 0;
                         if (heightMap[newI][newJ] < height) {
                              currHeight = height - heightMap[newI][newJ];
                         }
                         water += currHeight;
                         pq.offer(new Pair(Math.max(height, heightMap[newI][newJ]), newI, newJ));
                         visited[newI][newJ] = true;
                    }
               }
          }

          return water;
     }

     public static void main(String[] args) {

     }
}