package April;

public class tript {
     public long maximumTripletValue(int[] nums) {
          int n = nums.length;
          int[] leftMax = new int[n];
          int[] rightMax = new int[n];

          leftMax[0] = nums[0];
          for (int i = 1; i < n; i++) {
               leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
          }

          rightMax[n - 1] = nums[n - 1];
          for (int k = n - 2; k >= 0; k--) {
               rightMax[k] = Math.max(rightMax[k + 1], nums[k]);
          }

          long maxValue = 0;
          for (int j = 1; j < n - 1; j++) {
               long value = (long) (leftMax[j - 1] - nums[j]) * rightMax[j + 1];
               maxValue = Math.max(maxValue, value);
          }

          return maxValue;
     }

     public static void main(String args[]) {

     }
}