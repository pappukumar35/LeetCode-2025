package January;

import java.util.*;

public class Servers_that_Communicate {
     public int countServers(int[][] grid) {
          int n = grid.length;
          int m = grid[0].length;
          int row[] = new int[n];
          int col[] = new int[m];

          for (int i = 0; i < n; i++) {
               for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                         row[i]++;
                         col[j]++;

                    }
               }
          }
          int ans = 0;
          for (int i = 0; i < n; i++) {
               for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {

                         ans++;
                    }
               }
          }

          return ans;
     }

     public static void main(String[] args) {

     }
}