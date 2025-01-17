package January;

import java.util.*;

public class BitwiseXor {
     public boolean doesValidArrayExist(int[] derived) {
          int xorSum = 0; // Initialize XOR sum
          for (int n : derived) {
               xorSum ^= n;
          }
          return xorSum == 0;
     }

     public static void main(String[] args) {

     }
}