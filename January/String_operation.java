package January;

import java.util.*;

public class String_operation {

     public int minimumLength(String s) {
          int[] freq = new int[26];
          int count = 0;
          for (int i = 0; i < s.length(); i++) {
               int n = s.charAt(i) - 'a';
               freq[n]++;
               if (freq[n] > 2 && freq[n] % 2 == 1) {
                    count += 2;
               }
          }
          return s.length() - count;
     }

     public static void main(String[] args) {

     }
}