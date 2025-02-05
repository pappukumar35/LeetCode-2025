package Febreary;
import java.util.*;
public class make_String_equal{
     public boolean areAlmostEqual(String s1, String s2) {
          char[] arr = s1.toCharArray();
          int x = -1;
          for (int i = 0; i < arr.length; i++) {
              if (arr[i] != s2.charAt(i)) {
                  if (x == -1) x = i;
                  else {
                      arr[i] = arr[x];
                      arr[x] = s2.charAt(i); // Direct swap check
                      return String.valueOf(arr).equals(s2);
                  }
              }
          }
          return s1.equals(s2);
      }
     public static void main(String args[]){

     }
}