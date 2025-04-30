package April;

public class divide {
     public int findNumbers(int[] nums) {
          int count = 0;

          for (int num : nums) {
               // Convert the number to a string and check if the length is even.
               if (String.valueOf(num).length() % 2 == 0) {
                    count++;
               }
          }

          return count;

     }

     public static void main(String[] args) {

     }
}