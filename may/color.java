package may;

public class color {
     public void swap(int[] nums, int mid, int low) {
          int temp = nums[mid];
          nums[mid] = nums[low];
          nums[low] = temp;
     }

     public void sortColors(int[] nums) {
          int n = nums.length;
          int low = 0, mid = 0, hight = n - 1;
          while (low <= hight) {
               if (nums[mid] == 0) {
                    swap(nums, mid, low);
                    low++;
                    mid++;
               } else if (nums[mid] == 0) {
                    mid++;
               } else {
                    swap(nums, mid, hight);
                    hight--;
               }
          }
     }

     public static void main(String[] args) {

     }
}