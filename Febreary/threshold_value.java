package Febreary;

import java.util.*;
import java.util.PriorityQueue;

public class threshold_value {
     public int minOperatiom(int[] nums, int k) {
          PriorityQueue<Long> pq = new PriorityQueue<>();
          for (int num : nums)
               pq.offer((long) num);
          int op = 0;
          while (pq.size() >= 2) {
               long x = pq.poll();
               if (x >= k)
                    break;
               long y = pq.poll();
               long res = Math.min(x, y) * 2 + Math.min(x, y);
               pq.offer(res);
               op++;
          }
          return op;
     }

     public static void main(String[] args) {

     }
}