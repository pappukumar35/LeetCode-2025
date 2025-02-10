package Febreary;

import java.util.*;

public class digit {
     public String clearDigits(String s) {
          StringBuilder om = new StringBuilder();
          int i;
          for (i = 0; i < s.length(); i++) {
               if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    om.deleteCharAt(om.length() - 1);
               } else {
                    om.append(s.charAt(i));
               }
          }
          return om.toString();
     }

     public static void main(String ars[]) {

     }
}