package March;

import java.util.*;

public class label {
     public List<Integer> partitionLabels(String s) {
          Map<Character, Integer> lastOccurrence = new HashMap<>();
          for (int i = 0; i < s.length(); i++) {
               lastOccurrence.put(s.charAt(i), i);
          }

          List<Integer> result = new ArrayList<>();
          int start = 0, end = 0;

          for (int i = 0; i < s.length(); i++) {
               end = Math.max(end, lastOccurrence.get(s.charAt(i)));
               if (i == end) {
                    result.add(end - start + 1);
                    start = i + 1;
               }
          }

          return result;
     }

     public static void main(String[] args) {

     }
}