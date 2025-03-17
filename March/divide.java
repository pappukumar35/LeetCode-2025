package March;

public class divide {
     public boolean DivideArray(int[] nums) {
          int freq[] = new int[501];
          for (int num : nums)
               freq[num]++;
          for (int num : nums)
               if (freq[num] % 2 == 1)
                    return false;
          return true;
     }

     public static void main(String[] args) {

     }
}