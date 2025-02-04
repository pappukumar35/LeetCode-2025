package Febreary;
import java.util.*;
public class Ascending_subArray{
     public int maxAscendingSum(int[] nums){
          int max=nums[0];
          int curmax=nums[0];
          for(int i=1;i<nums.length;i++){
               if(nums[i-1]<nums[i]){
                    currmax=currmax+nums[i];
               }
               else{
                    max=Math.max(max,currmax);
                    currmax=nums[i];
               }
          }
          max=Math.max(max,currmax);
          return max;
     }
     public static void main(String args[]){

     }
}