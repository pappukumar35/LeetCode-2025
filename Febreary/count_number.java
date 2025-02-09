package Febreary;

import java.util.HashMap;
import java.util.Map;

public class count_number {
     public long countBadPairs(int[] nums) {
          int n = nums.length;
          Map<Integer, Integer> map = new HashMap<>();

          // Populate the map with value minus index counts
          for (int i = 0; i < n; i++) {
               map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
          }
          // Formula: Please re-arrange it
          // j - i != nums[j] - nums[i].
          // nums[i] - i = nums[j] - j

          long cntGoodPair = 0;
          // Count good pairs using the combination formula
          for (Map.Entry<Integer, Integer> enty : map.entrySet()) {
               int key = enty.getKey();
               int val = enty.getValue();
               if (val >= 2) {
                    cntGoodPair += (long) val * (val - 1) / 2;
               }
          }

          return (long) (n - 1) * n / 2 - cntGoodPair; // BadPair = TotalPair - GoodPair
     }

     public static void main(String args[]) {

     }
}