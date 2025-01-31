package January;

public class Large_Island {
     private int[] parent;
     private int[] size;
     private int[][] dirs = { { 0, 1 }, { 1, 0 } }; // Right and Down directions for union steps

     public int largestIsland(int[][] grid) {
          int n = grid.length;
          parent = new int[n * n];
          size = new int[n * n];
          int maxSize = 0;

          // Initialize each cell to be its own parent with size 1
          for (int i = 0; i < n * n; i++) {
               parent[i] = i;
               size[i] = 1;
          }

          // Union adjacent 1s (checking right and down directions)
          for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                         int idx = i * n + j;
                         // Check right and down neighbors
                         for (int[] dir : dirs) {
                              int x = i + dir[0];
                              int y = j + dir[1];
                              if (x < n && y < n && grid[x][y] == 1) {
                                   int neighborIdx = x * n + y;
                                   union(idx, neighborIdx);
                              }
                         }
                         // Update the maximum island size after unions
                         maxSize = Math.max(maxSize, size[find(idx)]);
                    }
               }
          }

          // If all cells are 1, return the grid size
          if (maxSize == n * n) {
               return maxSize;
          }

          int result = maxSize;
          // Directions for checking all four neighbors around a 0 cell
          int[][] checkDirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

          // Evaluate each 0 cell
          for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                         int[] roots = new int[4]; // Store up to 4 unique roots
                         int count = 0;
                         int currentPotential = 1;

                         for (int[] dir : checkDirs) {
                              int x = i + dir[0];
                              int y = j + dir[1];
                              if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                                   int root = find(x * n + y);
                                   boolean exists = false;
                                   for (int k = 0; k < count; k++) {
                                        if (roots[k] == root) {
                                             exists = true;
                                             break;
                                        }
                                   }
                                   if (!exists) {
                                        roots[count++] = root;
                                        currentPotential += size[root];
                                   }
                              }
                         }

                         result = Math.max(result, currentPotential);
                    }
               }
          }

          return result;
     }

     private int find(int x) {
          if (parent[x] != x) {
               parent[x] = find(parent[x]); // Path compression
          }
          return parent[x];
     }

     private void union(int x, int y) {
          int rootX = find(x);
          int rootY = find(y);
          if (rootX != rootY) {
               // Union by size
               if (size[rootX] < size[rootY]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
               } else {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
               }
          }
     }

     public static void main(String[] args) {

     }
}