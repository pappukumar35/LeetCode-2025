package April;

public class largest1 {
     public int countLargestGroup(int n) {
          // Step 1: Map to store count of each digit sum
          Map<Integer, Integer> digitSumCount = new HashMap<>();

          // Step 2: Calculate digit sum for each number and update count
          for (int i = 1; i <= n; i++) {
               int sum = getDigitSum(i);
               digitSumCount.put(sum, digitSumCount.getOrDefault(sum, 0) + 1);
          }

          // Step 3: Find the largest group size
          int maxSize = 0;
          for (int count : digitSumCount.values()) {
               maxSize = Math.max(maxSize, count);
          }

          // Step 4: Count how many groups have the largest size
          int result = 0;
          for (int count : digitSumCount.values()) {
               if (count == maxSize) {
                    result++;
               }
          }

          // Step 5: Return the result
          return result;
     }

     // Helper to compute digit sum
     private int getDigitSum(int num) {
          int sum = 0;
          while (num > 0) {
               sum += num % 10;
               num /= 10;
          }
          return sum;
     }

     public static void main(String[] args) {

     }
}