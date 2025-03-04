package March;

public class tree {
     public boolean checkPowersOfThree(int n) {
          int cap = 16; // The upper limit for powers of three, as 3^15 is a large number
          int[] arr = new int[cap];

          // Populate the array with powers of three
          for (int i = 0; i < cap; i++) {
               arr[i] = (int) Math.pow(3, i);
          }

          // Iterate through the array from the largest power of three to the smallest
          for (int i = cap - 1; i >= 0; i--) {
               // If the current power of three is less than or equal to n, subtract it from n
               if (n >= arr[i]) {
                    n -= arr[i];
               }

               // If n becomes zero, return true
               if (n == 0) {
                    return true;
               }
          }

          return false;
     }

     public static void main(String[] args) {

     }
}