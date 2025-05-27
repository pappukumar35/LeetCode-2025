package may;

public class diff {
     public static int differenceOfSum(int n, int m) {
          int sum = 0;
          for (int i = 1; i <= n; i++) {
               if (i % m == 0) {
                    sum -= i;
               } else {
                    sum += i;
               }
          }
          return sum;
     }

     public static void main(String[] args) {

     }
}