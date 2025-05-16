package may;
public class longest{
      public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) 
    {
        int n = words.length;
        
        // Step 1: Build directed graph with edges from i to j where j > i
        // and conditions on group difference, same length, hamming distance 1.
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (words[i].length() == words[j].length() &&
                    groups[i] != groups[j] &&
                    hamming(words[i], words[j]) == 1) 
                    {
                        graph[i].add(j);
                    }
            }
        }

        // Step 2: Prepare arrays for memoization and path reconstruction
        int[] dp = new int[n];          // dp[i] = length of longest subsequence starting at i
        Arrays.fill(dp, -1);            // -1 means not computed yet
        int[] parent = new int[n];      // parent[i] = next node on longest path from i
        Arrays.fill(parent, -1);

        int maxLen = 0;
        int startNode = 0;

        // Step 3: Run DFS for all nodes to find the overall longest subsequence
        for (int i = 0; i < n; i++) 
        {
            int len = dfs(i, graph, dp, parent);
            if (len > maxLen) 
            {
                maxLen = len;
                startNode = i;
            }
        }

        // Step 4: Reconstruct subsequence by following parent pointers
        List<String> result = new ArrayList<>();
        int curr = startNode;
        while (curr != -1) 
        {
            result.add(words[curr]);
            curr = parent[curr];
        }

        return result;
    }

    // DFS function to compute longest path starting from 'node'
    private int dfs(int node, List<Integer>[] graph, int[] dp, int[] parent) 
    {
        if (dp[node] != -1)
        {
            return dp[node];  // If already computed, return it
        } 
        
        int maxLen = 1;       // Minimum path length is 1 (the node itself)
        int nextNode = -1;    // To track which neighbor gives max path
        
        // Explore all neighbors reachable from current node
        for (int nei : graph[node]) 
        {
            int len = 1 + dfs(nei, graph, dp, parent); // 1 for current node + neighbor's longest path
            if (len > maxLen) 
            {
                maxLen = len;
                nextNode = nei;
            }
        }
        
        dp[node] = maxLen;
        parent[node] = nextNode;
        return maxLen;
    }

    // Helper to compute Hamming distance, returns number of different chars
    private int hamming(String a, String b) 
    {
        int count = 0;
        for (int i = 0; i < a.length(); i++) 
        {
            if (a.charAt(i) != b.charAt(i))
            {
                count++;
            } 
            
            if (count > 1)
            {
                return 2;  // early exit if more than 1 difference
            } 
        }
        
        return count;
    }
     public static void main(String[] args) {
          
     }
}