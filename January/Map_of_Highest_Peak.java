package January;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Map_of_Highest_Peak {

     public int[][] highestPeak(int[][] isWater) {
          // absolute height difference of atmost 1 means can be 0 or 1
          // 4 sides
          int[][] ans = new int[isWater.length][isWater[0].length];
          for (int[] a : ans)
               Arrays.fill(a, -1);
          // we know around water hieght can be 1 only
          // so we must do BFS which is multisource

          Queue<int[]> queue = new LinkedList();
          for (int i = 0; i < isWater.length; i++) {
               for (int j = 0; j < isWater[0].length; j++) {
                    if (isWater[i][j] == 1) {
                         queue.add(new int[] { i, j });
                         ans[i][j] = 0;
                    }
               }
          }
          int[][] directions = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
          int height = 1;
          while (!queue.isEmpty()) {
               int length = queue.size();

               for (int l = 0; l < length; l++) {
                    int[] a = queue.poll();
                    int i = a[0];
                    int j = a[1];

                    for (int k = 0; k < directions.length; k++) {
                         int newRow = i + directions[k][0];
                         int newCol = j + directions[k][1];

                         if (valid(isWater, newRow, newCol) && ans[newRow][newCol] == -1) {
                              ans[newRow][newCol] = (1 + ans[i][j]);
                              queue.add(new int[] { newRow, newCol });
                         }
                    }
               }
               height++;

          }
          return ans;

     }

     public static boolean valid(int[][] isWater, int i, int j) {
          if (i >= isWater.length || i < 0 || j >= isWater[0].length || j < 0)
               return false;
          return true;
     }

     public static void main(String[] args) {

     }
}