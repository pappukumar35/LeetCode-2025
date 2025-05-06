package may;

public class buildArray {
     public static int[] buildArray(int[] nums) {
          int n = nums.length;
          int[] res = new int[n];
          for (int i = 0; i < n; i++) {
               res[i] = nums[nums[i]];
          }
          return res;
     }

     public static void main(String[] args) {

     }
}