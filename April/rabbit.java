package April;

public class rabbit {
     public int numRabbits(int[] answers) {
          Map<Integer, Integer> count = new HashMap<>();
          int result = 0;

          for (int ans : answers) {
               count.put(ans, count.getOrDefault(ans, 0) + 1);
          }

          for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
               int x = entry.getKey(); // each rabbit says "x"
               int freq = entry.getValue(); // how many rabbits gave this answer
               int groupSize = x + 1;
               int groups = (freq + groupSize - 1) / groupSize; // ceiling division
               result += groups * groupSize;
          }

          return result;
     }

     public static void main(String[] args) {

     }
}