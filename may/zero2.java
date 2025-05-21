package may;

public class zero2 {
     public void setZeroes(int[][] matrix) {
          HashSet<Integer> row = new HashSet<>();
          HashSet<Integer> col = new HashSet<>();
          int n = matrix.length;
          int m = matrix[0].length;
          for (int i = 0; i < n; i++) {
               for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                         row.add(i);
                         col.add(j);
                    }
               }
          }
          for (int i = 0; i < n; i++) {
               for (int j = 0; j < m; j++) {
                    if (row.contains(i) || col.contains(j)) {
                         matrix[i][j] = 0;
                    }
               }
          }
     }

     public static void main(String[] args) {

     }
}