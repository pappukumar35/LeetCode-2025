package may;

public class le {
     public int maxRemoval(int[] nums, int[][] queries) {
          int n = nums.length;
          int m = queries.length;
          int[] workload = new int[n + 1];

          Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));
          PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());

          int qIndex = 0;

          for (int time = 0; time < n; time++) {
               if (time > 0) {
                    workload[time] += workload[time - 1];
               }

               while (qIndex < m && queries[qIndex][0] == time) {
                    available.offer(queries[qIndex][1]);
                    qIndex++;
               }

               while (workload[time] < nums[time]) {
                    if (available.isEmpty() || available.peek() < time) {
                         return -1;
                    }

                    workload[time]++;
                    workload[available.poll() + 1]--;
               }
          }

          return available.size();
     }

     public static void main(String[] args) {

     }
}