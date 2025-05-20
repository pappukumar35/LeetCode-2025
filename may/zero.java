package may;

public class zero {
     public boolean isZeroArray(int[] nums, int[][] queries) {
          // Step 1: Initialize a Difference Array
          int n = nums.length;
          int[] diff = new int[n + 1];

          // Step 2: Apply queries to diff array
          for (int[] query : queries) {
               int start = query[0], end = query[1];
               diff[start]--;
               if (end + 1 < n) {
                    diff[end + 1]++;
               }
          }

          // Step 3: Apply cumulative changes to nums
          int curr = 0;
          for (int i = 0; i < n; i++) {
               curr += diff[i];
               nums[i] += curr;

               if (nums[i] > 0) {
                    return false;
               }
          }

          // Step 4: All elements are ≤ 0
          return true;
     }

     public static void main(String[] args) {

     }
}