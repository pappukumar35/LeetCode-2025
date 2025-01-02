
import java.util.Set;

public class Strings_in_Ranges {
     public int[] vowelStrings(String[] words, int[][] queries) {
          int n = words.length;
          int[] pre = new int[n + 1];
          Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

          for (int i = 0; i < n; i++) {
               pre[i + 1] = pre[i];
               if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                    pre[i + 1]++;
               }
          }

          int[] ans = new int[queries.length];
          for (int i = 0; i < queries.length; i++) {
               ans[i] = pre[queries[i][1] + 1] - pre[queries[i][0]];
          }
          return ans;
     }

     public static void main(String args[]) {

     }
}