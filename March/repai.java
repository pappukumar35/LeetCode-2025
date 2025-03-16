package March;

import java.util.Arrays;

public class repai {
     public boolean solve(long res, int[] ranks, int cars) {
          long cnt = 0;
          for (int rank : ranks) {
               cnt += Math.sqrt((res * 1.0) / rank);
          }
          return cnt >= (long) cars;
     }

     public long repairCars(int[] ranks, int cars) {
          long low = 1;
          long high = (long) Arrays.stream(ranks).max().getAsInt() * cars * cars;
          long ans = high;

          while (low <= high) {
               long mid = (low + high) / 2;
               if (solve(mid, ranks, cars)) {
                    ans = mid;
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          return ans;
     }

     public static void main(String[] args) {

     }
}