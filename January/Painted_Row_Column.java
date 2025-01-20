package January;

import java.util.HashMap;
import java.util.*;

public class Painted_Row_Column {
     public int firstCompleteIndex(int[] arr, int[][] mat) {

          int[] row = new int[mat[0].length];
          int[] col = new int[mat.length];
          HashMap<Integer, int[]> map = new HashMap<>();
          for (int i = 0; i < mat.length; ++i) {
               for (int j = 0; j < mat[0].length; ++j) {
                    map.put(mat[i][j], new int[] { i, j });
               }
          }
          for (int i = 0; i < arr.length; ++i) {
               int[] a = map.get(arr[i]);
               row[a[1]]++;
               col[a[0]]++;
               if (row[a[1]] == mat.length)
                    return i;
               if (col[a[0]] == mat[0].length)
                    return i;
          }
          return -1;
     }

     public static void main(String[] args) {

     }
}