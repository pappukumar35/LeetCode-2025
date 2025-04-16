package April;

import java.util.HashMap;

public class numberNount {
     public long countGood(int[] nums, int k) {
          int n = nums.length;
          int i = 0, j = 0;
          long result = 0, pairs = 0;

          HashMap<Integer, Integer> map = new HashMap<>();

          while (j < n) {
               // Step 1: Count pairs formed by nums[j]
               pairs += map.getOrDefault(nums[j], 0);

               // Step 2: Update frequency map
               map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

               // Step 3: Check if current window has >= k good pairs
               while (pairs >= k) {
                    // Step 3a: Add subarrays count
                    result += (n - j);

                    // Step 3b: Shrink window from the left
                    map.put(nums[i], map.get(nums[i]) - 1);
                    pairs -= map.get(nums[i]);
                    i++;
               }

               j++;
          }

          return result;
     }

     public static void main(String[] args) {

     }
}