package April;

import java.util.*;

public class equals {
     public int countPairs(int[] nums, int k) {
          Map<Integer, Map<Integer, Integer>> moduloMap = new HashMap<>();
          int res = 0;

          for (int i = 0; i < nums.length; i++) {
               int mod_i = i % k;
               int num = nums[i];

               if (moduloMap.containsKey(num)) {
                    for (Map.Entry<Integer, Integer> entry : moduloMap.get(num).entrySet()) {
                         int mod_j = entry.getKey();
                         int count = entry.getValue();
                         if ((mod_i * mod_j) % k == 0) {
                              res += count;
                         }
                    }
               }

               moduloMap.putIfAbsent(num, new HashMap<>());
               Map<Integer, Integer> innerMap = moduloMap.get(num);
               innerMap.put(mod_i, innerMap.getOrDefault(mod_i, 0) + 1);
          }

          return res;
     }

     public static void main(String args[]) {

     }
}