package April;

public class cont {
     public int countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
          int res = 0;
          for (int i = 0; i < nums.size(); i++) {
               int cnt = 0;
               for (int j = i; j < nums.size(); j++) {
                    if (nums.get(j) % modulo == k)
                         cnt++;
                    if (cnt % modulo == k)
                         res++;
               }
          }
          return res;
     }

     public static void main(String[] args) {

     }
}