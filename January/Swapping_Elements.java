package January;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Swapping_Elements {
     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
          HashMap<Integer, List<Integer>> index = new HashMap<>();

          for (int i = 0; i < nums.length; i++) {
               index.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
          }

          Arrays.sort(nums);
          int[] ans = new int[nums.length];

          List<Integer> temp = new ArrayList<>();

          for (int i = 0; i < nums.length; i++) {
               if (temp.isEmpty()) {
                    temp.add(nums[i]);
               } else {
                    if (nums[i] - temp.getLast() <= limit) {
                         temp.add(nums[i]);
                    } else {
                         helper(temp, index, ans);
                         temp = new ArrayList<>();
                         temp.add(nums[i]);
                    }
               }
          }

          helper(temp, index, ans);

          return ans;
     }

     private void helper(List<Integer> temp, HashMap<Integer, List<Integer>> index, int[] ans) {
          List<Integer> indexes = new ArrayList<>();
          List<Integer> values = new ArrayList<>();

          for (int it : temp) {
               for (int idx : index.getOrDefault(it, new ArrayList<>())) {
                    indexes.add(idx);
                    values.add(it);
               }

               index.remove(it);
          }

          Collections.sort(indexes);

          for (int i = 0; i < indexes.size(); i++) {
               ans[indexes.get(i)] = values.get(i);
          }
     }

     public static void main(String[] args) {

     }
}