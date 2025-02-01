package Febreary;

import java.util.*;

public class specialArray {
     public static boolean isArraySpecial(int[] nums) {
          if (nums.length == 1) {
               return true;
          }
          for (int i = 0; i < nums.length - 1; i++) {
               if ((nums[i] & 1) == (nums[i + 1] & 1)) {
                    return false;
               }
          }
          return true;
     }

     public static void main(String[] args) {

     }
}