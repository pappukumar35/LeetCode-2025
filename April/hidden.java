package April;

public class hidden {
     public int numberOfArrays(int[] differences, int lower, int upper) {
          long left = lower;
          long right = upper;

          long cumulativeDiff = 0;
          for (int i = 0; i < differences.length; i++) {
               cumulativeDiff += differences[i];
               left = Math.max(left, lower - cumulativeDiff);
               right = Math.min(right, upper - cumulativeDiff);
          }
          int count = (int) (right - left + 1);
          return count < 0 ? 0 : count;
     }

     public static void main(String[] args) {

     }
}