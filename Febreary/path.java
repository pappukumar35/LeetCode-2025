package Febreary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class path {
     public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
          int n = amount.length;
          tree = new ArrayList<>();
          bobPath = new HashMap<>();
          visited = new boolean[n];
          for (int i = 0; i < n; i++) {
               tree.add(new ArrayList<>());
          }

          // Form tree with edges
          for (int[] edge : edges) {
               tree.get(edge[0]).add(edge[1]);
               tree.get(edge[1]).add(edge[0]);
          }

          // Find the path taken by Bob to reach node 0 and the times it takes to get
          // there
          findBobPath(bob, 0);

          // Find Alice's optimal path
          Arrays.fill(visited, false);
          findAlicePath(0, 0, 0, amount);

          return maxIncome;
     }

     private Map<Integer, Integer> bobPath;
     private boolean[] visited;
     private List<List<Integer>> tree;
     private int maxIncome = Integer.MIN_VALUE;

     // Depth First Search to find Bob's path
     private boolean findBobPath(int sourceNode, int time) {
          // Mark and set time node is reached
          bobPath.put(sourceNode, time);
          visited[sourceNode] = true;

          // Destination for Bob is found
          if (sourceNode == 0) {
               return true;
          }

          // Traverse through unvisited nodes
          for (int adjacentNode : tree.get(sourceNode)) {
               if (!visited[adjacentNode] && findBobPath(adjacentNode, time + 1)) {
                    return true;
               }
          }

          // If node 0 isn't reached, remove current node from path
          bobPath.remove(sourceNode);
          return false;
     }

     // Depth First Search to find Alice's optimal path
     private void findAlicePath(
               int sourceNode,
               int time,
               int income,
               int[] amount) {
          // Mark node as explored
          visited[sourceNode] = true;

          // Alice reaches the node first
          if (!bobPath.containsKey(sourceNode) || time < bobPath.get(sourceNode)) {
               income += amount[sourceNode];
          }
          // Alice and Bob reach the node at the same time
          else if (time == bobPath.get(sourceNode)) {
               income += amount[sourceNode] / 2;
          }

          // Update max value if current node is a new leaf
          if (tree.get(sourceNode).size() == 1 && sourceNode != 0) {
               maxIncome = Math.max(maxIncome, income);
          }

          // Traverse through unvisited nodes
          for (int adjacentNode : tree.get(sourceNode)) {
               if (!visited[adjacentNode]) {
                    findAlicePath(adjacentNode, time + 1, income, amount);
               }
          }
     }

     public static void main(String args[]) {

     }
}