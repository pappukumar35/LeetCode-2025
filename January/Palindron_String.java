package January;

import java.util.*;

public class Palindron_String {

     public boolean canConstruct(String s, int k) {
          int n = s.length();
          if (n == k)
               return true;
          if (k > n)
               return false;
          int count[] = new int[26];
          for (char c : s.toCharArray())
               count[c - 'a']++;
          int odd = 0;
          for (int x : count) {
               if (x % 2 == 1)
                    odd++;
          }
          return odd <= k;
     }

     public static void main(String[] args) {

     }
}