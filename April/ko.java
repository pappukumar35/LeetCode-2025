package April;
public class ko{
     public long countSubarrays(int[] nums, long k) 
     {
         // Step 0 : Initiaze the Pointers and Trackers
         int n = nums.length;
         long result = 0; 
         long sum = 0;    
 
         int i = 0; // Left pointer of the window
         int j = 0; // Right pointer of the window
 
         // Step 1: Expand the window by moving 'j'
         while (j < n) 
         {
             sum += nums[j]; // Include current element in the sum
 
             // Step 2: Shrink the window from the left if condition is violated
             while (i <= j && sum * (j - i + 1) >= k) 
             {
                 sum -= nums[i]; // Remove element at 'i' from sum
                 i++;            // Move left pointer forward
             }
 
             // Step 3: For current j, count all valid subarrays ending at j
             result += (j - i + 1);
 
             j++; // Move right pointer forward
         }
 
         // Step 4: Return the total count
         return result;
     }
     public static void main(String[] args) {
          
     }
}