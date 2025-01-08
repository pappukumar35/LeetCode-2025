package January;

import java.util.*;

public class Prefix_and_Suffix_Pairs {
     public int countPrefixSuffixPairs(String[] words) {
          int ans = 0, n = words.length;
          for (int i = 0; i < n - 1; i++) {
               for (int j = i + 1; j < n; j++) {
                    if (isPrefixAndSuffix(words[i], words[j])) {
                         ans++;
                    }
               }
          }
          return ans;
     }

     boolean isPrefixAndSuffix(String first, String second) {
          return second.startsWith(first) && second.endsWith(first);
     }

     public static void main(String[] args) {

     }
}