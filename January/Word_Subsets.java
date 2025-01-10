package January;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Word_Subsets {
     private boolean isSubset(int[] temp, int[] maxFreq) {
          for (int i = 0; i < 26; i++) {
               if (temp[i] < maxFreq[i]) {
                    return false;
               }
          }
          return true;
     }

     public List<String> wordSubsets(String[] words1, String[] words2) {
          int[] maxFreq = new int[26];
          for (int i = 0; i < words2.length; i++) {
               int[] temp = new int[26];
               for (int j = 0; j < words2[i].length(); j++) {
                    temp[words2[i].charAt(j) - 'a']++;
               }
               for (int j = 0; j < 26; j++) {
                    maxFreq[j] = Math.max(maxFreq[j], temp[j]);
               }
          }
          List<String> ans = new ArrayList();
          for (int i = 0; i < words1.length; i++) {
               int[] temp = new int[26];
               for (int j = 0; j < words1[i].length(); j++) {
                    temp[words1[i].charAt(j) - 'a']++;
               }
               if (isSubset(temp, maxFreq)) {
                    ans.add(words1[i]);
               }
          }
          return ans;
     }

     public static void main(String[] args) {

     }
}