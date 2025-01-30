package January;
import java.util.*;
public class Maximum_Number_of_Groups {
     public int magnificentSets(int n, int[][] edges) {
          List<Integer> graph[] = new ArrayList[n + 1];
          for (int i = 0; i <= n; i++)
               graph[i] = new ArrayList<>();

          // Build the adjacency list
          for (int edge[] : edges) {
               graph[edge[0]].add(edge[1]);
               graph[edge[1]].add(edge[0]);
          }

          // Step 1: Check if the graph is bipartite
          int color[] = new int[n + 1];
          Arrays.fill(color, -1);
          List<List<Integer>> components = new ArrayList<>();

          for (int i = 1; i <= n; i++) {
               if (color[i] == -1) { // Unvisited node
                    List<Integer> component = new ArrayList<>();
                    if (!isBipartiteBFS(i, graph, color, component))
                         return -1;
                    components.add(component);
               }
          }

          // Step 2: Find the maximum BFS depth in each component
          int maxGroups = 0;
          for (List<Integer> component : components) {
               maxGroups += getMaxBFSDepth(component, graph);
          }

          return maxGroups;
     }

     // BFS to check bipartiteness and extract connected components
     private boolean isBipartiteBFS(int start, List<Integer> graph[], int color[], List<Integer> component) {
          Queue<Integer> queue = new LinkedList<>();
          queue.offer(start);
          color[start] = 0;
          component.add(start);

          while (!queue.isEmpty()) {
               int node = queue.poll();
               for (int neighbor : graph[node]) {
                    if (color[neighbor] == -1) { // Not visited
                         color[neighbor] = 1 - color[node]; // Alternate color
                         queue.offer(neighbor);
                         component.add(neighbor);
                    } else if (color[neighbor] == color[node]) {
                         return false; // Odd cycle detected, not bipartite
                    }
               }
          }
          return true;
     }

     // Get the max BFS depth for a given connected component
     private int getMaxBFSDepth(List<Integer> component, List<Integer> graph[]) {
          int maxDepth = 0;

          for (int node : component) {
               maxDepth = Math.max(maxDepth, bfsDepth(node, graph));
          }
          return maxDepth;
     }

     // BFS to calculate the maximum depth from a given node
     private int bfsDepth(int start, List<Integer> graph[]) {
          Queue<Integer> queue = new LinkedList<>();
          Map<Integer, Integer> depth = new HashMap<>();

          queue.offer(start);
          depth.put(start, 1);
          int maxDepth = 1;

          while (!queue.isEmpty()) {
               int node = queue.poll();
               for (int neighbor : graph[node]) {
                    if (!depth.containsKey(neighbor)) {
                         depth.put(neighbor, depth.get(node) + 1);
                         maxDepth = Math.max(maxDepth, depth.get(neighbor));
                         queue.offer(neighbor);
                    }
               }
          }
          return maxDepth;
     }

     public static void main(String[] args) {

     }
}