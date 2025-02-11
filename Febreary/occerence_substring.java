package Febreary;

import java.util.*;

public class occerence_substring {
     public String removeOccurrences(String s, String part) {
          StringBuilder word = new StringBuilder(s);
          int i = 0, targetLength = part.length();

          while (i < word.length()) {
               if (getMatch(word, part, i)) {
                    word.delete(i, i + targetLength);
                    i = Math.max(0, i - targetLength);
               } else {
                    i++;
               }
          }
          return word.toString();
     }

     private boolean getMatch(StringBuilder word, String part, int s) {
          if (word.length() < part.length())
               return false;
          for (int i = 0; i < part.length(); i++) {
               if (s + i >= word.length() || word.charAt(s + i) != part.charAt(i))
                    return false;
          }
          return true;
     }

     public static void main(String[] args) {

     }
}