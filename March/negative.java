package March;

public class negative {
     public int maximumCount(int[] nums) {
          int neg = 0;
          int pos = 0;
          for (int i : nums) {
               if (i > 0) {
                    pos++;
               }
               if (i < 0) {
                    neg++;
               }
          }
          if (pos > neg)
               return pos;
          else
               return neg;
     }

     public static void main(String[] args) {

     }
}