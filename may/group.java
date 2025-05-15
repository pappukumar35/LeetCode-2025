package may;

import java.util.ArrayList;
import java.util.List;

public class group {
     public List<String> getLongestSubsequence(String[] words, int[] groups) {
          List<String> result = new ArrayList<>();
          if (words.length == 0)
               return result;

          result.add(words[0]);
          int prevGroup = groups[0];

          for (int i = 1; i < words.length; i++) {
               if (groups[i] != prevGroup) {
                    result.add(words[i]);
                    prevGroup = groups[i];
               }
          }
          return result;
     }

     public static void main(String args[]) {

     }
}