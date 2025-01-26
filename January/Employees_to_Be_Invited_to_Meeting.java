package January;

import java.util.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Employees_to_Be_Invited_to_Meeting {
     public int maximumInvitations(int[] favorite) {
          return Math.max(maxCycle(favorite), topologicalSort(favorite));
     }

     private int maxCycle(int[] fav) {
          int n = fav.length;
          boolean[] vis = new boolean[n];
          int ans = 0;
          for (int i = 0; i < n; ++i) {
               if (vis[i]) {
                    continue;
               }
               List<Integer> cycle = new ArrayList<>();
               int j = i;
               while (!vis[j]) {
                    cycle.add(j);
                    vis[j] = true;
                    j = fav[j];
               }
               for (int k = 0; k < cycle.size(); ++k) {
                    if (cycle.get(k) == j) {
                         ans = Math.max(ans, cycle.size() - k);
                    }
               }
          }
          return ans;
     }

     private int topologicalSort(int[] fav) {
          int n = fav.length;
          int[] indeg = new int[n];
          int[] dist = new int[n];
          Arrays.fill(dist, 1);
          for (int v : fav) {
               indeg[v]++;
          }
          Deque<Integer> q = new ArrayDeque<>();
          for (int i = 0; i < n; ++i) {
               if (indeg[i] == 0) {
                    q.offer(i);
               }
          }
          int ans = 0;
          while (!q.isEmpty()) {
               int i = q.pollFirst();
               dist[fav[i]] = Math.max(dist[fav[i]], dist[i] + 1);
               if (--indeg[fav[i]] == 0) {
                    q.offer(fav[i]);
               }
          }
          for (int i = 0; i < n; ++i) {
               if (i == fav[fav[i]]) {
                    ans += dist[i];
               }
          }
          return ans;
     }

     public static void main(String[] args) {

     }
}