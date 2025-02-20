package Febreary;

import java.util.*;

public class unique {
     public String findDiffernetBinaryString(String[] nums) {
          StringBuffer sb = new StringBuffer();
          for (int i = 0; i < nums.length; i++) {
               sb.append(nums[i].charAt(i) == '0' ? "1" : "0");
          }
          return sb.toString();
     }

     public static void main(String[] args) {

     }
}