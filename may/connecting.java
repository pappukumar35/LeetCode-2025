package may;

public class connecting {
     public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
          int n = edges1.length + 1, m = edges2.length + 1;
          List<Integer>[] g1 = new List[n], g2 = new List[m];
          for (int i = 0; i < n; i++)
               g1[i] = new ArrayList<>();
          for (int i = 0; i < m; i++)
               g2[i] = new ArrayList<>();
          for (int[] e : edges1) {
               g1[e[0]].add(e[1]);
               g1[e[1]].add(e[0]);
          }
          for (int[] e : edges2) {
               g2[e[0]].add(e[1]);
               g2[e[1]].add(e[0]);
          }
          int[] p1 = new int[n], p2 = new int[m];
          int[] c1 = new int[2], c2 = new int[2];
          bfs(g1, p1, c1);
          bfs(g2, p2, c2);
          int best2 = Math.max(c2[0], c2[1]);
          int[] ans = new int[n];
          for (int i = 0; i < n; i++)
               ans[i] = c1[p1[i]] + best2;
          return ans;
     }

     private void bfs(List<Integer>[] g, int[] parity, int[] cnt) {
          int N = g.length;
          boolean[] vis = new boolean[N];
          int[] q = new int[N];
          int head = 0, tail = 0;
          q[tail++] = 0;
          vis[0] = true;
          parity[0] = 0;
          cnt[0] = 1;
          while (head < tail) {
               int u = q[head++];
               for (int v : g[u])
                    if (!vis[v]) {
                         vis[v] = true;
                         parity[v] = parity[u] ^ 1;
                         cnt[parity[v]]++;
                         q[tail++] = v;
                    }
          }
     }

     public static void main(String[] args) {

     }
}