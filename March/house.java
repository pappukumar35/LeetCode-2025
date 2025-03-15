package March;

public class house {
     public int minCapability(int[] nums, int k) {
          int l = 1, r = 1000000000;
          while (l < r) {
               int m = (l + r) / 2, t = 0, i = 0;
               for (; i < nums.length && t < k; i += nums[i] <= m ? 2 : 1)
                    t += nums[i] <= m ? 1 : 0;
               if (t < k)
                    l = m + 1;
               else
                    r = m;
          }
          return l;
     }

     public static void main(String[] args) {

     }
}