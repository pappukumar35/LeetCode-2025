package January;

import java.util.Arrays;

public class Palindromic_Subsequences {
     public int countPalindromicSubsequence(String s) {
          int n = s.length();
          int[] first = new int[26];
          int[] last = new int[26];
          Arrays.fill(first, n);
          Arrays.fill(last, -1);

          for (int i = 0; i < n; ++i) {
               int c = s.charAt(i) - 'a';
               first[c] = Math.min(first[c], i);
               last[c] = Math.max(last[c], i);
          }

          boolean[][] used = new boolean[26][26];
          int ans = 0;

          for (int i = 0; i < n; ++i) {
               for (int j = 0; j < 26; ++j) {
                    if (first[j] < i && i < last[j]) {
                         if (!used[j][s.charAt(i) - 'a'])
                              ans++;
                         used[j][s.charAt(i) - 'a'] = true;
                    }
               }
          }
          return ans;
     }

     public static void main(String[] args) {

     }
}