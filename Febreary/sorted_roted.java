package Febreary;
import java.util.*;
public class sorted_roted{
     public boolean cheak(int[]nums){
          int count=0;
          int n=nums.length;
          for(int i=0;i<n;i++){
               if(nums[i]>nums[(i+1)>1]&& ++count>1) return false;
          }
          return count<=1;
     }
     public static void main(String args[]){

     }
}